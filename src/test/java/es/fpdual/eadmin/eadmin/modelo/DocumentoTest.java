package es.fpdual.eadmin.eadmin.modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

public class DocumentoTest {
	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	
	private Documento documento;
	
	@Before
	public void iniciarCadaTest() {
		documento = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO);
	}
	
	@Test
	public void deberiaComprobarGetters() {
		final Date fechaCreacion = new Date();
		final Documento documento = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO);
		
		assertEquals(Integer.valueOf(CODIGO_DOCUMENTO), documento.getCodigo());
		assertEquals(NOMBRE_DOCUMENTO, documento.getNombre());
		assertEquals(FECHA_CREACION, documento.getFechaCreacion());
		assertEquals(DOCUMENTO_PUBLICO, documento.getPublico());
		assertEquals(EstadoDocumento.ACTIVO, documento.getEstado());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final Documento documento2 = new Documento(CODIGO_DOCUMENTO, null, null, null, null);	
		assertEquals(true,documento.equals(documento2));
	}
	
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		final Documento documento2 = new Documento(5, null, null, null, null);
		final Boolean resultado = documento2.equals(documento);
		
		assertTrue(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		final Boolean resultado = documento.equals(new Date());
		assertTrue(resultado);
	}
	
	@Test
	public void pruebaDeltoString() {
		assertEquals("Documento con codigo" + documento.getCodigo(),documento.toString());
	}
}