package ng.nifemi.iamcore.test;

import ng.nifemi.iamcore.configuration.Configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author nifemi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/configurationContextTest.xml")
public class ConfigurationTest {
	
	@Autowired
	@Qualifier("configuration")
	private Configuration config;
	
	/**
	 * 
	 */
	@Test
	public void testConnection() {
		System.out.println(config.getDbConnectionString());
		System.out.println(config.getDbDriverString());	
	}
	

}
