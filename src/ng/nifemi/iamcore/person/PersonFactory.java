package ng.nifemi.iamcore.person;

/**
 * @author Ogundare
 *
 */
public class PersonFactory {
	
	/**
	 * @author Ogundare
	 *
	 */
	public enum ProductTypes {
		/**
		 * 
		 */
		IDENTITY,

	}
	
	/**
	 * @param type
	 * @return the new Person
	 */
	public static Person getInstance (ProductTypes type) {
		Person person;
		 switch (type) {
		 case IDENTITY:
			 person = new Identity();
			 break;
		 default:
			 return null;
		 }
		return person;
	}

}
