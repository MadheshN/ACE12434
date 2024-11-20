	package control;
	import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
	public class DBConnection {
		static Connection connection=null;
		static DBConnection databaseconnection = new DBConnection();
		public void connect() throws Exception{
			String url;
			String password;
			String username;
			String driverName;
			String PathFile="C:\\Users\\ELCOT\\eclipse-workspace\\GasBookingApp\\src\\Database.properties" ;
			Properties properties=new Properties();
			try
			{
				FileInputStream fileinputstream =new FileInputStream(PathFile);
				properties.load(fileinputstream);
				driverName=properties.getProperty("Driver");
				url=properties.getProperty("url");
				username=properties.getProperty("username");
				password=properties.getProperty("password");
				
				Class.forName(driverName);
				connection=DriverManager.getConnection(url,username,password);
				
			}
			catch(Exception Sqlexception)
			{
				System.out.println(Sqlexception);
			}
			
		}
		
		public boolean checkUser(String username,String phonenumber,String password) throws Exception {
			databaseconnection.connect();
			String query = "SELECT u_name,phone_num,psw FROM users WHERE u_name = '"+username+"' AND phone_num = '"+phonenumber+"' AND psw = '"+password+"';";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()) {
				return true;
			}
			return false;
		}
		public int addUser(String username,String phonenumber,String user_id,String aadhar,String password) throws Exception {
			databaseconnection.connect();
			
			String query = "INSERT INTO users VALUES(?,?,?,?,?);";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
		
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, phonenumber);
			preparedstatement.setString(3, user_id);
			preparedstatement.setString(4, aadhar);
			preparedstatement.setString(5, password);
			int rows = preparedstatement.executeUpdate();
			return rows;
		}

		
		public int bookCylinder(String username,String cardnumber,int type,String date) throws Exception {
			databaseconnection.connect();
			String query = "INSERT INTO booking VALUES(?,?,?,?);";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, cardnumber);
			preparedstatement.setInt(3, type);
			preparedstatement.setString(4, date);
			int rows = preparedstatement.executeUpdate();
			return rows;
		}
		public int addAdmin(String adminname,String phonenumber,String aadhar,String password) throws Exception {
			databaseconnection.connect();
			String query = "INSERT INTO admin VALUES(?,?,?,?);";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, adminname);
			preparedstatement.setString(2, phonenumber);
			preparedstatement.setString(3, aadhar);
			preparedstatement.setString(4, password);
			int rows = preparedstatement.executeUpdate();
			return rows;
		}
		public boolean checkAdmin(String adminname,String phonenumber,String password) throws Exception {
			databaseconnection.connect();
			String query = "SELECT a_name,phone_num,psw FROM admin WHERE a_name = '"+adminname+"' AND phone_num = '"+phonenumber+"' AND psw = '"+password+"';";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()) {
				return true;
			}
			return false;
		}
		public void display() throws Exception{
			databaseconnection.connect();
			String query = "SELECT u_name,card_num,type,date FROM booking ";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while(resultset.next()) {
			String username=resultset.getString(1);
			String cardnumber=resultset.getString(2);
			String type=resultset.getString(3);
			String date=resultset.getString(4); 
			System.out.println(username+"     "+cardnumber+"     "+type+"     "+date);
			}
			}
			
			public void display1() throws Exception{
				databaseconnection.connect();
				String query = "SELECT u_name,phone_num,user_id,aadhar,psw FROM users ";
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(query);
				while(resultset.next()) {
					String username=resultset.getString(1);
					String phonenumber=resultset.getString(2);
					String id=resultset.getString(3);
					String aadhar=resultset.getString(4); 
					String password=resultset.getString(5); 
					System.out.println(username+"                "+phonenumber+"                 "+id+"           "+aadhar+"                 "+password);
				}
				
			}
			
	}
