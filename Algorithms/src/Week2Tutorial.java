import java.util.Scanner;
import java.lang.StringBuilder;

public class Week2Tutorial {

	public Week2Tutorial() {
		// TODO Auto-generated constructor stub
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String firstString;
		StringBuilder secondString = new StringBuilder();
		Scanner scan = new Scanner(System.in);	
		
		System.out.println("This program checks whether two strings are anagrams of each other:");		
		
		System.out.println("Enter First String:");
		
		firstString = scan.next();

		System.out.println("Enter Second String:");

		secondString.append(scan.next());		
		
		if (firstString.length() == secondString.length()) {
			
			for (int i=0; i < firstString.length(); i++)
			{
				char firstChar;
				
				firstChar = firstString.charAt(i);
				
				for (int j=0; j < secondString.length(); j++) {
					if (firstChar == secondString.charAt(j) ) {
						secondString.deleteCharAt(j);
					}
				}
				
			}
			if (secondString.length() == 0) {
				System.out.println("These are anagrams!");					
			}
			else {
			
			System.out.println("Same length, but not anagrams");	
			}
		}
		else {
			System.out.println("Different length, not anagrams.");	
		}
		
	}

}
