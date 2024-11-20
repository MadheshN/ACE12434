package model;
import control.*;
import view.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class User{
	static Connection connection=null;
	static DBConnection databaseconnection = new DBConnection();
	static User user = new User();
	static Validation validation = new Validation();
	public String userLogin() throws Exception {
		Scanner scanner = new Scanner(System.in);
		int flag = 0;
		String name="";
		do {
			System.out.println("Enter your Name : ");
			 name = scanner.nextLine();
			System.out.println("Enter your Phone Number : ");
			String phone_number = scanner.nextLine();
			System.out.println("Enter your Password : ");
			String password= scanner.nextLine();
			System.out.println("Enter 1 to login : ");
			String choice = scanner.nextLine();
			if(choice.equals("1")) {
				boolean response = databaseconnection.checkUser(name, phone_number, password);
				if(response) {
					System.out.println("Welcome User "+name);
					flag = 0;
				}
				else {
					System.out.println("Invalid User");
					flag = 1;
				}
			}
			else {
				System.out.println("Invalid choice");
				flag = 1;
			}
		}while(flag == 1);
		 
		return name;
	}
	
	public String userSignUp() throws Exception {
		Scanner scanner = new Scanner(System.in);
		int flag = 0;
		String name;
		do {
			flag = 0;
			System.out.println("Enter User Name : ");
			 name = scanner.nextLine();
			System.out.println("Enter your phone Number : ");
			String phone_number = scanner.nextLine();
			while(!isValidNumber(phone_number)) {
				System.out.println("Enter a valid Number (Eg +91 6763827397");
				phone_number=scanner.nextLine();
			}
			String user_id = name.substring(0, 3).toUpperCase() + phone_number.substring(phone_number.length() - 3);
			System.out.println("Enter your Aadhar Number : ");
			String aadhar = scanner.nextLine();
			while(!isValidAdhar(aadhar)) {
				System.out.println("Enter a valid Adhar Number(Eg: 1234 5678 1011");
				aadhar=scanner.nextLine();
			}
			System.out.println("Enter your Password : ");
			String password = scanner.nextLine();
			while(!validation.isStrongPassword(password)) {
				System.out.println("Weak Password");
				System.out.println("Enter a Valid password ");
				password=scanner.nextLine();
			}
			System.out.println("Confirm your Password : ");
			String confirmpassword = scanner.nextLine();
			if(confirmpassword.equals(password)) {
				boolean answer = databaseconnection.checkUser(name, phone_number, confirmpassword);
				if(!answer) {
					//int rows = db.addUser(name, phone_num, aadhar, psw );
					int rows =  databaseconnection.addUser(name, phone_number,user_id, aadhar, password );
					if(rows >= 1) {
						
						System.out.println("+--------------------------------------+");
						System.out.println("|     "+"Your user_id is: "+ user_id+"        |");
						System.out.println("+--------------------------------------+");
						
						System.out.println("Welcome User "+name);
					}
					else {
						
						System.out.println("Please try again");
						flag = 1;
					}
				}
				else {
					System.out.println("User Already Exist");
					flag = 1;
				}
			}
			else {
				System.err.println("Incorrect Password");
				flag = 1;
			}
		}while(flag == 1);
		return name;
		
	}
	
	public void booking(String name) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int flag = 0;
		System.out.println("Enter Your Card Number : ");
		String card_number = scanner.nextLine();
		while(flag!=4) {
			flag = 0;
			System.out.println("Enter the cylinder Type : ");
			System.out.println("1. 1/4L Cyclinder ");
			System.out.println("2.  Normal Cyclinder ");
			System.out.println("3.  Big Cyclinder ");
			System.out.println("4.Go to Main menu");
			int type = scanner.nextInt();
			flag=type;
			scanner.nextLine();
			switch(type) {
				case 1:{ 
					System.out.println("1/4 Cylinder");
					System.out.println("+---------------------------------------+");
					System.out.println("|           --  $ ==> 650   --          |");
					System.out.println("+---------------------------------------+");
					String date = validation.getDate();
					int rows = databaseconnection.bookCylinder(name, card_number, type, date);
					if(rows!=0) {
						System.out.println("+---------------------------------------+");
						System.out.println("|        Booked Successfully            |");
						System.out.println("+---------------------------------------+");
					}
					else {
						System.out.println("Something went wrong try again");
					}
					break;
				}
				case 2:{
					System.out.println("Normal Cylinder");
					System.out.println("+---------------------------------------+");
					System.out.println("|           --  $ ==> 1050  --          |");
					System.out.println("+---------------------------------------+");
					
					String date = validation.getDate();
					int rows = databaseconnection.bookCylinder(name, card_number, type, date);
					if(rows!=0) {
						System.out.println("+---------------------------------------+");
						System.out.println("|        Booked Successfully            |");
						System.out.println("+---------------------------------------+");
					}
					else {
						System.out.println("Something went wrong try again");
					}
				
					break;
				}
				case 3:{
					System.out.println("Big Cylinder");
					System.out.println("+---------------------------------------+");
					System.out.println("|           --  $ ==> 5000  --          |");
					System.out.println("+---------------------------------------+");
					
					String date = validation.getDate();
					int rows = databaseconnection.bookCylinder(name, card_number, type, date);
					if(rows!=0) {
						System.out.println("+---------------------------------------+");
						System.out.println("|        Booked Successfully            |");
						System.out.println("+---------------------------------------+");
					}
					else {
						System.out.println("Something went wrong try again");
					}
					break;
				}
				case 4:{
					break;
				}
				default:{
					System.out.println("Invalid Option ");
					break;
				}
				
			}
			
		}
	}
	public static boolean isValidNumber(String number) {
		if(number.length()>1 && Long.parseLong(number)==0)
			return false;
		if(number.length()>=10)
			return true;
		return false;
	}
	public static boolean isValidAdhar(String number) {
		if(number.split(" ").length!=3)
			return false;
		if(number.length()!=14)
			return false;
		return true;
	}
}