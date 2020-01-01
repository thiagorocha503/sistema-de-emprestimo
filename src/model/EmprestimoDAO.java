/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.ConnectionFatory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Emprestimo;

/**
 *
 * @author thiago
 */
public class EmprestimoDAO {
    
    private Connection conn;

    public EmprestimoDAO() {
        this.conn = ConnectionFatory.getConnection();
    }
    
    public boolean insert(Emprestimo emprestimo) {
        final String sql = "INSERT INTO emprestimo(item_nome, pessoa_nome, pessoa_contato, dtEmprestimo, dtDevolucao) VALUES(?, ?, ?, ?, ?)";
        if (this.conn == null){
            JOptionPane.showMessageDialog(null, "erro", "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, emprestimo.getItem());
            stmt.setString(2, emprestimo.getAmigoNome());
            stmt.setString(3, emprestimo.getAmigoContato());
            stmt.setString(4, emprestimo.getDataEmprestimo());
            stmt.setString(5, emprestimo.getDataDevolucao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
}
