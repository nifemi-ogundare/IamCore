package ng.nifemi.iamcore.configuration;

import org.springframework.stereotype.Component;

/**
 * @author Ogundare
 *
 */
@Component
public class Configuration {
	
	private String dbConnectionString;
	private String dbDriverString;
	/**
	 * @return the dbConnectionString
	 */
	public String getDbConnectionString() {
		return dbConnectionString;
	}
	/**
	 * @return the dbDriverString
	 */
	public String getDbDriverString() {
		return dbDriverString;
	}
	/**
	 * @param dbConnectionString the dbConnectionString to set
	 */
	public void setDbConnectionString(String dbConnectionString) {
		this.dbConnectionString = dbConnectionString;
	}
	/**
	 * @param dbDriverString the dbDriverString to set
	 */
	public void setDbDriverString(String dbDriverString) {
		this.dbDriverString = dbDriverString;
	}
}
