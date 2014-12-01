package ng.nifemi.iamcore.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Ogundare
 *
 */
@Entity
@Table(name="identities")
public class Identity implements Person {
	
	private String fullName;
	private String email;
	private String birthDate;
	
	@OneToOne
	@JoinTable(name="IDENTITIES_ADDRESSES")
	private Address address;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Default Identity Constructor
	 */
	public Identity() {	
	}
	
	/**
	 * Alternate Identity Constructor, intended for test case purposes
	 * @param fullName
	 * @param email
	 * @param birthDate
	 */
	public Identity(String fullName, String email,
			String birthDate) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.birthDate = birthDate;
	}
	
	/**
	 * intended for test case purposes
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identity [id = " + this.id + ", Name = " + this.fullName + 
				", Email = " + this.email + ", Date of Birth = " + this.birthDate +"]";
	}

	/**
	 * @return the address list
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
