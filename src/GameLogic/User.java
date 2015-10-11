package GameLogic;

public class User {

	private int userID;
	private String name;
	private String password;
	private String email;

	/**
	 * 
	 * @param userID
	 * @param name
	 * @param password
	 * @param email
	 */
	public User(int userID, String name, String password, String email) {
		this.userID = userID;
                this.name = name;
                this.password = password;
                this.email = email;
	}

}