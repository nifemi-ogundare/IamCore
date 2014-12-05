package ng.nifemi.iamcore.test;

import ng.nifemi.iamcore.person.Identity;
import ng.nifemi.iamcore.storage.AddressDAO;
import ng.nifemi.iamcore.storage.IdentityDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author nifemi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContextTest.xml")
public class DaoTest {
	
	@Autowired
	IdentityDAO identityDAO;
	
	@Autowired
	Identity identity;
	
	
	/**
	 * 
	 */
	public void testSave() {
		identityDAO.save(identity);
	}

}
