/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFatory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Emprestimo;

/**
 *
 * @author thiago
 */
public class EmprestimoDAO {
    
    private final Connection conn;

    public EmprestimoDAO() {
        this.conn = ConnectionFatory.getConnection();
    }
    
    public ArrayList<Emprestimo> findAll(){
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        final String sql = "SELECT * FROM emprestimo";
        if (this.conn == null){
            JOptionPane.showMessageDialog(null, "Não foi possivel se conectar ao banco de dados", "erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        PreparedStatement stmt=null;
        try {         
            stmt = this.conn.prepareStatement(sql);
            ResultSet rows = stmt.executeQuery();
            while(rows.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rows.getInt("id"));
                emprestimo.setItem(rows.getString("item_nome"));
                emprestimo.setAmigoNome(rows.getString("pessoa_nome"));
                emprestimo.setAmigoContato(rows.getString("pessoa_contato"));
                emprestimo.setDataEmprestimo(rows.getString("dtEmprestimo"));
                emprestimo.setDataDevolucao(rows.getString("dtDevolucao"));
                emprestimo.setDataDevolvido(rows.getString("dtDevolvido"));
                emprestimos.add(emprestimo);               
            }
            return emprestimos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex, "erro", JOptionPane.ERROR_MESSAGE);
            return emprestimos;
        } finally{
            ConnectionFatory.closeConnection(conn, stmt);
        }
       
        
    }
    
    public boolean insert(Emprestimo emprestimo) {
        final String sql = "INSERT INTO emprestimo(item_nome, pessoa_nome, pessoa_contato, dtEmprestimo, dtDevolucao) VALUES(?, ?, ?, ?, ?)";
        if (this.conn == null){
            JOptionPane.showMessageDialog(null, "Não foi possivel se conectar ao banco de dados", "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        PreparedStatement stmt =null;
        try {
            stmt= this.conn.prepareStatement(sql);
            stmt.setString(1, emprestimo.getItem());
            stmt.setString(2, emprestimo.getAmigoNome());
            stmt.setString(3, emprestimo.getAmigoContato());
            stmt.setString(4, emprestimo.getDataEmprestimo());
            stmt.setString(5, emprestimo.getDataDevolucao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex, "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally{
            ConnectionFatory.closeConnection(conn, stmt);
        }
    }
    
    public boolean remove(int id){
        final String sql = "DELETE FROM emprestimo where id=?";
        if (this.conn == null){
            JOptionPane.showMessageDialog(null, "Não foi possivel se conectar ao banco de dados", "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        PreparedStatement stmt =null;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex, "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally{
            ConnectionFatory.closeConnection(conn, stmt);
        }
        
    }
    
    public boolean update(Emprestimo emprestimo){
        final String sql = "UPDATE emprestimo  SET item_nome=?, pessoa_nome=?, pessoa_contato=?, dtEmprestimo=?, dtDevolucao=?, dtDevolvido=? WHERE id=?";
        if (this.conn == null){
            JOptionPane.showMessageDialog(null, "erro", "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        PreparedStatement stmt =null;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, emprestimo.getItem());
            stmt.setString(2, emprestimo.getAmigoNome());
            stmt.setString(3, emprestimo.getAmigoContato());
            stmt.setString(4, emprestimo.getDataEmprestimo());
            stmt.setString(5, emprestimo.getDataDevolucao());
            stmt.setString(6, emprestimo.getDataDevolvido());
            stmt.setInt(7, emprestimo.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex, "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally{
            ConnectionFatory.closeConnection(conn, stmt);
        }
    }
    
     public ArrayList<Emprestimo> findByItem(String item){
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        final String sql = "SELECT * FROM emprestimo WHERE item_nome LIKE ?";
        if (this.conn == null){
            JOptionPane.showMessageDialog(null, "Não foi possivel se conectar ao banco de dados", "erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        PreparedStatement stmt=null;
        try {         
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,"%"+item+"%");
            ResultSet rows = stmt.executeQuery();
            while(rows.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rows.getInt("id"));
                emprestimo.setItem(rows.getString("item_nome"));
                emprestimo.setAmigoNome(rows.getString("pessoa_nome"));
                emprestimo.setAmigoContato(rows.getString("pessoa_contato"));
                emprestimo.setDataEmprestimo(rows.getString("dtEmprestimo"));
                emprestimo.setDataDevolucao(rows.getString("dtDevolucao"));
                emprestimo.setDataDevolvido(rows.getString("dtDevolvido"));
                emprestimos.add(emprestimo);               
            }
            return emprestimos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex, "erro", JOptionPane.ERROR_MESSAGE);
            return emprestimos;
        } finally{
            ConnectionFatory.closeConnection(conn, stmt);
        }
       
        
    }
     
   
    public boolean devolver(int id, String data){
        final String sql = "UPDATE emprestimo  SET dtDevolvido=? WHERE id=?";
        if (this.conn == null){
            JOptionPane.showMessageDialog(null, "erro", "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        PreparedStatement stmt=null;
        try {
             stmt = this.conn.prepareStatement(sql);
             stmt.setString(1, data);
             stmt.setInt(2, id);
             stmt.executeUpdate();
             return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            ConnectionFatory.closeConnection(conn, stmt);
        }
    }
}
