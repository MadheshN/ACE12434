package view;
import model.*;
import control.*;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.sql.Connection;
import java.util.*;
public class Driver {
	static Connection connection=null;
	static DBConnection databaseconnection = new DBConnection();
	static User user = new User();
	static Admin admin = new Admin();
	static Validation validation = new Validation();
	public static String u_name="";
	public void displayMenu() throws Exception {
		Scanner scanner = new Scanner(System.in);
		int choice=0;
		//db.display();
        System.out.println("1.Customer ");		
        System.out.println("2.Admin ");
        choice=scanner.nextInt();
        while(choice!=1 && choice!=2) {
        	
        	System.out.println("Invalid Choice Try Again");
        	System.out.println("Enter a valid Option 1 or 2");
        	choice=scanner.nextInt();
        }
        if(choice==1) {
        
		System.out.println("Enter 1 to Login :");
		System.out.println("Enter 2 to SignUp : ");
		int choice1 = scanner.nextInt();
		if(choice1 == 1) {
			u_name = user.userLogin();
		}
		else {
			u_name=user.userSignUp();	
			///driver(u_name);
		}
        }
        if(choice==2) {
        	System.out.println("Admin Login");
        		u_name = admin.adminLogin();
        }
		int choice2=0;
		while(choice2!=3 && choice==1) {
			System.out.println();
			System.out.println("1.Booking");
			System.out.println("2.Delivery date");
			System.out.println("3.Exit");
			choice2=scanner.nextInt();
			scanner.nextLine();
			switch(choice2) {
				case 1:{
				System.out.println("Gas Booking");
				user.booking(u_name);
				break;
			}
				case 2:{
					 LocalDate today = LocalDate.now();
				     LocalDate nextFriday = today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
				     System.out.println("Your Delivery Date is " +nextFriday);
				     break;
				}
				case 3:
				{
					System.out.println("--------------------------------------------------");
					System.out.println("|        Thank You For Visiting !!!              |");
					System.out.println("--------------------------------------------------");
					break;
				}
			}
			
			
			
		}
		
		while(choice2!=3 && choice==2) {
			System.out.println();
			System.out.println("1.See Booking");
			System.out.println("2.See USERS");
			System.out.println("3.Exit");
			choice2=scanner.nextInt();
			scanner.nextLine();
			switch(choice2) {
			case 1:{
				System.out.println("--------------------------------------------------");
				System.out.println("|              GAS BOOKING                       |");
				System.out.println("--------------------------------------------------");
				
				databaseconnection.display();
				break;
				
			}
			case 2:{
				System.out.println("--------------------------------------------------");
				System.out.println("|                USERS                           |");
				System.out.println("--------------------------------------------------");
				databaseconnection.display1();
				
				break;
			}
			case 3:{
				System.out.println("--------------------------------------------------");
				System.out.println("|        Thank You For Visiting !!!              |");
				System.out.println("--------------------------------------------------");
								
				break;
			}
			}
					
		}
	}
	
//	public static void driver(String u_name) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter 1 for Gas Booking : ");
//		int choice = sc.nextInt();
//		if(choice == 1) {
//			su.booking(u_name);
//		}
//	}

}