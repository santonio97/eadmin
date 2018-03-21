package es.fpdual.eadmin.eadmin.modelo;

public class DocumentoPropuesta {
	
	private Integer codigoPropuesta;
	private Integer ejercicio;
	private String grupoPolitico;
	
	public DocumentoPropuesta(Integer codigoPropuesta, Integer ejercicio, String grupoPolitico) {
		super();
		this.codigoPropuesta = codigoPropuesta;
		this.ejercicio = ejercicio;
		this.grupoPolitico = grupoPolitico;
	}

	public Integer getCodigoPropuesta() {
		return codigoPropuesta;
	}

	public Integer getEjercicio() {
		return ejercicio;
	}

	public String getGrupoPolitico() {
		return grupoPolitico;
	}

	@Override
	public String toString() {
		return "DocumentoPropuesta [codigo=" + codigoPropuesta + ", ejercicio=" + ejercicio + ", grupoPolitico=" + grupoPolitico
				+ "]";
	}
	
}
