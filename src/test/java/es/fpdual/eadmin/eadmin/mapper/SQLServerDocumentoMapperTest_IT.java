package es.fpdual.eadmin.eadmin.mapper;

import org.junit.runner.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-configuracion/aytos-rigel-sqlserver-persistencia-test.xml",
	})
public class SQLServerDocumentoMapperTest_IT extends BaseDocumentoMapperTest {

	
}
