/*
Program: StuName.java          Last Date of this Revision: May 2, 2022
Purpose: To create a class that stores the first name, last name 
and toString methods. 
Author: Surkhab Mundi 
School: CHHS
Course: Computer Science 30
 
*/

package Roster;

import java.io.*;


public class StuName implements Serializable 
{
	
	
	//Variables for first Name Last Name
	private String firstName;
	private String lastName;
	
	
	//constructor method
	public StuName(String fn, String ln) 
	{
		firstName = fn;
		lastName = ln;
	}
	

	//toString() Method that returns first name and last name
	public String toString() 
	{
		String stuNameString;
		
		
		stuNameString = firstName + " " + lastName;
		return(stuNameString);
	}

}
