package ng.nifemi.iamcore.test;

import ng.nifemi.iamcore.person.Address;
import ng.nifemi.iamcore.person.Identity;
import ng.nifemi.iamcore.storage.AddressDAO;
import ng.nifemi.iamcore.storage.HibernateDAO;

import org.hibernate.SessionFactory;
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
public class HibernateConfigurationTest {
	
	@Autowired
	@Qualifier("mySessionFactory")
	SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("fakeIdentity")
	private Identity id;
	
	@Autowired 
	AddressDAO dao;
	
	@Autowired
	HibernateDAO idDao;
	
	/**
	 * 
	 */
	@Test
	public void testSave() {
		Address address = new Address("1", "rue george", "Paris", "France");
		dao.saveAddress(address);
		id.setAddress(address);
		idDao.save(id);
		
	}

}
