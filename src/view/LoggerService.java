package view;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerService {
	private static final Logger logger = Logger.getLogger(LoggerService.class.getName());
	 static {
	        try {
	            FileHandler fileHandler = new FileHandler("C:\\Users\\ELCOT\\eclipse-workspace\\GasBookingApp\\src\\LoggerFile.log"); 
	            fileHandler.setFormatter(new SimpleFormatter()); 

	            logger.addHandler(fileHandler);																																																																											
	            logger.setLevel(Level.INFO); 
	        } catch (IOException exception) {
	           System.out.println(exception);
	        }
	    }

	    public static void logInfo(String message) {
	        logger.log(Level.INFO, message);
	    }

	    public static void logError(Level severe, String message) {
	        logger.log(Level.SEVERE, message);
	    }

}