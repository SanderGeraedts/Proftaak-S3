/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import GameLogic.Ability;
import GameLogic.PlayerRole;
import GameLogic.Stat;
import GameLogic.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hovsep
 */
public class DatabaseConnection {

    Connection conn;
    String username;

    private Stat stats;//testfield

    public DatabaseConnection() {
        String url = "jdbc:mysql://sql2.freesqldatabase.com:3306/";
        String dbName = "sql294852";
        String userName = "sql294852";
        String password = "dA7%fV6*";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connecting to database works");
        } catch (Exception e) {
            System.out.println("Connecting to database failed");
            e.printStackTrace();
        }
    }

    //todo
    public Stat getStat() {
        return null;
    }

    //todo
    public List<PlayerRole> getRole() {
        return null;
    }

    //todo
    public List<Ability> getAbility() {
        return null;
    }

    //test
    public String getUsername() throws SQLException {
        Statement st = conn.createStatement();
        st.executeQuery("SELECT * FROM User");
        ResultSet srs = st.getResultSet();
        username = "";
        while (srs.next()) {
            username = srs.getString("user_name");
        }
        return username;
    }

    public String getPassword() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet srs = st.executeQuery("SELECT * FROM User WHERE user_name = '" + username + "'");
        String password = "";
        while (srs.next()) {
            password = srs.getString("user_password");
        }
        st.close();
        return password;
    }

    //todo
    public ArrayList<User> getUsers() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet srs = st.executeQuery("SELECT * FROM User");
        ArrayList<User> userlist = new ArrayList<>();

        while (srs.next()) {
            int userid = srs.getInt("user_id");
            String username = srs.getString("user_name");
            String password = srs.getString("user_password");

            User usr = new User(userid, username, password, stats);
            userlist.add(usr);
        }
        st.close();
        return userlist;
    }

}
