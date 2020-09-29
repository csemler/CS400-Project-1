// --== CS400 File Header Information ==--
// Name: Christopher Semler
// Email: csemler@wisc.edu
// Team: CG
// Role: DataWranger2
// TA: Yeping
// Lecturer: Florian
// Notes to Grader: none

public class LogInDatabase
{
	private HashTable<String, User> userTable;

	public String encryption(String password)
	{
		char[] chars = password.toCharArray();
		for (int i = 0; i < chars.length; i++)
			chars[i] += 8;

		return String.valueOf(chars);
	}

	public boolean logIn(String username, String password)
	{
		if (isUserExist(username) == false)
			return false;
		String encrypPass = encryption(password);
		return userTable.get(username).getPasswordEncrypted().equals(encrypPass);
	}

	public boolean addUser(String username, String password, boolean isAdmin)
	{
		if (isUserExist(username) == true)
			return false;

		User temp = new User(username, encryption(password), isAdmin);
		userTable.put(username, temp);

		return true;
	}

	public boolean isUserExist(String username)
	{
		return userTable.containsKey(username);
	}

	public boolean isAdmin(String username)
	{
		return userTable.get(username).isAdmin();
	}
}
