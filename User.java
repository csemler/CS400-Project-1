// --== CS400 File Header Information ==--
// Name: Christopher Semler
// Email: csemler@wisc.edu
// Team: CG
// Role: DataWrangler2
// TA: Yeping
// Lecturer: Florian
// Notes to Grader: nope

public class User
{
	private String username;
	private String encPass;
	private boolean isAdmin;
	
	//constructor to set up User object
	public User(String name, String password, boolean isAdmin)
	{
		username = name;
		encPass = password;
		this.isAdmin = isAdmin;
	}

	//returns User's username
	public String getUsername()
	{
		return username;
	}

	//sets User's username
	public void setUsername(String name)
	{
		username = name;
	}

	//returns user's encrypted password
	//the encrypted passwrod is each char * 2
	public String getPasswordEncrypted()
	{
		return encPass;
	}

	//sets user's password that has already been encrypted
	public void setPasswrodEncyrpted(String password)
	{
		encPass = password;
	}

	//returns if user is an admin or not
	public boolean isAdmin()
	{
		return isAdmin;
	}

	//sets the user's admin status
	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
}
