package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends ModeloBaseDocumentacionElectronica {
	
	private final EstadoDocumento estado;

	public Documento(Integer codigo, String nombre, Date fechaCreacion,
			Boolean publico, EstadoDocumento estado, Date fechaUltimaModificacion) {
		super(codigo, nombre, fechaCreacion, publico, fechaUltimaModificacion);
		this.estado = estado;
	}

	public EstadoDocumento getEstado() {
		return this.estado;
	}

}