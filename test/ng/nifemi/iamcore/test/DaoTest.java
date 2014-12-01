package ng.nifemi.iamcore.test;

import ng.nifemi.iamcore.person.Identity;
import ng.nifemi.iamcore.storage.AddressDAO;
import ng.nifemi.iamcore.storage.HibernateDAO;

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
	AddressDAO addressDAO;
	
	@Autowired
	HibernateDAO hibernateDAO;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	Identity identity;
	
	
	/**
	 * 
	 */
	public void testSave() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Identity identity = new Identity();
		session.save(identity);
		System.out.println(identity.getId());
		tx.commit();
		session.close();
	}

}
