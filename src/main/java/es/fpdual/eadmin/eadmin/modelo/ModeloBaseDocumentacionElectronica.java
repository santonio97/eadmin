package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class ModeloBaseDocumentacionElectronica {
	
	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Boolean publico;
	protected Date fechaUltimaModificacion;

	public ModeloBaseDocumentacionElectronica(Integer codigo, String nombre,
			Date fechaCreacion, Boolean publico, Date fechaUltimaModificacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.publico = publico;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public ModeloBaseDocumentacionElectronica() {
		
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

	public Boolean getPublico() {
		return publico;
	}

	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ModeloBaseDocumentacionElectronica) {
			final ModeloBaseDocumentacionElectronica param = (ModeloBaseDocumentacionElectronica)obj;
			final EqualsBuilder equalsBuilder = new EqualsBuilder();
			
			equalsBuilder.append(this.codigo, param.codigo);
			equalsBuilder.append(this.nombre, param.nombre);
			equalsBuilder.append(this.fechaCreacion, param.fechaCreacion);
			equalsBuilder.append(this.publico, param.publico);
			equalsBuilder.append(this.fechaUltimaModificacion, param.fechaUltimaModificacion);
			
			return equalsBuilder.isEquals();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		
		hashCodeBuilder.append(this.codigo);
		hashCodeBuilder.append(this.nombre);
		hashCodeBuilder.append(this.fechaCreacion);
		hashCodeBuilder.append(this.publico);
		hashCodeBuilder.append(this.fechaUltimaModificacion);
		
		return hashCodeBuilder.toHashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
