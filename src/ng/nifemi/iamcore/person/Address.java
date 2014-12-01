package ng.nifemi.iamcore.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nifemi
 *
 */
@Entity
@Table(name="ADDRESSES")
public class Address {
	@Id
	@Column(name="ADDR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String number;
	private String street;
	private String city;
	private String country;
	
	
	/**
	 * @param number
	 * @param street
	 * @param city
	 * @param country
	 */
	public Address(String number, String street, String city, String country) {
		this.number = number;
		this.street = street;
		this.city = city;
		this.country = country;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}


	/**
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}


	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}


	/**
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
}
