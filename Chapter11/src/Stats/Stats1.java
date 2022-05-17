/*
Program: Stats1.java          Last Date of this Revision: April 13, 2022
Purpose: To create a Stats application that reads names and scores from 
a data file named test1.dat, supplied with this text. The Stats application
should read and display each name and score. After all the scores have been
displayed, the lowest score, highest score, and average score should be 
displayed. 
Author: Surkhab Mundi 
School: CHHS
Course: Computer Science 30
 
*/


//Class added to Stats package
package Stats;

import java.io.*;
import java.text.NumberFormat;


//Stats1 class
public class Stats1 
{
	//Main method
	public static void main(String[] args)
	{
		
		//New file named dataFile
		File dataFile = new File("test1.txt");
		
		//Reads data and converts bytes to characters
		FileReader in;
		
		//Reads text from a character input stream
		BufferedReader readFile;
		
		//Variables
		String line;
		double avgGrade;
		double highGrade = 0;
		double lowGrade = 100;
		double totalGrades = 0;	
		int numGrades = 0;
		double grade = 0;
		
		
		try {
			
			//Heading text
			System.out.println("Name: \t\t\tScore:");
			in = new FileReader(dataFile);
			readFile = new BufferedReader(in);
		
			//Read the line until you reach white space
			while ((line = readFile.readLine()) != null)
			{
				
				//Print out names and grades
				System.out.println(line + "\t");
				numGrades +=1;
				line = readFile.readLine();
				grade = Double.parseDouble(line);
				System.out.println("\t\t\t" + line);
				totalGrades += Double.parseDouble(line);
				
				//If the current grade is higher thant the highestGrade, the current grade becomes the highestGrade
				if (grade > highGrade)
				{
					highGrade = grade;
				}
				
				//If the current grade is lower thant the lowestGrade, the current grade becomes the lowestGrade
				if (grade < lowGrade) 
				{
					
					lowGrade = grade;
				}
				
			}
				//Print out the highest grade, lowest grade and average
				System.out.println("\n"
						+ "Highest grade is: " + highGrade);
				System.out.println("Lowest grade is: " + lowGrade);
				avgGrade = totalGrades / numGrades;
				System.out.println("Average = " + avgGrade);
				
		
	
			
			//close the file 
			readFile.close();
			in.close();
			
			//Exceptions
		} catch (FileNotFoundException e)
		
		{
			System.out.println("File does not exist or could not be found. Please check the validity of the file.");
			System.err.println("FileNotFoundException " + e.getMessage());
		} catch (IOException e)
		
		{
			System.out.println("There was a problem reading the file.");
			System.err.println("IOException: " + e.getMessage());
		}
	}
	

}

/*
SCREEN DUMP
Name: 			Score:
Ali   				
			90 
Surkhab 			
			95
Matthew		 		
			95
Carter 				
			69

Highest grade is: 95.0
Lowest grade is: 69.0
Average = 87.25


 */
	