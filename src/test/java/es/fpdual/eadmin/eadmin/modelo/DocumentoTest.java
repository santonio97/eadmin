package es.fpdual.eadmin.eadmin.modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

public class DocumentoTest {
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ULT_MODIFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	
	private Documento documento;
	
	@Before
	public void iniciarCadaTest() {
		documento = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO, FECHA_ULT_MODIFICACION);
	}
	
	@Test
	public void deberiaComprobarGetters() {
		new Date();
		final Documento documento = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO, FECHA_ULT_MODIFICACION);
		
		assertEquals(EstadoDocumento.ACTIVO, documento.getEstado());
	}
	
}
