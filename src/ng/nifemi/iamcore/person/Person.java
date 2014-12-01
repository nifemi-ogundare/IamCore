package ng.nifemi.iamcore.person;

/**
 * @author Ogundare
 *
 */
public interface Person {

	/**
	 * @return the fullName
	 */
	public String getFullName();
	/**
	 * @return the email
	 */
	public String getEmail();

	/**
	 * @return the birthYear
	 */
	public String getBirthDate();

	/**
	 * @return the id
	 */
	public int getId();
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id);

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName);
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email);

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate);

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();

}
