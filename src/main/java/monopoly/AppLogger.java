package monopoly;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Jean
 *
 */
public class AppLogger {

	public static final Logger log = Logger.getLogger("Monopoly");

	/**
	 * Log informational message
	 * 
	 * @param message
	 */
	public static void info(String message) {
		log.info(message);
	}

	/**
	 * Log servere message
	 * 
	 * @param message
	 * @param e
	 */
	public static void severe(String message, Throwable e) {
		log.log(Level.SEVERE, message, e);
	}

}
