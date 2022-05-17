/*
Program: RosterClass.java          Last Date of this Revision: May 2, 2022
Purpose: To create a Roster application that prompts the user for the name of
the file to store student names and then prompts the user for the number of 
students in a class. The application should then prompt the user for the 
first and last name of each student and write this data to a file. After 
all the data is written to a file, the application should display the
roster with one name after the other in a list. 
Author: Surkhab Mundi 
School: CHHS
Course: Computer Science 30
 
*/

//Adds RosterClass to roster package
package Roster;

import java.io.*;
import java.util.Scanner;

//Roster class
public class RosterClass
{
	//Main method
	public static void main(String[] args)
	
	{
		
		//User input 
		Scanner userInput = new Scanner(System.in);
		
		//Variables for file name, user input, first name and last name
		String fileName;
		int userNum;
		String fName;
		String lName;
		
		//Prompts user for the name of the file
		System.out.println("Please enter the name of your file: ");
		fileName = userInput.next();
		fileName = fileName + ".txt";
		
		//Creates a new file with the name that the user entered
		File stuFile = new File(fileName);

		//Prompts user for the number of students in the class
		System.out.println("Please enter then number of students in your class: ");
		userNum = userInput.nextInt();
		
		
		try 
		{	
			//Write objects
			FileOutputStream out = new FileOutputStream(stuFile);
			ObjectOutputStream writeStu = new ObjectOutputStream(out);
			
			
			for (int i = 0; i < userNum; i++) 
			{
				
				  //Prompts user for the students first name 
				  System.out.print("Enter Student First Name: ");
				  fName = userInput.next();
				  
				  //Prompts user for the students last name
				  System.out.print("Enter Student Last Name: ");
				  lName = userInput.next();
				  
				  //Write the students name to file 
				  writeStu.writeObject(new StuName(fName, lName));
				  
			}
			
			writeStu.close();
			System.out.println("Data Has Been Written To File");
			
			
			FileInputStream in = new FileInputStream(stuFile);
		    ObjectInputStream readStuName = new ObjectInputStream(in);
		    
		    
		    for (int i = 0; i < userNum; i++) 
			{
		    		   //Prints student names
					   System.out.println((StuName)readStuName.readObject());
		   
			}
		    
		    //Close file 
		    readStuName.close();
		}
			
		  //Exceptions
			catch(FileNotFoundException e) 
			{
				System.out.println("File Could Not be Found");
				System.out.println("File Not Found Exception" + e.getMessage());
			}
			
			catch(IOException e)
			
			{
				System.out.println("Problem Reading File");
				System.err.println("IO Exception: " + e.getMessage());
			}

			catch(ClassNotFoundException e) 
			{
				System.out.println("Class Not Found Exception" + e.getMessage());
				
			}
			
			
		}
		
		
		
}
	
	

