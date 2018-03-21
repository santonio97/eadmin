package es.fpdual.eadmin.eadmin.modelo;

import java.util.List;
import java.util.Date;

public class Expediente {

	private Integer codigo;
	private String nombre;
	private Date fechaCreacion;
	private Date fechaArchivado;
	private Boolean publico;
	private EstadoExpediente estado;

	private List<Documento> documentos;

	public Expediente(Integer codigo, String nombre, Date fechaCreacion, Date fechaArchivado, Boolean publico,
			EstadoExpediente estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaArchivado = fechaArchivado;
		this.publico = publico;
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaArchivado() {
		return fechaArchivado;
	}

	public Boolean getPublico() {
		return publico;
	}

	public EstadoExpediente getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Expediente [codigo=" + codigo + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion
				+ ", fechaArchivado=" + fechaArchivado + ", publico=" + publico + ", estado=" + estado + ", documentos="
				+ documentos + "]";
	}

	@Override
	public int hashCode() {
		return codigo.hashCode() + nombre.hashCode() + fechaCreacion.hashCode() + fechaArchivado.hashCode()
				+ publico.hashCode() + estado.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expediente) {
			final Expediente expediente = (Expediente) obj;
			return expediente.codigo.equals(this.codigo);
		}
		return false;
	}

}