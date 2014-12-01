package ng.nifemi.iamcore.authenticating;

/**
 * @author Ogundare
 *
 */
public class Authenticator {
	
	private boolean isAuthenticated;
	
	/**
	 * @param username
	 * @param password
	 */
	public void authenticate (String username, String password) {
		
		this.isAuthenticated = false;
		
		//make sure the passwords file and the path exists. read through each line for the user name and password pair
		if (!this.isAuthenticated) {
			this.isAuthenticated = true;
		}
	}

	/**
	 * @return the isAuthenticated
	 */
	public boolean isAuthenticated() {
		return isAuthenticated;
	}	
}
	

