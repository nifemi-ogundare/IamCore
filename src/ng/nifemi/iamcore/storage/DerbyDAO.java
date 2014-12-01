package ng.nifemi.iamcore.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ng.nifemi.iamcore.configuration.Configuration;
import ng.nifemi.iamcore.person.Person;
import ng.nifemi.iamcore.person.PersonFactory;
import ng.nifemi.iamcore.person.PersonFactory.ProductTypes;

/**
 * @author nifemi
 *
 */
@Component
public class DerbyDAO implements DAO {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	@Autowired
	Configuration config;
	
	/**
	 * @param config 
	 * 
	 */
	public DerbyDAO() {
		//this.config = config;
		this.connect();
	}
	
	/**
	 * 
	 */
	public void connect() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			this.connection = DriverManager.getConnection("jdbc:derby:/home/nifemi/iam;create=true");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("error connecting to the database. exiting...");
			return;
		} 
	}

	@Override
	public void save(Person person) {
		//use a PreparedStatement to insert a new sql database entry
		try {
			preparedStatement = connection.prepareStatement("insert into identities (fullName, email, birthDate) "
					+ "values (?,?,?)");
			preparedStatement.setString(1, person.getFullName());
			preparedStatement.setString(2, person.getEmail());
			preparedStatement.setString(3, person.getBirthDate());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person person) {
		//use a PreparedStatement to delete an sql database entry
		try {
			preparedStatement = connection.prepareStatement("delete from identities where uid = ?");
			preparedStatement.setInt(1, person.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Person person) {
		//use a PreparedStatement to update an sql database entry
		try {
			preparedStatement = connection.prepareStatement("update identities set fullName = ?, email = ?, birthDate = ? where id = ?");
			preparedStatement.setString(1, person.getFullName());
			preparedStatement.setString(2, person.getEmail());
			preparedStatement.setString(3, person.getBirthDate());
			preparedStatement.setInt(4, person.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Person> getList() {
		List<Person> idList = new ArrayList<Person>();
		//use a PreparedStatement  and a ResultSet object to read through an sql database
		try {
			preparedStatement = connection.prepareStatement("select * from identities");
			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {
				Person person = PersonFactory.getInstance(ProductTypes.IDENTITY);
				person.setFullName(results.getString("fullName"));
				person.setEmail(results.getString("email"));
				person.setBirthDate(results.getString("birthDate"));
				person.setId(results.getInt("id"));
				//add each person to an arrayList
				idList.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idList;
	}

	@Override
	public List<Person> search(Person criteria) {
		List<Person> idList = new ArrayList<Person>();
		//use a PreparedStatement  and a ResultSet object to read through an sql database
		try {
			preparedStatement = connection.prepareStatement("select * from identities where fullName = ? or email = ? or birthDate = ?");
			preparedStatement.setString(1, criteria.getFullName());
			preparedStatement.setString(2, criteria.getEmail());
			preparedStatement.setString(3, criteria.getBirthDate());
			
			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {
				Person person = PersonFactory.getInstance(ProductTypes.IDENTITY);
				person.setFullName(results.getString("fullName"));
				person.setEmail(results.getString("email"));
				person.setBirthDate(results.getString("birthDate"));
				person.setId(results.getInt("id"));
				//add each person to an arrayList
				idList.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idList;
	}

	@Override
	public Person getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
