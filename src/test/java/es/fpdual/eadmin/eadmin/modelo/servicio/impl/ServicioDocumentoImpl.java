package es.fpdual.eadmin.eadmin.modelo.servicio.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {

	RepositorioDocumento repositorioDocumento;

	@Autowired
	public ServicioDocumentoImpl (RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public void altaDocumento(Documento documento) {
		repositorioDocumento.altaDocumento(documento);
	}

	@Override
	public Documento modificarDocumento(Documento documento) {

		final Documento documentoModificado = obtenerDocumentoConFechaCorrecta(documento);
		this.repositorioDocumento.modificarDocumento(documentoModificado);
		return documentoModificado;
	}

	protected Documento obtenerDocumentoConFechaCorrecta(Documento documento1) {
//		return new Documento(documento1.getCodigo(), documento1.getNombre(),
//				dameFechaActual(), documento1.getPublico(), documento1.getEstado());

		return new DocumentoBuilder().clonar(documento1).conFechaCreacion(dameFechaActual()).construir();
	}

	protected Date dameFechaActual() {
		
		return new Date();
	}

	@Override
	public void eliminarDocumento(Documento documento) {
		repositorioDocumento.eliminarDocumento(1);
	}
}