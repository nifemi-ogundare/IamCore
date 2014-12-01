package ng.nifemi.iamcore.test;

import ng.nifemi.iamcore.person.Identity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ogundare
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContextTest.xml")

public class SpringConfigurationTest{
	
	@Autowired
	@Qualifier("fakeIdentity")
	private Identity id;
	
	@Autowired
	@Qualifier("fakeIdentity2")
	private Identity id2;
	
	//@BeforeClass
	/**
	 * 
	 */
	@Test
	public void testSpring() {
		if (id != null) {
			System.out.println(id);
		}else{
			System.out.println("id was null");
		}
		
		System.out.println(id2.getFullName());
	}
}		