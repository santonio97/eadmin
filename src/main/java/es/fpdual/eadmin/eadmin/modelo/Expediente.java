package es.fpdual.eadmin.eadmin.modelo;

import java.util.List;
import java.util.Date;

public class Expediente extends ModeloBaseDocumentacionElectronica {
	private Date fechaArchivado;
	private EstadoExpediente estado;

	private List<Documento> documentos;

	public Expediente(Integer codigo, String nombre, Date fechaArchivado, Boolean publico, EstadoExpediente estado) {
		super(codigo, nombre, fechaArchivado, publico);
		this.fechaArchivado = fechaArchivado;
		this.estado = estado;
	}

	@Override
	public Integer getCodigo() {
		return codigo;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaArchivado() {
		return fechaArchivado;
	}

	@Override
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
			return codigo.equals(((Expediente)obj).getCodigo())
					&& nombre.equals(((Expediente)obj).getNombre())
					&& fechaCreacion.equals(((Expediente)obj).getFechaCreacion())
					&& fechaArchivado.equals(((Expediente)obj).getFechaArchivado())
					&& publico.equals(((Expediente)obj).getPublico())
					&& estado.equals(((Expediente)obj).getEstado());
		}
		return false;
	}

}