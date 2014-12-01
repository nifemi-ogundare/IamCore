package ng.nifemi.iamcore.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author Ogundare
 *
 */
public class Logging extends IamLog {
	
	String loggingEntity;
	private PrintWriter writer;
	Properties properties = Config.getIamProperties();
	
	/**
	 * Default Logging Constructor
	 * @param loggingEntity
	 */
	public Logging(String loggingEntity) {
		this.loggingEntity = loggingEntity;
		
		//make sure the log file and the path exists.
		try {	
			final File pathDir = new File(properties.getProperty("path"));
			if (!pathDir.exists()) {	
				pathDir.mkdirs();
			}
			
			File file = new File(properties.getProperty("path") + File.separator + "log.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			
			writer = new PrintWriter (new FileWriter(file));
			writer.write("This is the log file beginning" + properties.getProperty("line separator"));
			writer.flush();		
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see ng.nifemi.iamcore.logging.IamLog#log(java.lang.String, ng.nifemi.iamcore.logging.IamLog.LogLevel)
	 */
	@Override
	public void log(String message, LogLevel level) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss.SSS");
		String result = sf.format(new Date()) + ":[" + this.loggingEntity + "]" + ":[" + level + "] " + message;
		
		writer.write(result + properties.getProperty("line separator"));
		writer.flush();
	}
}
