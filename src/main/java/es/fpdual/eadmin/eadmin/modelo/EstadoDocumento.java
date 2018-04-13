package es.fpdual.eadmin.eadmin.modelo;

import org.assertj.core.util.Arrays;

public enum EstadoDocumento {

	ACTIVO(1), APROBADO(2), ELIMINADO(3);

	private final int codigo;

	private EstadoDocumento(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public static EstadoDocumento obtenerPorCodigo(Integer codigo) {

		return (EstadoDocumento) Arrays.asList(EstadoDocumento.values()).stream()
				.filter(codigoLista -> ((EstadoDocumento) codigoLista)
				.getCodigo() == codigo.intValue()).findAny().orElse(null);
	}
}
