package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;
import java.util.Optional;

public class Documento extends ModeloBaseDocumentacionElectronica {

	private final EstadoDocumento estado;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado,
			Date fechaUltimaModificacion) {
		super(codigo, nombre, fechaCreacion, publico, fechaUltimaModificacion);
		this.estado = estado;
	}

	public Documento(Integer codigo, String nombre, Date fechaCreacion,

			Boolean publico, Integer estado, Date fechaUltimaModificacion) {
		super(codigo, nombre, fechaCreacion, publico, fechaUltimaModificacion);

		switch (estado) {
		case 1:
			this.estado = EstadoDocumento.ACTIVO;
			break;
		case 2:
			this.estado = EstadoDocumento.APROBADO;
			break;
		case 3:
			this.estado = EstadoDocumento.ELIMINADO;
			break;
		default:
			this.estado = null;
			break;
		}
	}

	public EstadoDocumento getEstado() {
		return this.estado;
	}

	@Override
	public String toString() {
		return "Documento con codigo " + this.codigo;
	}

}