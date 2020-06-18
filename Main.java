package random;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static String randomGenerate(int length){
		
		String randomChar = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*";
		//Without punctuations
		//String randomChar = "abcdefghijklmnopqrstuvwxyz1234567890";
		int size = randomChar.length();
		String newStr = "";
		char temp;
		
		Random r = new Random();
		
		for ( int i = 0; i < length; i++) {
			temp = randomChar.charAt(r.nextInt(size));
			boolean check = Character.isLetter(temp);
			if ( check ) {
				int number = r.nextInt(2);
				if ( number == 1) {
					temp = Character.toUpperCase(temp);
				}
			}
			newStr = newStr + temp;
		}
				
		return newStr;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean numeric = false;
		String value = "";
		
		while ( !numeric) {
		System.out.print("Enter the length of your password: ");
		value= input.next();
		numeric = value.matches("[0-9]+");
		if ( !numeric) {
			System.out.println("Invalid input, enter positive numbers only!");
			System.out.println("");
		}
		}
		
		input.close();
		int length = Integer.parseInt(value);
		
		String str = randomGenerate(length);
		System.out.println("Your new strong password: " + str);
	}

}
