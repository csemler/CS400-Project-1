public class User
{
	private String username;
	private String encPass;
	private boolean isAdmin;

	public User(String name, String password, boolean isAdmin)
	{
		username = name;
		encPass = password;
		this.isAdmin = isAdmin;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String name)
	{
		username = name;
	}

	public String getPasswordEncrypted()
	{
		return encPass;
	}

	public void setPasswrodEncyrpted(String password)
	{
		encPass = password;
	}

	public boolean isAdmin()
	{
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
}
