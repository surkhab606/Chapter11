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

package Stats;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Stats2 
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		
		FileReader in;
		
		BufferedReader readFile;
	
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
		
		
		System.out.println("Please enter the number of student grades that you would like to enter: ");
		userNum = userInput.nextInt();
		
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
				
				  System.out.print("Please enter the student's name: ");
				  stuName = userInput.next();
				  
				  System.out.print("Please enter the student's grade: ");
				  stuGrade = userInput.nextDouble();
				  
				  //write name and score to file
				  writeFile.write(stuName);
				  writeFile.newLine();
				  writeFile.write(String.valueOf(stuGrade));
				  writeFile.newLine();
			}
			
			writeFile.close();
			out.close();
			
			System.out.println("\nData has been recorded to the file. ");
			
		} catch (IOException e)
		
		{
			System.out.println("There was a problem writing to the file. ");
			System.err.println("IOException: " + e.getMessage());
				
		}
		
		try 
		{
			in = new FileReader(gradeFile);
			readFile = new BufferedReader(in);
			
			
			
			System.out.println("\nName:\t\tGrade:" );
			
		
			while((line = readFile.readLine()) != null) 
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
		
		
			System.out.println("\n"+ "Highest grade is: " + highGrade + "%");
			System.out.println("Lowest grade is: " + lowGrade + "%");
			avgGrade = totalGrades / numGrades;
			System.out.println("Average = " + avgGrade + "%");
	}
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
