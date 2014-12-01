package ng.nifemi.iamcore.logging;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Ogundare
 *
 */
public class Config {
	static Properties iamProperties = new Properties();
	/**
	 * 
	 */
	public Config() {
		try {
			FileOutputStream out = new FileOutputStream("config.properties");
			
			// set the properties values
			iamProperties.setProperty("line separator", System.getProperty("line.separator"));
			iamProperties.setProperty("path", System.getProperty("user.home") + File.separator + "IAM");
			
			// save properties to project root folder
			iamProperties.store(out, null);
			if (out != null) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return the iamProperties
	 */
	public static Properties getIamProperties() {
		try {
			FileInputStream in = new FileInputStream("config.properties");
			iamProperties.load(in);
			if (in != null) {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return iamProperties;
	}
}
