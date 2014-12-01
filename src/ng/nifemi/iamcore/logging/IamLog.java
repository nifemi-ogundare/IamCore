package ng.nifemi.iamcore.logging;

/**
 * @author Ogundare
 *
 */
public abstract class IamLog {

	/**
	 * @author Ogundare
	 *
	 */
	public enum LogLevel {
		/**
		 * 
		 */
		INFO, /**
		 * 
		 */
		WARN, /**
		 * 
		 */
		ERROR, /**
		 * 
		 */
		DEBUG
	}
	
	/**
	 * @param loggingEntity
	 * @return Logging
	 */
	public static IamLog getLogger(String loggingEntity) {
		return new Logging(loggingEntity);
	}
	
	/**
	 * log the given message at the givel level
	 * @param message
	 * @param level
	 */
	public abstract void log(String message, LogLevel level);
	
	/**
	 * @param message
	 */
	public void info(String message) {
		log(message, IamLog.LogLevel.INFO);
	}
	
	/**
	 * @param message
	 */
	public void error(String message) {
		log(message, IamLog.LogLevel.ERROR);
	}
	
	/**
	 * @param message
	 */
	public void warn(String message) {
		log(message, IamLog.LogLevel.WARN);
	}
	
	/**
	 * @param message
	 */
	public void debug(String message) {
		log(message, IamLog.LogLevel.DEBUG);
	}	

}

