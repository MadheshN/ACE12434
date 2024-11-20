package view;
import model.*;
import control.*;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.sql.Connection;
import java.util.*;
import java.util.logging.Level;

public class GasBookingApp 
{
	static Connection connection=null;
static DBConnection databaseconnection = new DBConnection();
static User user = new User();
static Admin admin = new Admin();
static Validation validation = new Validation();
	
	public static void main(String[] args)
	{
		Driver driver =new Driver();
		try {
			driver.displayMenu();
		} catch (Exception exception) {
			LoggerService.logError(Level.SEVERE,"Enter Valid User Credentials");
		System.out.println("Enter Valid Credentials");
		}
		
	}


}
