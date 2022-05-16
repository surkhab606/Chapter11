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


package Roster;

import java.io.*;
import java.util.Scanner;

public class RosterClass
{
	public static void main(String[] args)
	
	{
		
		Scanner userInput = new Scanner(System.in);
		
		
		String fileName;
		int userNum;
		String fName;
		String lName;
		
		System.out.println("Please enter the name of your file: ");
		fileName = userInput.next();
		fileName = fileName + ".txt";
		
		File stuFile = new File(fileName);

		System.out.println("Please enter then number of students in your class: ");
		userNum = userInput.nextInt();
		
		try 
		{	
			FileOutputStream out = new FileOutputStream(stuFile);
			ObjectOutputStream writeStu = new ObjectOutputStream(out);
			
			for (int i = 0; i < userNum; i++) 
			{
				
				
				  //Get First Name and Last Name of Student From User
				  System.out.print("Enter Student First Name: ");
				  fName = userInput.next();
				  
				  System.out.print("Enter Student Last Name: ");
				  
				  lName = userInput.next();
				  writeStu.writeObject(new StuName(fName, lName));
				  
			}
			
			writeStu.close();
			System.out.println("Data Has Been Written To File");
			
			
			FileInputStream in = new FileInputStream(stuFile);
		    ObjectInputStream readStuName = new ObjectInputStream(in);
		    
		    
		    for (int i = 0; i < userNum; i++) 
			{
					   System.out.println((StuName)readStuName.readObject());
		   
			}
		    
		    
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
	
	

