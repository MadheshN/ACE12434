package model;
import control.*;
import view.*;
import java.sql.*;
import java.util.*;
public class Admin {
	static Connection connection=null;
	static DBConnection databaseconnection = new DBConnection();
	static User user = new User();
	static Admin admin = new Admin();
	static Validation validation = new Validation();
		
	
		/*void insertRecord(String tn) throws Exception{
			Scanner cs=new Scanner(System.in);
			System.out.print("Enter No of Bookings: ");
			int n=cs.nextInt();
			System.out.println("Enter Details: ");
			for(int i=0;i<n;i++) {
				int id=cs.nextInt();
				String name=cs.next();
				String dat=cs.nextLine();
				String location=cs.next();
				String Query="insert into "+tn+" values('"+id+"','"+name+"','"+dat+"','"+location+"')";
				Statement st=db.con.createStatement();
				st.execute(Query);
			}
			System.out.println("Successfully Entered your Data .");
		
		}*/
		public String adminLogin() throws Exception {
			Scanner scanner = new Scanner(System.in);
			String adminname="";
			int flag = 0;
			do {
				System.out.println("Enter your Name : ");
				String name = scanner.nextLine();
				System.out.println("Enter your Phone Number : ");
				String phone_number = scanner.nextLine();
				System.out.println("Enter your Password : ");
				String password = scanner.nextLine();
				System.out.println("Enter 1 to login : ");
				String choice = scanner.nextLine();
				if(choice.equals("1")) {
					boolean answer = databaseconnection.checkAdmin(name, phone_number, password);
					adminname=name;
					if(answer) {
						System.out.println("Welcome You "+name);
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
			return adminname;
		}/*
			 * public void adminSignUp() throws Exception { Scanner sc = new
			 * Scanner(System.in); int flag = 0; do { flag = 0;
			 * System.out.println("Enter Your Name : "); String a_name = sc.nextLine();
			 * System.out.println("Enter your phone Number : "); String phone_num =
			 * sc.nextLine(); System.out.println("Enter your Aadhar Number : "); String
			 * aadhar = sc.nextLine(); System.out.println("Enter your Password : "); String
			 * psw = sc.nextLine(); System.out.println("Confirm your Password : "); String
			 * c_psw = sc.nextLine(); if(c_psw.equals(psw)) {
			 * 
			 * boolean ans = db.checkAdmin(a_name, phone_num, c_psw); if(!ans) { int rows =
			 * db.addAdmin(a_name, phone_num, aadhar, psw); if(rows >= 1) {
			 * System.out.println("Welcome User "+a_name); } else {
			 * System.out.println("Please try again"); flag = 1; } } else {
			 * System.out.println("User Already Exist"); flag = 1; } } else {
			 * System.err.println("Incorrect Password"); flag = 1; } }while(flag == 1); }
			 * 
			 * 
			 */
	
	}