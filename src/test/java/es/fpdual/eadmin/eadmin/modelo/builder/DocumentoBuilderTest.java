package es.fpdual.eadmin.eadmin.modelo.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public class DocumentoBuilderTest {

	private Documento documento;
	
	@Before
	public void deberiaCrearUnDocumento() {
		documento = new DocumentoBuilder().conCodigo(1).conNombre("nombre")
				.conFechaCreacion(null).conPublico(false).conEstado(null)
				.conFechaUltimaModificacion(null).construir();
	}
	
	@Test
	public void deberiaClonarUnDocumento() {
		Documento documento2 = new DocumentoBuilder().clonar(documento).construir();
		
		assertEquals(documento.getCodigo(), documento2.getCodigo());
		assertEquals(documento.getNombre(), documento2.getNombre());
		assertEquals(documento.getFechaCreacion(), documento2.getFechaCreacion());
		assertEquals(documento.getPublico(), documento2.getPublico());
		assertEquals(documento.getEstado(), documento2.getEstado());
		assertEquals(documento.getFechaUltimaModificacion(), documento2.getFechaUltimaModificacion());
		
	}
}
