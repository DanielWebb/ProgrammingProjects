import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class QuizGrader {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		String answerKey, studentFile;
		Scanner fileScan;
		final int KEY = 10; //the number of questions on the quiz or answer key
		int totalStudents;
		
		//Scans in the file used as an answer key
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file name used for the answer key: ");  
		answerKey=scan.next();  
		fileScan = new Scanner (new File(answerKey));
		
		int[] answers = new int[KEY];  //creates array which will be filled with the correct quiz answers
		for (int x = 0; x < 10; x++){  //loop which stores the answer key to an array
			answers[x]=fileScan.nextInt();  //fills the array with the the correct answers to the quiz
		}
		//Scans the file with the student's names and answers
		System.out.println("Enter the file name: ");
		studentFile=scan.next();
		fileScan = new Scanner (new File(studentFile));
		
		//reads how many students are in the file, or how many times we will compare the 2 files
		totalStudents = fileScan.nextInt();
		
		String[] names = new String[totalStudents];  //array for student names
		int[] studentAnswers = new int[totalStudents];  //array for the student answers to be compared to correct answers
		int[] questions = new int [KEY];  //array to record how often the questions were answered correctly
		//echos back the input files
		System.out.println("The files you have chosen are: " + answerKey + " and " + studentFile);
		
		for(int x = 0; x < totalStudents; x++){  //outer for loop is counter for how many students quizzes will be graded
			names[x]=fileScan.next() + " " + fileScan.next();  //reads first and last name into name array as a string
			
			int correct = 0;  //initialized count for question loop
			
			for(int y = 0; y < answers.length; y++){  //loop which stores student answers to an array
				if(answers[y]==fileScan.nextInt()){  //compares the student answer to the correct answer
					correct++; questions[y]++;  //increments counter for questions right and 
				}
			}
			studentAnswers[x] = correct * 10;  //converts correct answers into 100 base
			
			//print statements to the console
			System.out.println("Student name: " + names[x]);
			System.out.println("Student score: " + studentAnswers[x] + "%");
			System.out.println();
		}
		//prints the percentage of students who answered the question correctly
		for (int x = 0; x < questions.length; x++){  
			System.out.println("Question " + (x+1) + " was answered correctly " + (questions[x] * 100 / totalStudents) + "% of the time.") ;
		}
		try {  //HTML creation...doesn't quite work

			File file = new File("quizresults.html");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("<html><body><table>");	//opening to html
			bw.write("<tr><th>Quiz Results</th></tr>");	//first line of table
			bw.write("<tr><th>Quiz Results</th><th>Name</th><th>Grade</th></tr>");

			
				
				//prints formatting for html
				bw.write("<tr><td>" + names[totalStudents] + " " + studentAnswers[totalStudents] + "</tr>");
			
			//ending to html output
			bw.write("</table></body></html>");
			bw.close();
			//catch statement necessary if program broken
		} catch(Exception e){
			
		}
	}

}
