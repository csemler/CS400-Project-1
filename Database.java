// --== CS400 File Header Information ==--
// Name: Christopher Semler
// Email: csemler@wisc.edu
// Team: CG
// Role: DataWrangler2
// TA: Yeping
// Lecturer: Florian
// Notes to Grader: nope

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

public class Database 
{
	private HashTableMap<Integer, Employee> employeeInfo;
	
	public Database() throws FileNotFoundException
	{
		File file = new File("Users/chris/Downloads/employee_info.txt");
		Scanner scan = new Scanner(file);
		
		//Format: id, name, date/of/birth, date/of/record, date/of/hire, title, gender, status,  unit
		int id;
		String name;
		int day;
		int month;
		int year;
		LocalDate birth;
		LocalDate record;
		LocalDate hire;
		String title;
		String gender;
		String status;
		String unit;
		String line;
		String[] parts;
		String[] dateParts;

		while (scan.hasNext())
		{
			line = scan.next();
			parts = line.split(",");

			id = Integer.parseInt(parts[0]);
			name = parts[1];
			
			//separate the dateOfBirth into Strings that can be converted to int and then into a LocalDate object
			//Format for dates: month/day/year
			dateParts = parts[2].split("/");
			month = Integer.parseInt(dateParts[0]);
			day = Integer.parseInt(dateParts[1]);
			year = Integer.parseInt(dateParts[2]);
			birth = LocalDate.of(year, month, day);

			//updates dateParts to contain parts of dateOfRecord
			dateParts = parts[3].split("/");
			month = Integer.parseInt(dateParts[0]);
			day = Integer.parseInt(dateParts[1]);
			year = Integer.parseInt(dateParts[2]);
			record = LocalDate.of(year, month, day);

			//updates dateParts to contain parts of dateOfHire
			dateParts = parts[4].split("/");
			month = Integer.parseInt(dateParts[0]);
			day = Integer.parseInt(dateParts[1]);
			year = Integer.parseInt(dateParts[2]);
			hire = LocalDate.of(year, month, day);

			title = parts[5];
			gender = parts[6];
			status = parts[7];
			unit = parts[8];

			Employee emp = new Employee(id, name, birth, record, hire, title, gender, status, unit);
		
			addEmployee(emp);
		}
	}

	//returns hash table with all the Employee info
	public HashTableMap<Integer, Employee> allEmployeesInfo()
	{
		return employeeInfo;
	}

	//add an Employee object into the hashtable
	//returns true if successful
	//false if Employee is already added to the list
	public boolean addEmployee(Employee object)
	{
		if (containEmployeeByID(object.getID()))
			return false;

		employeeInfo.put(object.getID(), object);
		
		return true;		
	}

	//find and return the Employee object given an ID number
	//return null if no Employee found
	public Employee getEmployeeInfoByID(int employeeID)
	{
		if (containEmployeeByID(employeeID) == false)
			return null;
		
		Employee output = null;

		try
	       	{
			output = employeeInfo.get(employeeID);
		}
		catch (NoSuchElementException e)
		{
			return null;
		}

		return output;
	}

	//update the Employee object given an ID
	//return true if sucessful
	//return false if not found
	public boolean updateEmployeeByID(int employeeID, Employee object)
	{
		if (containEmployeeByID(employeeID) == false)
			return false;

		//removes Employee object
		employeeInfo.remove(employeeID);
		//readds Employee object
		employeeInfo.put(employeeID, object);
		
		return true;
	}

	//detete an Employee given an ID
	//returns true if successful
	//returns false if Employee doesn't exist
	public boolean deleteEmployeeByID(int employeeID)
	{
		if (containEmployeeByID(employeeID) == false)
			return false;

		employeeInfo.remove(employeeID);

		return true;
	}

	//checks if an Employee exists
	//returns true if Employee does
	//retursn false if Employee does not exit
	public boolean containEmployeeByID(int employeeID)
	{
		if (employeeInfo.containsKey(employeeID) == true)
			return true;
		else
			return false;
	}

	//clears hash table
	public void clearEmployees()
	{
		employeeInfo.clear();
	}
}
