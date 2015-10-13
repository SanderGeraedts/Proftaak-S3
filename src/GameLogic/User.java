package GameLogic;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class User {

    private int userID;
    private String name;
    private String email;
    private Stat stats;

    /**
     * Constructor for User If stats is null stats must be created.
     *
     * @param userID Cannot be null and must be unique.
     * @param name Cannot be null and must be unique.
     * @param email Cannot be null.
     * @param stats can be null.
     */
    public User(int userID, String name, String email, Stat stats) {
        throw new NotImplementedException();
    }
    
    public int getStatID()
    {
        return stats.getStatsID();
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Login method for verifying user. Checks in database if name and password
     * has correspondig account. if User exist then return user with
     * corresponding stats
     *
     * @param name
     * @param password
     * @return User if account exists otherwise return null.
     */
    public User login(String name, String password) {
        throw new NotImplementedException();
    }

    /**
     * Create account Creates an account in the database.
     *
     * @param userid cannot not be null and must be unique.
     * @param name cannot not be null and must be unique.
     * @param password cannot not be null.
     * @param email cannot be null.
     * @param stats cannot be null.
     * @return true if succesfully added in database.
     */
    public Boolean createAccount(String userid, String name, String password, String email, Stat stats) {
        throw new NotImplementedException();
    }

    /**
     * Changes stats after a game ended.
     *
     * @param kills how many players were killed by player.
     * @param deaths how many times player died.
     * @param win if the game is won must be true, lost is false;
     */
    public void changeStats(int kills, int deaths, boolean win) {
        throw new NotImplementedException();
    }
}
