/*
Program: MyFile2.java          Last Date of this Revision: April 12, 2022
Purpose: To create a MyFile application named zzz.txt and then displays a 
message indicating that the file has been created. The application should
prompt the user to either keep or delete the file. If the file is deleted, 
a message should notify the user when the file has been successfully deleted.
Author: Surkhab Mundi 
School: CHHS
Course: Computer Science 30
 
*/

//Added to file package
package File;

import java.io.*;
import java.util.Scanner;

//New class created called MyFile2
public class MyFile2 

{
	//Main method
	public static void main(String[] args)
	{
		//Created a new file called zzz.text
		File textFile = new File("zzz.text");
		System.out.println("File has been created");
		String userInput;
		
		
		do
		{
			//Prompt the user to either delete or keep the zzz.text file
			Scanner input = new Scanner(System.in);
			System.out.println("\nWould you like to delete (D) or keep (K) the file? \nQ to quit.");
			userInput = input.next();
			
			//If the user inputs "D" or "Delete", delete the zzz.text file
			if (userInput.equalsIgnoreCase("D") || (userInput.equalsIgnoreCase("Delete")))
			{
				//Deletes zzz.text file
				textFile.delete();
				//Outputs file has been deleted message
				System.out.println("File has been deleted.");
			}
			
			//If the user inputs "K" or "Keep", keep the zzz.text file
			if (userInput.equalsIgnoreCase("K") || (userInput.equalsIgnoreCase("Keep")))
			{
				//Outputs file has been kept message
				System.out.println("File has been kept.");
			}
		}
		
		//If the userInputs "Q" or "Quit", terminate the program.
		while (userInput.equalsIgnoreCase("Q") || (userInput.equalsIgnoreCase("Quit")));
				
		}
	}

/* SCREEN DUMP
 
File has been created

Would you like to delete (D) or keep (K) the file? 
Q to quit.
K
File has been kept.

File has been created

Would you like to delete (D) or keep (K) the file? 
Q to quit.
D
File has been deleted.

File has been created

Would you like to delete (D) or keep (K) the file? 
Q to quit.
Delete
File has been deleted.


 */
