/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.EmprestimoTableModel;
import model.bean.Emprestimo;
import model.dao.EmprestimoDAO;

/**
 *
 * @author thiago
 */
public class EmprestimoController {
    
    private EmprestimoTableModel emprestimoTabelModel;
    
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
        for(Emprestimo emprestimo: emprestimos){
            this.emprestimoTabelModel.addEmprestimo(emprestimo);
        }

    }
    
     public void findAll(){
        EmprestimoDAO dao = new EmprestimoDAO();
        ArrayList<Emprestimo> emprestimos = dao.findAll();
        if(emprestimos == null){
            return;
        }
        for(Emprestimo emprestimo: emprestimos){
            this.emprestimoTabelModel.addEmprestimo(emprestimo);
        }

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
        emprestimo.setDataEmprestimo(dataEmprestimo);
        emprestimo.setDataDevolucao(dataDevolucao);
        EmprestimoDAO dao = new EmprestimoDAO();
        if (dao.insert(emprestimo)){
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
    
    
}
