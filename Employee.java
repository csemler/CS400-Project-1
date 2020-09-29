// --== CS400 File Header Information ==--
// Name: Christopher Semler
// Email: csemler@wisc.edu
// Team: CG
// Role: DataWrangler2
// TA: Yeping
// Lecturer: Florian
// Notes to Grader: nope

import java.time.LocalDate;

public class Employee
{
	private int employeeID;
	private String name;
	private LocalDate dateOfBirth;
	private LocalDate recordDate;
	private LocalDate hireDate;
	private String jobTitle;
	private String gender;
	private String status;
	private String businessUnit;
	
	public Employee()
	{
		employeeID = 0;
		name = "";
		dateOfBirth = null;
		recordDate = null;
		hireDate = null;
		jobTitle = "";
		gender = "";
		status = "";
		businessUnit = "";
	}

	public Employee(int id, String name, LocalDate birth, LocalDate record, LocalDate hire, String title, String gender, String status, String unit)
	{
		employeeID = id;
		this.name = name;
		dateOfBirth = birth;
		recordDate = record;
		hireDate = hire;
		jobTitle = title;
		this.gender = gender;
		this.status = status;
		businessUnit = unit;
	}

	public int getID()
	{
		return employeeID;
	}

	public String getName()
	{
		return name;
	}

	public LocalDate getDateOfBirth()
	{
		return dateOfBirth;
	}

	public LocalDate getRecordDate()
	{
		return recordDate;
	}

	public LocalDate getHireDate()
	{
		return hireDate;
	}

	public String getJobTitle()
	{
		return jobTitle;
	}

	public String getGender()
	{
		return gender;
	}

	public String getStatus()
	{
		return status;
	}

	public String getBusinessUnit()
	{
		return businessUnit;
	}

	public void setID(int id)
	{
		employeeID = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setDateOfBirth(LocalDate date)
	{
		dateOfBirth = date;
	}

	public void setRecordDate(LocalDate date)
	{
		recordDate = date;
	}

	public void setHireDate(LocalDate date)
	{
		hireDate = date;
	}

	public void setJobTitle(String title)
	{
		jobTitle = title;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public void setBusinessUnit(String unit)
	{
		businessUnit = unit;
	}
}
