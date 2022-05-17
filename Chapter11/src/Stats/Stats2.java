/*
Program: Stats2.java          Last Date of this Revision: April 25, 2022
Purpose: To modify the stats application to allow the user to enter the 
name and grades of the students. The user should be prompted for the
name of the file to create and for the number of student grades that 
will be entered. After the data has been entered and written to a
file, the file should be read and the lowest, highest and average 
grades should be diplayed.
Author: Surkhab Mundi 
School: CHHS
Course: Computer Science 30
 
*/

//Put class into stats package
package Stats;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Stats2 class
public class Stats2 
{
	
	//Main method
	public static void main(String[] args)
	{
		
		//User input
		Scanner userInput = new Scanner(System.in);
		
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
		double stuGrade;
		int userNum;
		String fileName;
		String stuName;
		
		//Prompts user for the number of grades they would like to enter
		System.out.println("Please enter the number of student grades that you would like to enter: ");
		userNum = userInput.nextInt();
		
		//Prompts user for the name of the file they would like to create/overwrite
		System.out.println("Please enter the name of the file: ");
		fileName = userInput.next();
		fileName = fileName + ".txt";
		
		
		File gradeFile = new File(fileName);
		FileWriter out;
	
		BufferedWriter writeFile;

		try 
		{
			out = new FileWriter(gradeFile);
			writeFile = new BufferedWriter(out);
			
			for (int i = 0; i < userNum; i++) 
			{
				
				  //Prompts user for the students names
				  System.out.print("Please enter the student's name: ");
				  stuName = userInput.next();
				  
				  //Prompts user for the students grades
				  System.out.print("Please enter the student's grade: ");
				  stuGrade = userInput.nextDouble();
				  
				  //Write name and score to file
				  writeFile.write(stuName);
				  writeFile.newLine();
				  writeFile.write(String.valueOf(stuGrade));
				  writeFile.newLine();
			}
			
			writeFile.close();
			out.close();
			
			
			//Outputs data has been recorded to file message
			System.out.println("\nData has been recorded to the file. ");
			
			//Exception
		} catch (IOException e)
		
		{
			System.out.println("There was a problem writing to the file. ");
			System.err.println("IOException: " + e.getMessage());
				
		}
		
		
		try 
		{
			in = new FileReader(gradeFile);
			readFile = new BufferedReader(in);
			
			
			//Header text
			System.out.println("\nName:\t\tGrade:" );
			
			//Read line until there is a white space
			while((line = readFile.readLine()) != null) 
			{
				
				//Outputs name and grades of students
				System.out.println(line + "\t");
				numGrades +=1;
				line = readFile.readLine();
				grade = Double.parseDouble(line);
				System.out.println("\t\t" + line+"%");
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
		
			//Output highest grade, lowest grade and average
			System.out.println("\n"+ "Highest grade is: " + highGrade + "%");
			System.out.println("Lowest grade is: " + lowGrade + "%");
			avgGrade = totalGrades / numGrades;
			System.out.println("Average = " + avgGrade + "%");
	}
		
		//Exceptions
		catch(FileNotFoundException e) 
		{
			System.out.println("The file does not exist or could not be found");
			System.err.println("FileNotFoundException: " + e.getMessage());
		}
		
		catch(IOException e)
		
		{
			System.out.println("There was a problem reading the file");
			System.err.println("IO Exception: " + e.getMessage());
		}
	}
}
