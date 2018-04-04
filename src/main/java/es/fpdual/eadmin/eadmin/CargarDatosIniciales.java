package es.fpdual.eadmin.eadmin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Component
public class CargarDatosIniciales implements ApplicationRunner {

	private final RepositorioDocumento repositorioDocumento;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.repositorioDocumento.altaDocumento(new Documento(5, "documento5", FECHA, null, EstadoDocumento.APROBADO, FECHA));
		
		this.repositorioDocumento.altaDocumento(new Documento(6, "documento6", FECHA, null, EstadoDocumento.ELIMINADO, FECHA));
		
		this.repositorioDocumento.altaDocumento(new Documento(7, "documento7", FECHA, null, EstadoDocumento.ACTIVO, FECHA));
		
	}
	
	private static final Date FECHA = new Date();
	
	@Autowired
	public CargarDatosIniciales(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
		
	}
}
