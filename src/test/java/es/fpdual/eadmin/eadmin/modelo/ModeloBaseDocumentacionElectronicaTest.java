package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.util.AbstractoModeloBeanTest;

public class ModeloBaseDocumentacionElectronicaTest
		extends AbstractoModeloBeanTest<ModeloBaseDocumentacionElectronica> {
	private static final String nombreDocumento = "nombre";
	private static final boolean documentoPublico = true;
	private static final Integer codigoDocumento = 1;
	private static final Date fechaCreacion = new Date();
	private static final Date fechaUltimaModificacion = new Date();

	ModeloBaseDocumentacionElectronicaFake ModeloBaseDocumentacionElectronica = new ModeloBaseDocumentacionElectronicaFake(
			2, "nombre", new Date(), true, new Date());

	class ModeloBaseDocumentacionElectronicaFake extends ModeloBaseDocumentacionElectronica {

		public ModeloBaseDocumentacionElectronicaFake(Integer codigo, String nombre, Date fechaCreacion,
				Boolean publico, Date fechaUltimaModificacion) {
			super(codigo, nombre, fechaCreacion, publico, fechaUltimaModificacion);

		}
	}

	@Before
	public void iniciarCadaTest() {
		ModeloBaseDocumentacionElectronica = new ModeloBaseDocumentacionElectronicaFake(codigoDocumento,
				nombreDocumento, fechaCreacion, documentoPublico, fechaUltimaModificacion);
	}

	@Override
	public void before() {
		this.entityA1 = new ModeloBaseDocumentacionElectronicaFake(codigoDocumento, nombreDocumento, fechaCreacion,
				documentoPublico, fechaUltimaModificacion);
		this.entityA2 = new ModeloBaseDocumentacionElectronicaFake(codigoDocumento, nombreDocumento, fechaCreacion,
				documentoPublico, fechaUltimaModificacion);
		this.entityB = new ModeloBaseDocumentacionElectronicaFake(codigoDocumento, nombreDocumento, fechaCreacion,
				documentoPublico, null);
	}

	@Override
	public void deberiaInvocarLosMetodosGetModelo() {
		assertEquals(Integer.valueOf(codigoDocumento), this.entityA1.getCodigo());
		assertEquals(nombreDocumento, this.entityA1.getNombre());
		assertEquals(fechaCreacion, this.entityA1.getFechaCreacion());
		assertEquals(documentoPublico, this.entityA1.getPublico());
		assertEquals(fechaUltimaModificacion, this.entityA1.getFechaUltimaModificacion());

	}

	@Before
	public void inicializarCadaTest() {
		ModeloBaseDocumentacionElectronica = new ModeloBaseDocumentacionElectronicaFake(codigoDocumento,
				nombreDocumento, fechaCreacion, documentoPublico, fechaUltimaModificacion);
	}

//	@Test
//	public void pruebaDetoString() {
//		assertEquals(ModeloBaseDocumentacionElectronica.getCodigo(),
//				ModeloBaseDocumentacionElectronica.toString());
//	}
}
