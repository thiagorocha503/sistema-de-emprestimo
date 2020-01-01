/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author thiago
 */
public class ConnectionFatory {
    
    private static final String PATH ="jdbc:sqlite:" + System.getProperty("user.dir")+"\\src\\data\\dataBase.db";
    
    public static Connection  getConnection(){
       
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(ConnectionFatory.PATH);
            //System.out.println("Coneção realizada com sucesso!");
            return conn;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return null;
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro: "+ex);
            return null;
        }
    }
    
    public static void main(String[] args){
        Object r = ConnectionFatory.getConnection();
    }
    
    
}
