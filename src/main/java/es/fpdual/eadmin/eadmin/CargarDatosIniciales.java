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
		this.repositorioDocumento.altaDocumento(new Documento(1, "documento1", FECHA, null, EstadoDocumento.ACTIVO, FECHA));
		System.out.println("Documento1 introducido");
		this.repositorioDocumento.altaDocumento(new Documento(2, "documento2", FECHA, null, EstadoDocumento.ACTIVO, FECHA));
		System.out.println("Documento2 introducido");
		this.repositorioDocumento.altaDocumento(new Documento(3, "documento3", FECHA, null, EstadoDocumento.ACTIVO, FECHA));
		System.out.println("Documento3 introducido");
	}
	
	private static final Date FECHA = new Date();
	
	@Autowired
	public CargarDatosIniciales(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
		
	}
}
