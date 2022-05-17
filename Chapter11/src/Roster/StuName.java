/*
Program: StuName.java          Last Date of this Revision: May 2, 2022
Purpose: To create a class that stores the first name, last name 
and toString methods. 
Author: Surkhab Mundi 
School: CHHS
Course: Computer Science 30
 
*/

//Adds StuName to roster package
package Roster;

import java.io.*;

//Class implements serializable
public class StuName implements Serializable 
{
	
	
	//First name variable
	private String firstName;
	
	//Last name variable
	private String lastName;
	
	
	//Constructor method
	public StuName(String fn, String ln) 
	{
		//Simplifies firstName and lastName variables
		firstName = fn;
		lastName = ln;
	}
	

	//Method returns first and last name
	public String toString() 
	{
		//String for displaying both first and last name
		String stuNameString;
		stuNameString = firstName + " " + lastName;
		
		//Returns first and last name 
		return(stuNameString);
	}

}
