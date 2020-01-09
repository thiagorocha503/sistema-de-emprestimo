/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author thiago
 */
public class ConnectionFatory {
    
    private static final String ROOT = new File("").getAbsolutePath();
    private static final String PATH = ROOT + "\\data\\dataBase.db";
    private static final String PATH_SQL ="jdbc:sqlite:" + PATH;

    public static String getPATH() {
        return PATH;
    }
    
    
    
    public static Connection  getConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(ConnectionFatory.PATH_SQL);
            initilazeDataBase(conn);
            //System.out.println("Coneção realizada com sucesso!");
            return conn;
        } catch (SQLException ex) {
            System.err.println("Erro SQLException "+ex);
            return null;
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ClassNotFound: "+ex);
            return null;
        }
    }
    
    
    public static void closeConnection(Connection conn){
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro: "+ex);
            }
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        ConnectionFatory.closeConnection(conn);
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro: "+ex);
            }
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet st){
       ConnectionFatory.closeConnection(conn, stmt);
        if (stmt != null){
            try {
                st.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro: "+ex);
            }
        }
    }
    
    public static void initilazeDataBase(Connection conn){
        String sql = "CREATE TABlE IF NOT EXISTS emprestimo (" +
                    "    id             INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "    item_nome      CHAR    NOT NULL," +
                    "    pessoa_nome    CHAR    NOT NULL," +
                    "    pessoa_contato CHAR," +
                    "    dtEmprestimo   DATE    NOT NULL," +
                    "    dtDevolucao    DATE    NOT NULL," +
                    "    dtDevolvido    DATE" +");  ";
        PreparedStatement stmt=null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex, "erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
