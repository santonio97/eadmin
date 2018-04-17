package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.mapper.DocumentoMapper;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private DocumentoMapper mapper;
	
	@Autowired
	public RepositorioDocumentoImpl(DocumentoMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public void altaDocumento(Documento documento) {
		
		this.mapper.insertarDocumento(documento);
	}

	@Override
	public void modificarDocumento(Documento documento) {
			
		int modificado = this.mapper.actualizarDocumento(documento);
		if (modificado == 0) {
			throw new IllegalArgumentException("No se puede modificar el documento porque no se encuentra.");
		}
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
	
		this.mapper.eliminarDocumento(codigo);
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		
		return this.mapper.seleccionarDocumento(codigo);
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {

		return this.mapper.seleccionarTodosLosDocumentos();
	}

	public static boolean exportExcel(String nombreHoja, Map<String, Object[]> data, String fileName) {

		// Creamos el libro de trabajo
		XSSFWorkbook libro = new XSSFWorkbook();

		// Creacion de Hoja
		XSSFSheet hoja = libro.createSheet(nombreHoja);

		// Iteramos el map e insertamos los datos
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// cramos la fila
			Row row = hoja.createRow(rownum++);
			// obtenemos los datos de la fila
			Object[] objArr = data.get(key);
			int cellnum = 0;
			// iteramos cada dato de la fila
			for (Object obj : objArr) {
				// Creamos la celda
				Cell cell = row.createCell(cellnum++);
				// Setteamos el valor con el tipo de dato correspondiente
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}

		try {
			// Escribimos en fichero
			FileOutputStream out = new FileOutputStream(new File(fileName));
			libro.write(out);
			// cerramos el fichero y el libro
			out.close();
			// libro.close();
			System.out.println("Excel exportado correctamente\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<String[]> importExcel(String fileName, int numColums) {

		// ArrayList donde guardaremos todos los datos del excel
		ArrayList<String[]> data = new ArrayList<>();

		try {
			// Acceso al fichero xlsx
			FileInputStream file = new FileInputStream(new File(fileName));

			// Creamos la referencia al libro del directorio dado
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Obtenemos la primera hoja
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterador de filas
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// Iterador de celdas
				Iterator<Cell> cellIterator = row.cellIterator();
				// contador para el array donde guardamos los datos de cada fila
				int contador = 0;
				// Array para guardar los datos de cada fila
				// y añadirlo al ArrayList
				String[] fila = new String[numColums];
				// iteramos las celdas de la fila
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Guardamos los datos de la celda segun su tipo
					switch (cell.getCellType()) {
					// si es numerico
					case Cell.CELL_TYPE_NUMERIC:
						fila[contador] = (int) cell.getNumericCellValue() + "";
						break;
					// si es cadena de texto
					case Cell.CELL_TYPE_STRING:
						fila[contador] = cell.getStringCellValue() + "";
						break;
					}
					// Si hemos terminado con la ultima celda de la fila
					if ((contador + 1) % numColums == 0) {
						// Añadimos la fila al ArrayList con todos los datos
						data.add(fila);
					}
					// Incrementamos el contador
					// con cada fila terminada al redeclarar arriba el contador,
					// no obtenemos excepciones de ArrayIndexOfBounds
					contador++;
				}
			}
			// Cerramos el fichero y workbook
			file.close();
			// workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Excel importado correctamente\n");

		return data;
	}

	public static void exportExcel(String nombreHoja, Documento documento, String fileName) {

		try {
			FileInputStream inputStream = new FileInputStream(new File(fileName));
			Workbook workbook = WorkbookFactory.create(inputStream);

			int numeroHoja;

			if (nombreHoja.equals("Documentos")) {
				numeroHoja = 0;
			} else if (nombreHoja.equals("Alta")) {
				numeroHoja = 1;
			} else if (nombreHoja.equals("Modificar")) {
				numeroHoja = 2;
			} else {
				numeroHoja = 3;
			}

			Sheet sheet = workbook.getSheetAt(numeroHoja);

			Object[] bookData = { documento.getCodigo(), documento.getNombre(), documento.getFechaCreacion().toString(),
					documento.getEstado().toString() };

			int rowCount = sheet.getLastRowNum();
			Row row = sheet.createRow(++rowCount);
			int columnCount = 0;

			Cell cell = row.createCell(columnCount);
			cell.setCellValue(rowCount);

			XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			for (Object field : bookData) {
				row.getCell(0).setCellStyle(style);
				cell = row.createCell(++columnCount);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(fileName);
			workbook.write(outputStream);
			//workbook.close();
			outputStream.close();

		} catch (IOException | EncryptedDocumentException | InvalidFormatException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void actualizarDocumento(Documento documento) {
		
	}

}