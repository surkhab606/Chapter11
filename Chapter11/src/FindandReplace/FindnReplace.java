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

package FindandReplace;

import java.io.*;
import java.util.Scanner;

public class FindnReplace 
{

	public static void main(String[] args) 
	{

	
        FileWriter out;
        String fileName;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String ogWord = "";

		
		
      
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter the name of your file: ");
		fileName = userInput.nextLine();
		fileName = fileName + ".txt";
		File dataFile = new File(fileName);
		
		
		
		System.out.println("What Word or Phrase Would You Like to Find");
		String findWord = userInput.nextLine();
		
		
		
		
		System.out.println("What Word or Phrase Would You Like to Replace " + findWord + " With");
		String replaceWord = userInput.nextLine();
		
		
		
		
		try 
		{

			
			reader = new BufferedReader(new FileReader(dataFile));
			
			
			String currentLine = reader.readLine();
			
			
			
			while(currentLine != null) 
			{
				
				ogWord += currentLine + System.lineSeparator();
				
				
				//Read Line
				currentLine = reader.readLine();
				
				
			}
			
			
			String newData = ogWord.replaceAll(findWord, replaceWord);
			

			
			writer = new BufferedWriter(new FileWriter(dataFile));
			
			writer.write(newData);
			
			
			System.out.println("New Data Written To File");
			
			
			reader.close();
			writer.close();
			
		}
		
	

		catch(IOException e)
		
		{
			System.out.println("Problem Reading File");
			System.err.println("IO Exception: " + e.getMessage());
		}
		
	}
	
}
