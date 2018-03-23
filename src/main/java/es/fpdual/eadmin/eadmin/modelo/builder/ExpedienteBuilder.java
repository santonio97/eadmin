package es.fpdual.eadmin.eadmin.modelo.builder;

import java.util.Date;

import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public class ExpedienteBuilder {

	protected Date fechaArchivado;
	protected EstadoExpediente estado;
	protected Integer codigo;
	protected String nombre;
	protected Boolean publico;
	
	public Expediente construir() {
		return new Expediente(codigo, nombre, fechaArchivado, publico, estado);
	}
	
	public ExpedienteBuilder conCodigo(Integer codigo) {
		this.codigo = codigo;
		return this;
	}

	public ExpedienteBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ExpedienteBuilder conFechaCreacion(Date fechaArchivado) {
		this.fechaArchivado = fechaArchivado;
		return this;
	}

	public ExpedienteBuilder conPublico(boolean publico) {
		this.publico = publico;
		return this;
	}

	public ExpedienteBuilder conEstado(EstadoExpediente estadoExpediente) {
		this.estado = estadoExpediente;
		return this;
	}
	
	public ExpedienteBuilder clonar(Expediente expediente) {
		this.codigo = expediente.getCodigo();
		this.nombre = expediente.getNombre();
		this.fechaArchivado = expediente.getFechaArchivado();
		this.publico = expediente.getPublico();
		this.estado = expediente.getEstado();
		return this;
	}
}
