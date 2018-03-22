package es.fpdual.eadmin.eadmin.repositorio;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface RepositorioDocumento {
	public abstract void altaDocumento (Documento documento);
	
	public abstract void modificarDocumento(Documento documento);
	
	public abstract void eliminarDocumento(Documento documento);

	void eliminarDocumento(Integer codigo);


}
