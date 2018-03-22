package es.fpdual.eadmin.eadmin.servicio;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumento {

	void altaDocumento(Documento documento);

	Documento modificarDocumento(Documento documento);

	void eliminarDocumento(Documento documento);
}
