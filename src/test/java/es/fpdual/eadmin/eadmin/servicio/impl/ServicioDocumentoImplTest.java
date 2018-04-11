package es.fpdual.eadmin.eadmin.servicio.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumentoImpl;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class ServicioDocumentoImplTest {

	private static final Documento DOCUMENTO = mock(Documento.class);

	private ServicioDocumentoImpl servicioDocumento;
	
	private RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	
	@Before
	public void inicializarEnCadaTest() {
		this.servicioDocumento = spy(new ServicioDocumentoImpl(repositorioDocumento));
	}
	
	@Test
	public void deberiaAlmacenarDocumento() {
		final Documento documentoModificado = mock(Documento.class);
		
		doReturn(documentoModificado).
		when(this.servicioDocumento).
		obtenerDocumentoConFechaCorrecta(DOCUMENTO);
		
		final Documento resultado = 
				this.servicioDocumento.altaDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).altaDocumento(documentoModificado);
		assertSame(resultado, documentoModificado);
	}

	@Test
	public void deberiaModificarDocumento() {
		final Documento documentoModificado = mock(Documento.class);
		
		doReturn(documentoModificado).
		when(this.servicioDocumento).
		obtenerDocumentoConFechaCorrecta(DOCUMENTO);
		
		this.servicioDocumento.altaDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).altaDocumento(documentoModificado);
	}

	@Test
	public void deberiaEliminarDocumento() {
		
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		
		this.servicioDocumento.eliminarDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).eliminarDocumento(1);
	}
	
	@Test
	public void deberiaObtenerDocumentoPorCodigo() {
		
		when(this.repositorioDocumento.obtenerDocumentoPorCodigo(1)).thenReturn(DOCUMENTO);
		
		final Documento resultado = this.servicioDocumento.obtenerDocumentoPorCodigo(1);

		assertSame(DOCUMENTO, resultado);
	}
	
	@Test
	public void deberiaObtenerTodosLosDocumentos() {
		final List<Documento> documentos = new ArrayList<>();
		 
		when(this.repositorioDocumento.obtenerTodosLosDocumentos()).thenReturn(documentos);
		
		final List<Documento> resultado = this.servicioDocumento.obtenerTodosLosDocumentos();

		assertEquals(documentos, resultado);
	}
	
	@Test
	public void deberiaObtenerDocumentoConFechaCreacionCorrecta() {
		
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		when(DOCUMENTO.getNombre()).thenReturn("NOMBRE");
		when(DOCUMENTO.getPublico()).thenReturn(true);
		when(DOCUMENTO.getEstado()).thenReturn(EstadoDocumento.ACTIVO);
		when(DOCUMENTO.getFechaCreacion()).thenReturn(new Date(25/02/2018));
		
		final Documento resultado = this.servicioDocumento.obtenerDocumentoConFechaCorrecta(DOCUMENTO);
				
		assertEquals(resultado.getCodigo(), DOCUMENTO.getCodigo());
		assertEquals(resultado.getNombre(), DOCUMENTO.getNombre());
		assertEquals(resultado.getPublico(), DOCUMENTO.getPublico());
		assertEquals(resultado.getEstado(), DOCUMENTO.getEstado());
		assertNotEquals(resultado.getFechaCreacion(), new Date(25/03/2018));
		
	}
}