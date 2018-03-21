package es.fpdual.eadmin.eadmin.modelo;

public class DocumentoRegistro {
	
	private String dniInteresado;
	private String codigoRegistro;
	
	public DocumentoRegistro(String dniInteresado, String codigoRegistro) {
		super();
		this.dniInteresado = dniInteresado;
		this.codigoRegistro = codigoRegistro;
	}

	public String getDniInteresado() {
		return dniInteresado;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	@Override
	public String toString() {
		return "DocumentoRegistro [dniInteresado=" + dniInteresado + ", codigoRegistro=" + codigoRegistro + "]";
	}
	
	
}
