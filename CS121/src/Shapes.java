import java.util.Scanner;

public class Shapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int star, size;
		double space;

		Scanner scan = new Scanner (System.in);

		System.out.println("How large would you like the shape? ");
		size= scan.nextInt();

		star= 1;
		space= size/2.0;

		for(int count = 1; count <=size; count++){
			for(int x=0; x < space; x++)
				System.out.print(" ");

			for(int x = 0; x < star; x++)
				System.out.print("*");

			System.out.println();

			if (count<=size/2){
				star+=2;
				space--;}
			else if (count > size/2){
				star-=2;
				space++;}
		}
		System.out.println();
		star = 2;
		space = size - star;

		for (int count = 1; count <= size; count++){
			if(count != size/2.0){
				for(int x = 0; x < star/2.0; x++)
					System.out.print("*");

				for(int x = 0; x < space; x++)
					System.out.print(" ");

				for(int x = 0; x < star/2.0; x++)
					System.out.print("*");}

			else
				for(int x = 0; x < star; x++)
					System.out.print("*");

			System.out.println();
			if(count==size/2.0){
				star--;
				space+=2;}
			else if(count==(size/2.0)-1){
				star++;
				space-=2;}
			else if(count < size/2.0){
				star+=2;
				space-=2;}
			else if(count < size/2.0){
				star-=2;
				space+=2;}
		}


	}
}


