package es.fpdual.eadmin.eadmin.mapper;

import org.apache.ibatis.annotations.*;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface DocumentoMapper {

	int insertarDocumento(@Param("documento")Documento documento);
	
	
	
}
