
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thiago
 */
public class testes {
    
    public static void main(String[] args) {
        Date data;
        data = new Date();
        data.setMonth(12);
        
        Calendar calendario;
        calendario = Calendar.getInstance();
        calendario.set(2020, 20, 3);
        
        System.err.println(">>> "+calendario);
        
        
        
    }
    
}
