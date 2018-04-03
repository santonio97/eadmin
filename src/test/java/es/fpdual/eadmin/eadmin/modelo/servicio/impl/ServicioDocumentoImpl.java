package es.fpdual.eadmin.eadmin.modelo.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.mockito.Mockito.*;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {

	private final RepositorioDocumento repositorioDocumento;

	ServicioDocumentoImpl servicioDocumento;
	
	private static final Documento DOCUMENTO = mock(Documento.class);
	
	@Autowired
	public ServicioDocumentoImpl (RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {
		final Documento documentoModificado = 
		this.obtenerDocumentoConFechaCorrecta(documento);
		repositorioDocumento.altaDocumento(documentoModificado);
		
		return documentoModificado;
	}

	@Override
	public Documento modificarDocumento(Documento documento) {

		final Documento documentoModificado = 
				obtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.modificarDocumento(documentoModificado);
		
		return documentoModificado;
	}

	protected Documento obtenerDocumentoConFechaCorrecta(Documento documento1) {

		return new DocumentoBuilder().clonar(documento1).conFechaCreacion(dameFechaActual()).construir();
	}

	protected Date dameFechaActual() {
		
		return new Date();
	}

	@Override
	public void eliminarDocumento(Documento documento) {
		repositorioDocumento.eliminarDocumento(1);
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		final Documento resultado = this.repositorioDocumento.obtenerDocumentoPorCodigo(codigo);
		return resultado;
	}
	
	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		
		return repositorioDocumento.obtenerTodosLosDocumentos();
	}
}