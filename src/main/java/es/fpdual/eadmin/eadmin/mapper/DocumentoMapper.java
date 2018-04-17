package es.fpdual.eadmin.eadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.mockito.stubbing.OngoingStubbing;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface DocumentoMapper {

	int insertarDocumento(@Param("documento") Documento documento);

	int eliminarDocumento(@Param("documento") int codigo);
	
	int actualizarDocumento(@Param("documento") Documento doc);

	Documento seleccionarDocumento(@Param("codigo")int codigo);

	List<Documento> seleccionarTodosLosDocumentos();

	int modificarDocumento(@Param("documento") Documento documento);

	int obtenerMaximoMas1();
}
