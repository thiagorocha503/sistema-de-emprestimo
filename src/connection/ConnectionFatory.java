/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.File;
import java.sql.*;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.sqlite.Function;


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
            // Criar função REGEXP
            Function.create(conn, "REGEXP", new Function() {
                @Override
                protected void xFunc() throws SQLException {
                    String expression = value_text(0);
                    String value = value_text(1);
                    if (value == null){
                        value = "";
                    }                        
                    Pattern pattern=Pattern.compile(expression);
                    result(pattern.matcher(value).find() ? 1 : 0);
                    }
                }
            );
            initilazeDataBase(conn);
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
        String sql = "CREATE TABLE IF NOT EXISTS emprestimo (" +
                    "    id             INTEGER PRIMARY KEY AUTOINCREMENT" +
                    "                           NOT NULL," +
                    "    item_nome      CHAR    NOT NULL," +
                    "    pessoa_nome    CHAR    NOT NULL," +
                    "    pessoa_contato CHAR    CHECK (pessoa_contato REGEXP '^\\(\\d{1,2}\\)\\d{1,5}-\\d{1,3}\\d$')," +
                    "    dtEmprestimo   DATE    NOT NULL" +
                    "                           CHECK (DATE(dtEmprestimo, '+0 days') IS dtEmprestimo) " +
                    "                           DEFAULT (DATE('now') )," +
                    "    dtDevolucao    DATE    NOT NULL" +
                    "                           CHECK ( (DATE(dtDevolucao, '+0 days') IS dtDevolucao) AND " +
                    "                                   (DATE(dtDevolucao) >= DATE(dtEmprestimo) ) )," +
                    "    dtDevolvido    DATE    CHECK ( (DATE(dtDevolvido, '+0 days') IS dtDevolvido AND " +
                    "                                    DATE(dtDevolvido) >= DATE(dtEmprestimo) ) OR " +
                    "                                   (dtDevolvido IS NULL) ) " +
        ");";
        PreparedStatement stmt=null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex, "erro", JOptionPane.ERROR_MESSAGE);
        }       
    }   
    
}
