package ng.nifemi.iamcore.storage;

import ng.nifemi.iamcore.person.Address;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nifemi
 *
 */
@Component
public class AddressDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * @param address
	 */
	public void saveAddress(Address address) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(address);
		tx.commit();
		session.disconnect();
		session.close();
	}

}
