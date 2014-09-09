//Project 4: Shapes							Author:Dan Webb
import java.util.Scanner;

public class Pr4Shapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int shape, size, stars, line;
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter 1 for diamond or 2 for a hollow square: ");
		shape = scan.nextInt();

		System.out.println("Enter the size you want the shape to be: ");
		size = scan.nextInt();

		if (shape == 2) //draws hollow square
			for (line = 0; line < size; line++) {
				for (int x = 0; x < size; x++){
					if (line == size - 1 || line == 0) 
						System.out.print("* ");
					else
						if(x == 0 || x == size - 1)
							System.out.print("* ");
						else
							System.out.print("  ");
				}
				System.out.println();

			}
		if (shape == 1) { //draws diamond
			stars = 1;
			double spaces = (size / 2.0);
			for (line = 0; line <= size; line++){
				for (int x = 0; x < spaces; x++){
					System.out.print(" ");
				}
				for (int x = 0; x < stars; x++)
					System.out.print("*");

				System.out.println();


				if (line < size / 2){
					spaces--;
					stars += 2;
				}
				else{
					spaces ++;
					stars -=2;
				}
			}
		}
	}
}


