/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.ConnectionFatory;
import java.io.File;
import java.util.Calendar;
import junit.framework.TestCase;
import model.bean.Emprestimo;
import model.dao.EmprestimoDAO;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DateConversionException;
import util.Service;

/**
 *
 * @author thiago
 */
public class EmprestimoDAOTest extends TestCase{
    
    public EmprestimoDAOTest() {
        
    }
    
    public void resetDataBase(){
        String path = ConnectionFatory.getPATH();
        File data = new File(path);
        if(data.exists()){
            data.deleteOnExit();
            System.err.println("Banco apagando com sucesso!");
            return;
        }
        
    }
    
    public Emprestimo getEmprestimo() throws DateConversionException{
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setAmigoNome("thiago");
        emprestimo.setAmigoContato("(86)99508-4417");
        emprestimo.setItem("e se fosse a gente?");
        emprestimo.setDataEmprestimo(Service.sqlDateToCalendar("2020-01-08"));
        emprestimo.setDataDevolucao(Service.sqlDateToCalendar("2020-01-16"));
        return emprestimo;
    }
    
    @Test
    public void testInsertAndRemove() throws DateConversionException {

        resetDataBase();
        Emprestimo emprestimo = getEmprestimo();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        //inserção
        this.assertEquals(emprestimoDAO.insert(emprestimo), true);
        
        emprestimoDAO = new EmprestimoDAO();
        emprestimo = emprestimoDAO.getEmprestimo(1);
        this.assertNotNull(emprestimo);
              
        this.assertEquals(emprestimo.getId(), 1);
        this.assertEquals(emprestimo.getItem(), "e se fosse a gente?");
        this.assertEquals(emprestimo.getAmigoNome(), "thiago");
        this.assertEquals(emprestimo.getAmigoContato(), "(86)99508-4417");
        this.assertEquals(emprestimo.getDataEmprestimo().get(Calendar.DAY_OF_MONTH), 8);
        this.assertEquals(emprestimo.getDataEmprestimo().get(Calendar.MONTH), 0);
        this.assertEquals(emprestimo.getDataEmprestimo().get(Calendar.YEAR), 2020);
        this.assertEquals(emprestimo.getDataDevolucao().get(Calendar.DAY_OF_MONTH), 16);
        this.assertEquals(emprestimo.getDataDevolucao().get(Calendar.MONTH), 0);
        this.assertEquals(emprestimo.getDataDevolucao().get(Calendar.YEAR), 2020);
        
        //remoção
        this.assertEquals(new EmprestimoDAO().remove(1), true);
    }   
    
    
    
}
