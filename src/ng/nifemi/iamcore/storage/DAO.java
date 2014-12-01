package ng.nifemi.iamcore.storage;

import java.util.List;

import ng.nifemi.iamcore.person.*;

/**
 * @author Ogundare
 *
 */
public interface DAO {
	
	/**
	 * @param person
	 */
	public void save(Person person);
	/**
	 * @param person
	 */
	public void delete(Person person);
	/**
	 * @param person
	 */
	public void update(Person person);
	/**
	 * @return a list of persons
	 */
	public List<Person> getList();
	
	/**
	 * @param id
	 * @return the person
	 */
	public Person getById(int id);
	/**
	 * @param person 
	 * @return a list of person results
	 */
	public List<Person> search(Person person);
	
}
