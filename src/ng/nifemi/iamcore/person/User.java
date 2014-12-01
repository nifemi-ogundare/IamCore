package ng.nifemi.iamcore.person;

/**
 * @author Ogundare
 *
 */

public class User {
	private String login;
	private String password;
	
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
}
