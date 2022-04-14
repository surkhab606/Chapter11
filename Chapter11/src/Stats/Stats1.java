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
		String grade;
		double avgGrade;
		double highGrade = 0;
		double lowGrade = 100;
		double totalGrades = 0;	
		int numGrades = 0;
		
		
	}
	

}
