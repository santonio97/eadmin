package es.fpdual.eadmin.eadmin.mapper;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.util.Utilidades;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

	private Documento documento;
	@Autowired
	private DocumentoMapper mapper;
	
	@Before
	public void inicializarEnCadaTest() {
		this.documento = new Documento(1, "Documento1",
				Utilidades.asDate(LocalDate.of(2015, 1, 1)),
				true, EstadoDocumento.ACTIVO, Utilidades.asDate(LocalDate.of(2015, 1, 1)));
	}
	
	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
	
	@Test
	public void deberiaDeInsertarUnDocumento() throws Exception {
		final int resultado = this.mapper.insertarDocumento(documento);

		assertThat(resultado, is(1));
	}
	
	@Test
	public void deberiaEliminarUnDocumento() throws Exception {
		
		this.mapper.insertarDocumento(this.documento);
		
		final int resultado = this.mapper.eliminarDocumento(1);
		
		assertThat(resultado, is(1));
	}
	
	@Test
	public void deberiaActualizarTodosLosCamposDeUnDocumento() throws Exception {
		final Documento documentoActualizado = new Documento(1, "Documento act",
				Utilidades.asDate(LocalDate.of(2015, 1, 1)),
				true, EstadoDocumento.ACTIVO, Utilidades.asDate(LocalDate.of(2015, 1, 1)));
		
		this.mapper.insertarDocumento(this.documento);
		
		final int resultado = this.mapper.actualizarDocumento(documentoActualizado);
		
		assertThat(resultado, is(1));
		final Documento documentoModificado = this.mapper.seleccionarDocumento(1);
		assertThat(documentoModificado, is(documentoActualizado));
	}

	@Test
	public void deberiaRecuperarTodosLosDocumentos() throws Exception {
		
		final Documento documentoSeleccionado = new Documento(2, "Documento2",
			Utilidades.asDate(LocalDate.of(2015, 2, 2)),
				true, EstadoDocumento.ACTIVO, Utilidades.asDate(LocalDate.of(2015, 2, 2)));

		this.mapper.insertarDocumento(this.documento);
		this.mapper.insertarDocumento(documentoSeleccionado);
		
		final List<Documento> resultado = this.mapper.seleccionarTodosLosDocumentos();

		assertThat(resultado, hasSize(2));
		assertThat(resultado, hasItems(this.documento, documentoSeleccionado));
	}
}