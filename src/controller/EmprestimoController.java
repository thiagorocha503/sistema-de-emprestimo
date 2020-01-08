/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.EmprestimoTableModel;
import model.bean.Emprestimo;
import model.dao.EmprestimoDAO;
import util.DateConversionException;
import util.Service;

/**
 *
 * @author thiago
 */
public class EmprestimoController {
    
    private final EmprestimoTableModel emprestimoTabelModel;
    
    public EmprestimoController( EmprestimoTableModel emprestimoTabelModel) {
        this.emprestimoTabelModel = emprestimoTabelModel;
    }
    
    public EmprestimoTableModel getEmprestimoTableModel(){
        return this.emprestimoTabelModel;
    }
    
    public void findByItem(String busca){
        EmprestimoDAO dao = new EmprestimoDAO();
        ArrayList<Emprestimo> emprestimos = dao.findByItem(busca);
        if(emprestimos == null){
            return;
        }
        // for in
        emprestimos.forEach((emprestimo) -> {
            this.emprestimoTabelModel.addEmprestimo(emprestimo);
        });

    }
    
     public void findAll(){
        EmprestimoDAO dao = new EmprestimoDAO();
        ArrayList<Emprestimo> emprestimos = dao.findAll();
        if(emprestimos == null){
            return;
        }
        //for in
        emprestimos.forEach((emprestimo) -> {
            this.emprestimoTabelModel.addEmprestimo(emprestimo);
        });

    }
    
    public boolean remover(int id){
        EmprestimoDAO dao = new EmprestimoDAO();
        if(dao.remove(id)){
            this.emprestimoTabelModel.removeAll();
            this.updateTable();
            return true;
        } else {
            return false;
        }
    }
    
    public boolean insert(String nome, String contato, String item, String dataEmprestimo, String dataDevolucao){
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setItem(item);
        emprestimo.setAmigoNome(nome);
        emprestimo.setAmigoContato(contato);
        try {
            emprestimo.setDataEmprestimo(Service.sqlDateToCalendar(dataEmprestimo));
            emprestimo.setDataDevolucao(Service.sqlDateToCalendar(dataDevolucao));
        } catch (DateConversionException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
            Logger.getLogger(EmprestimoController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        EmprestimoDAO dao = new EmprestimoDAO();
        if (dao.insert(emprestimo)){
            this.updateTable();
            return true;
        } else {
            return false;
        }
    }
    
    public boolean update(int id, String nome, String contato, String item, String dataEmprestimo, String dataDevolucao, String datadevolvido){
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(id);
        emprestimo.setItem(item);
        emprestimo.setAmigoNome(nome);
        emprestimo.setAmigoContato(contato);
        try {
            emprestimo.setDataEmprestimo(Service.sqlDateToCalendar(dataEmprestimo));
            emprestimo.setDataDevolucao(Service.sqlDateToCalendar(dataDevolucao));
        } catch (DateConversionException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
            Logger.getLogger(EmprestimoController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        EmprestimoDAO dao = new EmprestimoDAO();
        if (dao.update(emprestimo)){
            this.updateTable();
            return true;
        } else {
            return false;
        }
    }
    
    public void updateTable(){
        EmprestimoDAO dao = new EmprestimoDAO();
        ArrayList<Emprestimo> emprestimos = dao.findAll();
        this.emprestimoTabelModel.updateTable(emprestimos);
    }
    
    public boolean devolver(int id, String data){
        try {
            EmprestimoDAO dao = new EmprestimoDAO();
            Emprestimo emprestimo = dao.getEmprestimo(id);
            emprestimo.setDataDevolvido(Service.sqlDateToCalendar(data));
            if(emprestimo != null){
                if(new EmprestimoDAO().update(emprestimo)){
                    return true;
                } else {
                    return false;
                }
            } else{
                JOptionPane.showMessageDialog(null, "Emprestimo não encontrado");
                return false;
            }
        } catch (DateConversionException ex) {
            //Logger.getLogger(EmprestimoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
            return false;
        }
        
    }
}
