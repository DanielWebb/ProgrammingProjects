import java.io.File;	//tells java what a file is
import java.io.BufferedWriter;	//writes text to a character output stream
import java.io.FileWriter;	//writes to a file
import java.io.IOException;	//input/output exception
import java.util.Scanner;	//we know what scanner is
import java.text.DecimalFormat;	//standard number formatter

public class QBstats {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		int count=0;	
		double attempts=0, completions=0, yards=0, touchdowns=0, interceptions=0;
		double a, b, c, d, passerrating;
		String line="", fname="", lname="", fileName;
		Scanner fileScan, lineScan, scan;	//scanner objects for input
		DecimalFormat df=new DecimalFormat ("#.000");
		DecimalFormat df2=new DecimalFormat ("#");

		scan = new Scanner(System.in);

		System.out.println("Enter the file name: ");
		fileName=scan.next();	
		fileScan = new Scanner (new File(fileName));	//scans file (fileName)

		fileScan.nextLine();	//scans the first line and throws it away
		//Thanks Stacks Overflow
		try {

			File file = new File("qbstats.html");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("<html><body><table>");	//opening to html
			bw.write("<tr><th>Quarterback Statistics</th></tr>");	//first line of table
			bw.write("<tr><th>Quarterback Name</th><th>Games</th><th>Comp</th><th>Att</th><th>Comp %</th><th>Yds</th><th>Yds/Att</th><th>TD</th><th>Int</th><th>Rating</th></tr>");

			System.out.println("Quarterback Statistics");
			System.out.println("Input File: " + fileName);
			System.out.println("QBName\t\tGames\tComp\tAtt\tComp %\tYds\tYds/Att\tTD\tInt\tRating");
			while (fileScan.hasNextLine())	//checks if file has a next line
			{
				attempts=0; completions=0; yards=0; touchdowns=0; interceptions=0;
				line=fileScan.nextLine();	//taking the qb name and games
				lineScan = new Scanner (line);
				while (lineScan.hasNext())	//parses line for first name, last name, and count
				{
					fname=lineScan.next();	
					lname=lineScan.next();
					count=lineScan.nextInt();
				}
				for (int x=0; x < count; x++)	//count driven loop for all stats
				{
					line=fileScan.nextLine();
					lineScan = new Scanner (line);
					while (lineScan.hasNext())	//parses line for stats
					{
						lineScan.next();
						completions+=lineScan.nextDouble();
						attempts+=lineScan.nextDouble();
						yards+=lineScan.nextDouble();
						touchdowns+=lineScan.nextDouble();
						interceptions+=lineScan.nextDouble();
					}
				}
				//computations for passer rating
				a= ((completions/attempts) - .3) * 5;
				a= Math.max(0, Math.min(a, 2.375));
				b= ((yards/attempts) - 3) * .25;
				b= Math.max(0, Math.min(b, 2.375));
				c= ((touchdowns/attempts) * 20);
				c= Math.max(0, Math.min(c, 2.375));
				d= 2.375 - ((interceptions/attempts) * 25);
				d= Math.max(0, Math.min(d, 2.375));

				passerrating= ((a + b + c + d)/6) * 100;
				
				//prints formatting for html and consule output
				bw.write("<tr><td>" + fname + " " + lname + "</td><td>" + count + "</td><td>" + df2.format(completions) + "</td><td>" + df2.format(attempts) + "</td><td>" + df.format((completions/attempts) * 100) + "</td><td>" + df2.format(yards) + "</td><td>" + df.format(yards/attempts) + "</td><td>" + df2.format(touchdowns) + "</td><td>" + df2.format(interceptions) + "</td><td>" + df.format(passerrating)+ "</td></tr>");
				System.out.println(fname + " " + lname + "\t" + count + "\t" + df2.format(completions) + "\t" + df2.format(attempts) + "\t" + df.format((completions/attempts) * 100) + "\t" + df2.format(yards) + "\t" + df.format(yards/attempts) + "\t" + df2.format(touchdowns) + "\t" + df2.format(interceptions) + "\t" + df.format(passerrating));
			}
			//ending to html output
			bw.write("</table></body></html>");
			bw.close();
			//catch statement necessary if program broken
		} catch(Exception e){
			
		}



	}

}