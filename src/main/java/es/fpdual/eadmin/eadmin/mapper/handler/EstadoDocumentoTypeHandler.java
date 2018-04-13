package es.fpdual.eadmin.eadmin.mapper.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.*;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public abstract class EstadoDocumentoTypeHandler implements TypeHandler<EstadoDocumento> {

	public void setParameter(PreparedStatement ps, int columnIndex, EstadoDocumento estadoDocumento, JdbcType jdbcType)
			throws SQLException {

		ps.setInt(columnIndex, estadoDocumento.getCodigo());
	}

	public EstadoDocumento getResult(ResultSet rs, String columnName) throws SQLException {

		return EstadoDocumento.obtenerPorCodigo(rs.getInt(columnName));
	}

	public EstadoDocumento getResult(ResultSet rs, int columnIndex) throws SQLException {
		return EstadoDocumento.obtenerPorCodigo(rs.getInt(columnIndex));

	}

	public EstadoDocumento getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return EstadoDocumento.obtenerPorCodigo(cs.getInt(columnIndex));

	}
}