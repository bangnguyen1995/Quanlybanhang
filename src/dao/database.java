/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class database {
     public static Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;"
                + "databaseName=Quanlybanhangvanphongpham;user=sa;password=123";

        Connection con = DriverManager.getConnection(connectionUrl);

        return con;
    }
    
}
