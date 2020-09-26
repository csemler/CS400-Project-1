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

	public LocalDate getBirth()
	{
		return dateOfBirth;
	}

	public LocalDate getRecord()
	{
		return recordDate;
	}

	public LocalDate getHire()
	{
		return hireDate;
	}

	public String getTitle()
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

	public String getUnit()
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

	public void setBirth(LocalDate date)
	{
		dateOfBirth = date;
	}

	public void setRecord(LocalDate date)
	{
		recordDate = date;
	}

	public void setHire(LocalDate date)
	{
		hireDate = date;
	}

	public void setTitle(String title)
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

	public void setUnit(String unit)
	{
		businessUnit = unit;
	}
}
