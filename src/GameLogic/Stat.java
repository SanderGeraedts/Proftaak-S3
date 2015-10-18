package GameLogic;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Stat class used in User
 *
 * @author Roy
 */
public class Stat {

    private int statsID;
    private int totalWins;
    private int totalLosses;
    private int totalKills;
    private int totalDeaths;
    private int rating;
    //todo rating

    /**
     * Constructor for Stat
     *
     * @param statsid must be identical to userID
     * @param totalwins
     * @param totallosses
     * @param totalkills
     * @param totaldeaths
     * @param rating
     */
    public Stat(int statsid, int totalwins, int totallosses, int totalkills, int totaldeaths, int rating) {
        throw new NotImplementedException();

    }

    public int getStatsID() {
        return statsID;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    /**
     * Add kills
     *
     * @param kills how many players were killed.
     */
    public void addKills(int kills) {
        throw new NotImplementedException();
    }

    /**
     * Add deaths
     *
     * @param deaths how many times player died.
     */
    public void addDeaths(int deaths) {
        throw new NotImplementedException();
    }

    /**
     * Add wins or losses
     *
     * @param won if won is true one win is added otherwise one loss.
     */
    public void winOrLose(boolean won) {
        throw new NotImplementedException();
    }

    /**
     * //Samder: Isn't this method useless??? 
     * 
     * Give back the stats.
     *
     * @param totalWins
     * @param totalLosses
     * @param totalKills
     * @param totalDeaths
     * @param rating
     */
    public void requestStats() {
        throw new NotImplementedException();
    }
}
