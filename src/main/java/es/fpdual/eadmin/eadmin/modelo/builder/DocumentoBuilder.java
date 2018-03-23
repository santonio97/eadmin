package es.fpdual.eadmin.eadmin.modelo.builder;

import java.util.Date;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class DocumentoBuilder {

	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Boolean publico;
	protected EstadoDocumento estado;

	public Documento construir() {
		return new Documento(codigo, nombre, fechaCreacion, publico, estado);
	}

	public DocumentoBuilder conCodigo(Integer codigo) {
		this.codigo = codigo;
		return this;
	}

	public DocumentoBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public DocumentoBuilder conFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}

	public DocumentoBuilder conPublico(boolean publico) {
		this.publico = publico;
		return this;
	}

	public DocumentoBuilder conEstado(EstadoDocumento estadoDocumento) {
		this.estado = estadoDocumento;
		return this;
	}

	public DocumentoBuilder clonar(Documento documento) {
		this.codigo = documento.getCodigo();
		this.nombre = documento.getNombre();
		this.fechaCreacion = documento.getFechaCreacion();
		this.publico = documento.getPublico();
		this.estado = documento.getEstado();
		return this;
	}
}