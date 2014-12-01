package ng.nifemi.iamcore.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ng.nifemi.iamcore.person.Person;

/**
 * @author nifemi
 *
 */
public class DAOmySQL implements DAO {
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	/**
	 * default constructor of the mySQL dao
	 * creates a connection to an sql database
	 */
	public DAOmySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iam","root","");
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
			preparedStatement = connection.prepareStatement("insert into identities (fullName, email, uid) values (?,?,?)");
			preparedStatement.setString(1, person.getFullName());
			preparedStatement.setString(2, person.getEmail());
			preparedStatement.setInt(3, person.getId());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> search(Person criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
