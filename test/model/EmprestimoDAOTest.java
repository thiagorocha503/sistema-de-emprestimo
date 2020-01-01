/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.bean.Emprestimo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thiago
 */
public class EmprestimoDAOTest {
    
    public EmprestimoDAOTest() {
    }

    @Test
    public void testInsert() {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setAmigoNome("thiago");
        emprestimo.setAmigoContato("86995084417");
        emprestimo.setItem("E se fosse agente?");
        emprestimo.setDataEmprestimo("31122019");
        emprestimo.setDataDevolucao("07012020");
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        emprestimoDAO.insert(emprestimo);
    }
    
}
