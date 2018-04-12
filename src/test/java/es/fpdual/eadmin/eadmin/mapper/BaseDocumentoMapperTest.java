package es.fpdual.eadmin.eadmin.mapper;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

@Transactional
public abstract class BaseDocumentoMapperTest {

	private Documento documento;
	@Autowired
	private DocumentoMapper mapper;
	
	@Before
	public void inicializarEnCadaTest() {
		this.documento = new Documento(1, "Documento1", new Date(),
				true, EstadoDocumento.ACTIVO, new Date());
	}
	
	@Test
	public void deberiaDeInsertarUnDocumento() throws Exception {
		final int resultado = this.mapper.insertarDocumento(documento);

		assertThat(resultado, is(1));
	}
}