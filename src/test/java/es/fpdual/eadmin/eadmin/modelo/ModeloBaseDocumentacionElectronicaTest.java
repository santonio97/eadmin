package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ModeloBaseDocumentacionElectronicaTest {
	private static final String nombreDocumento = "nombre";
	private static final boolean documentoPublico = true;
	private static final Integer codigoDocumento = 1;
	
	ModeloBaseDocumentacionElectronicaFake ModeloBaseDocumentacionElectronica = new ModeloBaseDocumentacionElectronicaFake(2, "nombre", new Date(), true, new Date());

	class ModeloBaseDocumentacionElectronicaFake extends ModeloBaseDocumentacionElectronica {

		public ModeloBaseDocumentacionElectronicaFake(Integer codigo, String nombre, Date fechaCreacion,
				Boolean publico, Date fechaUltimaModificacion) {
			super(codigo, nombre, fechaCreacion, publico, fechaUltimaModificacion);

		}

		@Before
		public void iniciarCadaTest() {
			ModeloBaseDocumentacionElectronica = new ModeloBaseDocumentacionElectronicaFake(codigoDocumento, nombreDocumento, fechaCreacion, documentoPublico, fechaCreacion);
		}
		
		@Test
		public void deberiaComprobarGetters() {
			final Date fechaCreacion = new Date();
			final ModeloBaseDocumentacionElectronica documento = new ModeloBaseDocumentacionElectronicaFake(codigoDocumento, nombreDocumento, fechaCreacion, documentoPublico, fechaUltimaModificacion);
			
			assertEquals(Integer.valueOf(codigoDocumento), documento.getCodigo());
			assertEquals(nombreDocumento, documento.getNombre());
			assertEquals(fechaCreacion, documento.getFechaCreacion());
			assertEquals(documentoPublico, documento.getPublico());
		}
		
		@Test
		public void deberiaDevolverTrueSiTienenIgualCodigo() {
			final Documento documento2 = new Documento(codigoDocumento, null, null, null, null, null);	
			assertEquals(true,ModeloBaseDocumentacionElectronica.equals(documento2));
		}
		
		@Test
		public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
			final Documento documento2 = new Documento(5, null, null, null, null, null);
			final Boolean resultado = documento2.equals(ModeloBaseDocumentacionElectronica);
			
			assertTrue(resultado);
		}
		
		@Test
		public void deberiaDevolverFalseSiNoEsUnDocumento() {
			final Boolean resultado = ModeloBaseDocumentacionElectronica.equals(new Date());
			assertTrue(resultado);
		}
		
		@Test
		public void pruebaDetoString() {
			assertEquals("Documento con codigo" + ModeloBaseDocumentacionElectronica.getCodigo(),ModeloBaseDocumentacionElectronica.toString());
		}
	}
}
