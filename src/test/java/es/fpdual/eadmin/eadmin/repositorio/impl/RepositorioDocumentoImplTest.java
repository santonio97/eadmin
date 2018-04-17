package es.fpdual.eadmin.eadmin.repositorio.impl;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.mapper.DocumentoMapper;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;

import java.util.*;

public class RepositorioDocumentoImplTest {

	private static final Date FECHA_CREACION = new Date();

	private static final Date FECHA_ULTIMA_MODIFICACION = new Date();

	private static final String NOMBRE_DOCUMENTO = "nombre";

	private static final boolean DOCUMENTO_PUBLICO = true;

	private static final Integer CODIGO_DOCUMENTO = 1;

	private RepositorioDocumentoImpl repositorioDocumento;

	private DocumentoMapper mapper;

	private final Documento documento = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION,
			DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO, FECHA_ULTIMA_MODIFICACION);

	@Before
	public void iniciarTest() {
		this.mapper = mock(DocumentoMapper.class);
		
		this.repositorioDocumento = new RepositorioDocumentoImpl(this.mapper);
	}

	@Test
	public void deberiaAlmacenarUnDocumento() {

		this.repositorioDocumento.altaDocumento(this.documento);

		verify(this.mapper).insertarDocumento(this.documento);
	}

	@Test
	public void deberiaModificarUnDocumento() {
		when(this.mapper.actualizarDocumento(this.documento)).thenReturn(1);

		this.repositorioDocumento.modificarDocumento(documento);

		verify(this.mapper).actualizarDocumento(this.documento);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deberiaLanzarExcepcionSiIntentamosModificarUnDocumentoQueNoExiste() {
		when(this.mapper.actualizarDocumento(this.documento)).thenReturn(0);

		this.repositorioDocumento.modificarDocumento(this.documento);
	}

	@Test
	public void deberiaEliminarUnDocumento() {

		this.repositorioDocumento.eliminarDocumento(this.documento.getCodigo());
		verify(this.mapper).eliminarDocumento(this.documento.getCodigo());
	}

	@Test
	public void deberiaObtenerDocumentoPorCodigo() {

		when(this.mapper.seleccionarDocumento(CODIGO_DOCUMENTO)).thenReturn(this.documento);

		final Documento resultado = this.repositorioDocumento.obtenerDocumentoPorCodigo(CODIGO_DOCUMENTO);

		assertThat(resultado, is(documento));
	}
	
	@Test
	public void deberiaObtenerTodosLosDocumentos() throws Exception {

		final List<Documento> todosLosDocumentos = Arrays.asList(this.documento);
		
		when(mapper.seleccionarTodosLosDocumentos()).thenReturn(todosLosDocumentos);
		
		final List<Documento> resultado = this.repositorioDocumento.obtenerTodosLosDocumentos();
		
		assertThat(resultado, hasSize(1));
		assertThat(resultado, hasItems(this.documento));
	}

}
