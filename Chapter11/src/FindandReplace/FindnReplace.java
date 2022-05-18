/*
Program: FindnReplace.java          Last Date of this Revision: May 5, 2022
Purpose: To create a FindAndReplace application that prompts the user for 
a file name, a search word or phrase, and a replacement word or phrase. 
After entering the replacement word or phrase, FindAndReplace finds all 
occurrences of the search word or phrase and replaces with the replacement
words or phrases.
Author: Surkhab Mundi 
School: CHHS
Course: Computer Science 30
 
*/

//Added to FindandReplace package
package FindandReplace;

import java.io.*;
import java.util.Scanner;


public class FindnReplace 
{

	//Main method
	public static void main(String[] args) 
	{

		//Variables used
        FileWriter out;
        String fileName;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        
        //Variable for original word
        String ogWord = "";

		
		
        //Prompts user for the name of the file
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter the name of your file: ");
		
		//Finds the file that the user has written
		fileName = userInput.nextLine();
		fileName = fileName + ".txt";
		File dataFile = new File(fileName);
		
		//Prompts user for what word/phrase they would like to find 
		System.out.println("What word or phrase would you like to find?");
		String findWord = userInput.nextLine();
		
		//Prompts user for what word/phrase they would like to replace the found word with 
		System.out.println("What word or phrase would you like to replace " + findWord + " with?");
		String replaceWord = userInput.nextLine();
		
		try 
		{
			reader = new BufferedReader(new FileReader(dataFile));
			String Line = reader.readLine();
			
			//Reads the current line
			while(Line != null) 
			{
				//Add lines read to the original word variable
				ogWord += Line + System.lineSeparator();
				
				
				//Read line
				Line = reader.readLine();
				
				
			}
			
			//New variable replaces all the words
			String newWord = ogWord.replaceAll(findWord, replaceWord);
			

			//Write the new words to the file
			writer = new BufferedWriter(new FileWriter(dataFile));
	
			
			writer.write(newWord);
			
			//Outputs that new words have been written to the file 
			System.out.println("New words have been written to the file");
			
			
			reader.close();
			writer.close();
			
		}
		
	
		//Exceptions
		catch(IOException e)
		
		{
			System.out.println("Problem Reading File");
			System.err.println("IO Exception: " + e.getMessage());
		}
		
	}
	
}


/* SCREEN DUMP

Please enter the name of your file: 
filestudents
What word or phrase would you like to find?
Johnson
What word or phrase would you like to replace Johnson with?
Surkhab
New words have been written to the file

 */

