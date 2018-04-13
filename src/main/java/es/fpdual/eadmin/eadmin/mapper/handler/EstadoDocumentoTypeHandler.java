package es.fpdual.eadmin.eadmin.mapper.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.*;
import org.apache.poi.ss.formula.functions.T;

import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public abstract class EstadoDocumentoTypeHandler implements TypeHandler<EstadoDocumento> {

	public void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
	
		
	}

	public EstadoDocumento getResult(ResultSet rs, String columnName) throws SQLException {
		return null;
	
	}

	public EstadoDocumento getResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	
	}

	public EstadoDocumento getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	
	}
}