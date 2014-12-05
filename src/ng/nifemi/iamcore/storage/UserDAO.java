package ng.nifemi.iamcore.storage;

import ng.nifemi.iamcore.person.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nifemi
 *
 */
@Component
public class UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * @param user
	 */
	public void save(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(user);
		tx.commit();
		session.disconnect();
		session.close();
	}

	/**
	 * @param user
	 * @return true or false
	 */
	public boolean checkUser(User user) {
		
		boolean userExists = false;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		
		Criterion login = Restrictions.eq("login", user.getLogin());
		Criterion password = Restrictions.eq("password", user.getPassword());
		LogicalExpression andEx = Restrictions.and(login, password);
		
		criteria.add(andEx);
		
		if (criteria.uniqueResult() != null) {
			userExists = true;
		}
	
		tx.commit();
		session.disconnect();
		session.close();
		
		return userExists;
	}
}
