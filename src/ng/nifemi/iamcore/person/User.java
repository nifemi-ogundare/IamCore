package ng.nifemi.iamcore.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ogundare
 *
*/
@Entity
@Table(name="users")
public class User {
	private String login;
	private String password;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/**
	 * 
	 */
	public User() {
	}
	/**
	 * @param login 
	 * @param password
	 */
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;	
	}
	
	/**
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
}
