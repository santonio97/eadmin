package es.fpdual.eadmin.eadmin.mapper;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public abstract class BaseDocumentoMapperTest {

	private DocumentoMapper mapper;
	
	private Documento documento;
	
	@Before
	public void inicializarEnCadaTest() {
		this.documento = new Documento(1, "Documento1", new Date(), true, EstadoDocumento.ACTIVO, new Date());
	}
	@Test
	public void deberiaDeInsertarUnDocumento() throws Exception {
		final int resultado = this.mapper.insertarDocumento(this.documento);

		assertThat(resultado, is(1));
	}
}