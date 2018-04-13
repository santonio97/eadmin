package es.fpdual.eadmin.eadmin.mapper;

import org.apache.ibatis.annotations.*;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface DocumentoMapper {

	int insertarDocumento(@Param("documento") Documento documento);

	int eliminarDocumento(@Param("documento") int codigo);
	
	int actualizarDocumento(@Param("documento") Documento doc);

	Documento seleccionarDocumento(@Param("codigo")int codigo);
}
