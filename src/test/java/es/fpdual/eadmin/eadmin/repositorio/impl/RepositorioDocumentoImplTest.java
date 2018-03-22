package es.fpdual.eadmin.eadmin.repositorio.impl;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;

import static org.junit.Assert.assertTrue;

import java.util.*;

public class RepositorioDocumentoImplTest {

	private RepositorioDocumentoImpl repositorioDocumento;
	private static final Documento DOCUMENTO = new Documento(1, "nombre", new Date(), true, EstadoDocumento.ACTIVO);
	private static final Documento DOCUMENTO_1 = new Documento(null, null, null, null, null);

	@Before
	public void iniciarTest() {
		this.repositorioDocumento = new RepositorioDocumentoImpl();
	}

	@Test
	public void deberiaEliminarUnDocumento() {
		this.repositorioDocumento.getDocumentos().add(DOCUMENTO);
		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}

	@Test
	public void deberiaComprobarUnDocumentoNull() {
		// this.repositorioDocumento.getDocumentos().add(DOCUMENTO);
		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}

	
}
