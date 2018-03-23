package es.fpdual.eadmin.eadmin.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.modelo.builder.ExpedienteBuilder;

public class ExpedienteBuilderTest {
	private Expediente expediente1;
	
	@Before
	public void deberiaCrearUnExpediente() {
		expediente1 = new ExpedienteBuilder().conCodigo(1).conNombre(null).conFechaCreacion(null).conPublico(true).conEstado(null).construir();
	}
	
	@Test
	public void deberiaClonarUnExpediente() {
		Expediente expediente2 = new ExpedienteBuilder().clonar(expediente1).construir();
		assertEquals(expediente2.getCodigo(), expediente1.getCodigo());
		assertEquals(expediente2.getNombre(), expediente1.getNombre());
		assertEquals(expediente2.getFechaCreacion(), expediente1.getFechaCreacion());
		assertEquals(expediente2.getFechaArchivado(), expediente1.getFechaArchivado());
		assertEquals(expediente2.getPublico(), expediente1.getPublico());
		assertEquals(expediente2.getEstado(), expediente1.getEstado());
	}
}
