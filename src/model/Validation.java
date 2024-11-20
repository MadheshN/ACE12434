package model;
import control.*;
import view.*;
import java.util.*;
import java.text.*;
public class Validation {
	public String getDate() {
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		return dateformat.format(date);
	}

public static boolean isStrongPassword(String password) {
    boolean hasUppercase = false;
    boolean hasLowercase = false;
    boolean hasDigit = false;
    boolean hasSpecialChar = false;

    if (password.length() < 8) {
        return false;
    }

    for (char character : password.toCharArray()) {
        if (Character.isUpperCase(character)) {
            hasUppercase = true;
        } else if (Character.isLowerCase(character)) {
            hasLowercase = true;
        } else if (Character.isDigit(character)) {
            hasDigit = true;
        } else if (isSpecialChar(character)) {
            hasSpecialChar = true;
        }
    }

    return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
}

public static boolean isSpecialChar(char character) {
    String specialChars = "@#$%^&+=;";
    return specialChars.indexOf(character) != -1;
}

//public static void main(String[] args) {
//	Scanner scanner = new Scanner(System.in);
//	
//	System.out.print("Enter a password: ");
//	String password = scanner.nextLine();
//	
//	if (isStrongPassword(password)) {
//		System.out.println("The password is strong.");
//	} else {
//		System.out.println("The password is weak.");
//	}
//}
}