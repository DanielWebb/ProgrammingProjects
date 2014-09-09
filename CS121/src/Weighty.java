// Weighty.java												Author: Dan Webb   //
// Weighty, the program to tell you your ideal weight for both males and females. Just enter your height in feet and inches separately.     //
import java.util.Scanner;
// retrieves the Scanner utility, first step in allowing user input            //

public class Weighty {

	public static void main(String[] args) {
		int feet;int inches; int height; int idealweightf; int idealweightm; double kilogramsf; double kilogramsm;
// declares the variables for height, kilograms, and ideal weight for both males and females and also the input variables given by the user            //		
		double lowweightf; double highweightf; double lowweightm; double highweightm;
		// declaration of variables used in creating the acceptable range within 15% of ideal       //
		
		Scanner scan = new Scanner (System.in);
// second step in allowing user input, allows entry on the keyboard            //
		
		System.out.println("Enter how many feet tall you are: ");
		feet= scan.nextInt();
// print statement on screen asking user to enter their height without inches, and assigning it to the variable feet. Third step in allowing user input	//				//
		
		System.out.println("Enter the remaining inches tall you are (without feet): ");
		inches= scan.nextInt();
// print statement on screen asking user to enter the remaining inches, and assigning it to the variable inches.							//
		
		height= (feet * 12) + inches;
// converting the user input into the variable height to be used in the calculation of ideal weight 										//		
		if (height <=60){
			idealweightf= 100; idealweightm= 106; kilogramsf= idealweightf / 2.2; kilogramsm= idealweightm / 2.2;
			lowweightf= idealweightf * .85; highweightf= idealweightf * 1.15; lowweightm= idealweightm * .85; highweightm= idealweightm * 1.15;
			System.out.println("Your ideal weight is: " + idealweightf + " pounds if female, or " + idealweightm + " pounds if male. In Metric " + kilogramsf +" kilograms if female, or " + kilogramsm + " kilograms if male.");
// print statement displaying the output (ideal weight) in sentence form, both pounds and kilograms are given to the user      //	
			System.out.println();
			System.out.println("A range within 15% of ideal would be between: " + lowweightf + " pounds and " + highweightf + " pounds if female, or " + lowweightm + " pounds and " + highweightm + " pounds if male.");
		}
		else if (height >=61)
		{
			idealweightf= (height - 60) * 5 + 100; kilogramsf= idealweightf / 2.2;
			idealweightm= (height - 60) * 6 + 106; kilogramsm= idealweightm / 2.2;
		
	
			lowweightf= idealweightf * .85; highweightf= idealweightf * 1.15; lowweightm= idealweightm * .85; highweightm= idealweightm * 1.15;
			System.out.println("Your ideal weight is: " + idealweightf + " pounds if female, or " + idealweightm + " pounds if male. In Metric " + kilogramsf +" kilograms if female, or " + kilogramsm + " kilograms if male.");
// print statement displaying the output (ideal weight) in sentence form, both pounds and kilograms are given to the user      //	
			System.out.println();
			System.out.println("A range within 15% of ideal would be between: " + lowweightf + " pounds and " + highweightf + " pounds if female, or " + lowweightm + " pounds and " + highweightm + " pounds if male.");
	
		}
	}
}
