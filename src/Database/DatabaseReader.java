/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import GameLogic.User;
import java.sql.*;

/**
 *
 * @author Hovsep
 */
public class DatabaseReader {

    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        System.out.println("Username: "+db.getUsername() + "\nPassword: " + db.getPassword());
        for (User user : db.getUsers())
        {
            System.out.println("Userlijst: "+user.getName());
        }
        
    }
}
