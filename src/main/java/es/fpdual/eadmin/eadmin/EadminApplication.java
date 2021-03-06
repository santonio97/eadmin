package es.fpdual.eadmin.eadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class EadminApplication {

	private static final Logger logger = LoggerFactory.getLogger(EadminApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EadminApplication.class, args);

/*debug*/	logger.debug("Depuración");
/*info*/	logger.info("Información");
/*trace*/	logger.trace("Traza");
/*warn*/	logger.warn("Advertencia");
/*error*/	logger.error("Error");

	}
}
