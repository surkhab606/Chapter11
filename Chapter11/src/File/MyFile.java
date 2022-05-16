/*
Program: MyFile.java          Last Date of this Revision: April 12, 2022
Purpose: To create an application that prompts the user for the name of a file and then displays 
a message that indicates whether the file exists or not.
Author: Surkhab Mundi 
School: CHHS
Course: Computer Science 30
 
*/

//Added to file package
package File;


import java.util.Scanner;
import java.io.*;

public class MyFile 
{
	//Main method
	public static void main(String[] args)
	{
		//User input variable
		String userInput;
		
		//Prompts user to enter file name
		System.out.println("Enter the file name you would like to check: ");
		Scanner inp = new Scanner(System.in);
		userInput = inp.nextLine() + ".txt";
		
		File textFile = new File(userInput);
		
		//If a text file with the same name as the name the user inputted exists, print "File already exists."
		if (textFile.exists())
		{
			//Output file already exists message
			System.out.println("File already exists.");
		}
		
		//If a text file with the same name as the name the user inputted doesn't exist, print "File doesn't exists."
		else 
		{
			//Output file does not exist message
			System.out.println("File doesn't exist.");
		}
	}
	
	

}


/* SCREEN DUMP
Enter the file name you would like to check: 
ssdf
File doesn't exist.

Enter the file name you would like to check: 
test1
File already exists.


*/ 