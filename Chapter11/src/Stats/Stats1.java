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
		
		FileReader in;
		
		BufferedReader readFile;
		
		
		String line;
		double avgGrade;
		double highGrade = 0;
		double lowGrade = 100;
		double totalGrades = 0;	
		int numGrades = 0;
		double grade = 0;
		
		try {
		
			System.out.println("Name: \t\t\tScore:");
			in = new FileReader(dataFile);
			readFile = new BufferedReader(in);
		
			while ((line = readFile.readLine()) != null)
			{
				
				
				System.out.println(line + "\t");
				
				numGrades +=1;
				line = readFile.readLine();
				grade = Double.parseDouble(line);
				System.out.println("\t\t\t" + line);
				totalGrades += Double.parseDouble(line);
				
				if (grade > highGrade)
				{
					highGrade = grade;
				}
				
				if (grade < lowGrade) 
				{
					
					lowGrade = grade;
				}
				
			}
				System.out.println("\n"
						+ "Highest grade is: " + highGrade);
				System.out.println("Lowest grade is: " + lowGrade);
				avgGrade = totalGrades / numGrades;
				System.out.println("Average = " + avgGrade);
				
		
	
			
			
			readFile.close();
			in.close();
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
	