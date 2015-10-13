package GameLogicTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GameLogic.Stat;
import GameLogic.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roy
 */
public class StatTest {

    Stat st;

    public StatTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        st = new Stat(2, 2, 1, 10, 5, 5);
    }

    @After
    public void tearDown() {
    }

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
    @Test
    public void testConstructor() {
        // Stat is created in when user is created
        User u = new User(1, "Roy", "RoyTimmers_7@hotmail.com", null);
        assertEquals("Stat created in user should have same id as User", u.getUserID(), u.getStatID());
        Stat t = new Stat(1, 1, 1, 1, 1, 5);
        assertEquals("Should be 1", 1, t.getTotalKills());
        assertEquals("Should be 1", 1, t.getTotalDeaths());
        assertEquals("Should be 1", 1, t.getTotalLosses());
        assertEquals("Should be 1", 1, t.getTotalWins());

    }

    /**
     * Add kills
     *
     * @param kills how many players were killed.
     */
    @Test
    public void testAddKills() {
        int oldKills = st.getTotalKills();
        int newKills = 5;
        st.addKills(newKills);
        assertEquals("5 Kills should be added", oldKills + newKills, st.getTotalKills());
    }

    /**
     * Add deaths
     *
     * @param deaths how many times player died.
     */
    @Test
    public void testAddDeaths() {
        int oldDeaths = st.getTotalDeaths();
        int newDeaths = 2;
        st.addDeaths(newDeaths);
        assertEquals("2 Deaths should be added", oldDeaths + newDeaths, st.getTotalDeaths());

    }

    /**
     * Add wins or losses
     *
     * @param won if won is true one win is added otherwise one loss.
     */
    @Test
    public void testAddWinOrLose() {
        int oldWins = st.getTotalWins();
        int oldLoss = st.getTotalLosses();
        st.winOrLose(true);
        assertEquals("1 Win should be added", oldWins + 1, st.getTotalWins());
        st.winOrLose(false);
        assertEquals("1 Loss should be added", oldLoss + 1, st.getTotalLosses());

    }

}
