package es.fpdual.eadmin.eadmin.modelo.servicio.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;
import es.fpdual.eadmin.eadmin.modelo.Documento;

public class ServicioDocumentoImplTest {

	private static final Documento DOCUMENTO = mock(Documento.class);

	private ServicioDocumento servicioDocumento;
	
	private RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	
	@Before
	public void inicializarEnCadaTest() {
		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
	}
	
	@Test
	public void deberiaAlmacenarDocumento() {
		this.servicioDocumento.altaDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).altaDocumento(DOCUMENTO);
		
	}
	
	@Test
	public void deberiaModificarDocumento() {
		when(DOCUMENTO.getNombre()).thenReturn("nombre");
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		when(DOCUMENTO.getFechaCreacion()).thenReturn(new Date(23/03/2018));
		
		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).modificarDocumento(DOCUMENTO);
		assertEquals(Integer.valueOf(1), resultado.getCodigo());
		assertEquals(resultado.getNombre(), DOCUMENTO.getNombre());
		assertEquals(resultado.getFechaCreacion(), DOCUMENTO.getFechaCreacion());
	}
	
	@Test
	public void deberiaEliminarDocumento() {
		
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		
		this.servicioDocumento.eliminarDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).eliminarDocumento(DOCUMENTO);
	}
}