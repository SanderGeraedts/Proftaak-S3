/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;

/**
 *
 * @author Hovsep
 */
public class DatabaseConnection {
    Connection conn;
    
    public DatabaseConnection() {
        String url = "jdbc:mysql:http://codepanda.nl/phpmyadmin/index.php?db=sanderge_PTS3&table=Stats&target=tbl_structure.php&token=0b3c6beec57be97199390638cccb4ccd#PMAURL:server=1&target=main.php&token=0b3c6beec57be97199390638cccb4ccd";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "sanderge_PTS3";
        String password = "ProftaakS34C";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
