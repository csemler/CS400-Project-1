// --== CS400 File Header Information ==--
// Name: Christopher Semler
// Email: csemler@wisc.edu
// Team: CG
// Role: DataWrangler2
// TA: Yeping
// Lecturer: Florian
// Notes to Grader: nope

public class LogInAndRegister
{
	private HashTable<String, User> userTable;
	
	//method to securely encrypt password
	//take each character and multiply by two
	public String encryption(String password)
	{
		char[] passChar = password.toCharArray();
		for (int i = 0; i < passChar.length; i++)
			passChar[i] += passChar[i];

		return String.valueOf(passChar);
	}

	//checks to see if user and password are in database and match
	//returns false if user doesn't exist or password is incorrect
	//returns true if user exists and password matches
	public boolean logIn(String username, String password)
	{
		if (isUserExist(username) == false)
			return false;
		String encrypPass = encryption(password);
		return userTable.get(username).getPasswordEncrypted().equals(encrypPass);
	}

	//adds user to HashTable
	//returns true if successful
	public boolean addUser(String username, String password, boolean isAdmin)
	{
		if (isUserExist(username) == true)
			return false;

		User temp = new User(username, encryption(password), isAdmin);
		userTable.put(username, temp);

		return true;
	}

	//checks to see if user exists based on username
	//returns result
	public boolean isUserExist(String username)
	{
		return userTable.containsKey(username);
	}
	
	//checks to see if user is admin
	//returs result
	public boolean isAdmin(String username)
	{
		return userTable.get(username).isAdmin();
	}
}
