package examples.w1;

import java.io.*;

public class Person {
	String name;
	Integer age;
	String occupation;
	BufferedReader br;
	
	// Constructor
	public Person() {
		br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your name: ");
				name = br.readLine();
				System.out.print("Enter your age: ");
				age = Integer.parseInt(br.readLine());
				System.out.print("Enter your occupation: ");
				occupation = br.readLine();
				break;
			} catch (Exception e) {
				System.out.println(e);
				continue;
			}
		}
	}
	
	// Prints out the info of a person
	public void print_info() {
		System.out.println("\nName: " + name);
		System.out.println("Age: " + age);
		System.out.println("Age Group: " + get_age_group());
		System.out.println("Occupation: " + occupation);
	}
	
	// Gets age group name that the person belongs to
	private String get_age_group() {
		if (age < 15) {
			return "Child";
		} else if (age < 25) {
			return "Youth";
		} else if (age < 65) {
			return "Adult";
		} else if (age < 120) {
			return "Senior";
		} else return "Dead";
	}
	
	// Ages the person by n years
	private void age(int n) {
		age += n;
	}
	
	// Asks user if they would like to age the person, and if so, by how many years.
	public void age_person() {
		while (true) {
			System.out.print("\nWould you like to age the person? (Y\\N) ");
			try {
				String input = br.readLine();	
				if (!input.equals("Y") && !input.equals("N")) continue;
				if (input.equals("N")) break;
				System.out.println("By how many years would you like to age? ");
				Integer n = Integer.parseInt(br.readLine());
				age(n);
				print_info();				
			} catch (IOException ioe) {
				System.out.println(ioe);
			}
		}
	}
}
