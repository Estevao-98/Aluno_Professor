/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevao
 */
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost/pessoa";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
    
    private static Connection con;
    
    public static Connection openConnection() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        con = (Connection) DriverManager.getConnection(URL, USER, PASS);
        return con;
    }
    public static void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
