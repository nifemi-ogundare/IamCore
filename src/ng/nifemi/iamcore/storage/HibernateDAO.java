package ng.nifemi.iamcore.storage;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ng.nifemi.iamcore.person.Identity;
import ng.nifemi.iamcore.person.Person;

/**
 * @author Ogundare
 *
 */
@Component
public class HibernateDAO implements DAO {	
	
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * 
	 */
	public HibernateDAO() {
	}
	
	@Override
	public void save(Person person) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(person);
		tx.commit();
		session.disconnect();
		session.close();
	}

	@Override
	public void delete(Person person) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(person);
		tx.commit();
		session.disconnect();
		session.close();
		
	}

	@Override
	public void update(Person person) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(person);
		tx.commit();
		session.disconnect();
		session.close();
		
	}

	@Override
	public List<Person> getList() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Person> idList = session.createCriteria(Identity.class).list();
		tx.commit();
		session.disconnect();
		session.close();
		
		return idList;
	}

	@Override
	public List<Person> search(Person person) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Identity.class);
		
		Criterion fullName = Restrictions.eq("fullName", person.getFullName());
		Criterion email = Restrictions.eqOrIsNull("email", person.getEmail());
		Criterion birthDate = Restrictions.eqOrIsNull("birthDate", person.getBirthDate());
		Disjunction orSeries = Restrictions.or(fullName, email, birthDate);
		
		criteria.add(orSeries);
		
		List<Person> idList = criteria.list();
	
		tx.commit();
		session.disconnect();
		session.close();
		
		return idList;
	}
	
	@Override
	public Person getById(int uid) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Identity.class);
		criteria.add(Restrictions.eq("id", uid));
		
		Person person = (Person)criteria.uniqueResult();
		tx.commit();
		session.disconnect();
		session.close();
		
		return person;
	}
}
