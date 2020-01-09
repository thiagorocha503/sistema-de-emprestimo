/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author thiago
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author thiago
 */
public class ServiceTest extends TestCase {
    
    public ServiceTest() {
    }

    @Test
    public void testCalendaToSqlDateDay() {
        Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, 2020);
        data.set(Calendar.MONTH, 0);//Janeiro = 0, fevereiro = 1 [...]
        //Dias de 1 a 9
        for(int day=1;day<10; day++){
            data.set(Calendar.DAY_OF_MONTH, day);
            this.assertEquals(Service.calendarToDateSQL(data), "2020-01-"+"0"+String.valueOf(day));
        }
        //Dias de 10 a 31
        for (int day=10;day<32;day++){
            data.set(Calendar.DAY_OF_MONTH, day);
            this.assertEquals(Service.calendarToDateSQL(data), "2020-01-"+String.valueOf(day));
        }
    }
    
    @Test
    public void testCalendaToSqlDateMonth() {
        Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, 2020);
        data.set(Calendar.DAY_OF_MONTH, 1); 
        // Meses de 1 a 9 OBS: Janeiro = 0, fevereiro = 1 [...]
        for (int month=0; month <=8;month++){
            data.set(Calendar.MONTH, month);
            this.assertEquals(Service.calendarToDateSQL(data), "2020-"+"0"+String.valueOf(month +1)+"-01");
        }
        // Meses de 10 1a 12
        data.set(Calendar.MONTH, 9);
        this.assertEquals(Service.calendarToDateSQL(data), "2020-10-01");
        data.set(Calendar.MONTH, 10);
        this.assertEquals(Service.calendarToDateSQL(data), "2020-11-01");
        data.set(Calendar.MONTH, 11);
        this.assertEquals(Service.calendarToDateSQL(data), "2020-12-01");
        
    }
    
    @Test
    public void testCalendaToSqlDateYear() {
        // teste anos
        Calendar data = Calendar.getInstance();
        data.set(Calendar.DAY_OF_MONTH, 1);
        data.set(Calendar.MONTH, 1); //Janeiro = 0, fevereiro = 1 [...]
        
        // ano de 1 a 9
        for (int i = 1; i < 10; i++){
            data.set(Calendar.YEAR, i);
            this.assertEquals(Service.calendarToDateSQL(data) , "000"+String.valueOf(i)+"-02-01" );
        }
        // ano de 10 a 99
        for (int i = 10; i < 100; i++){
            data.set(Calendar.YEAR, i);
            this.assertEquals(Service.calendarToDateSQL(data) , "00"+String.valueOf(i)+"-02-01" );
        }
        // anos entre 100 e 999
        data.set(Calendar.YEAR, 100);
        this.assertEquals(Service.calendarToDateSQL(data) , "0100-02-01" );
        data.set(Calendar.YEAR, 200);
        this.assertEquals(Service.calendarToDateSQL(data) , "0200-02-01" );
        data.set(Calendar.YEAR, 300);
        this.assertEquals(Service.calendarToDateSQL(data) , "0300-02-01" );
        data.set(Calendar.YEAR, 500);
        this.assertEquals(Service.calendarToDateSQL(data) , "0500-02-01" );
        data.set(Calendar.YEAR, 999);
        this.assertEquals(Service.calendarToDateSQL(data) , "0999-02-01" );
        
        // anos mais de 1000
        data.set(Calendar.YEAR, 1000);
        this.assertEquals(Service.calendarToDateSQL(data) , "1000-02-01" );
        data.set(Calendar.YEAR, 2000);
        this.assertEquals(Service.calendarToDateSQL(data) , "2000-02-01" );
        
        
        
    }
    @Test
    public void testSqlDateToCalendar(){
        String sql = "2020-01-05";
        Calendar data;
        try {
            //testa meses OBS: Janeiro = 0
            for(int i =1; i<10;i++){
                sql = "2020-" +"0"+String.valueOf(i)+ "-05";
                data = Service.sqlDateToCalendar(sql);
                this.assertEquals(data.get(Calendar.DAY_OF_MONTH), 5);
                this.assertEquals(data.get(Calendar.MONTH), i-1);
                this.assertEquals(data.get(Calendar.YEAR), 2020);      
            }
            
            data = Service.sqlDateToCalendar("2020-11-05");
            this.assertEquals(data.get(Calendar.DAY_OF_MONTH), 5);
            this.assertEquals(data.get(Calendar.MONTH), 10);
            this.assertEquals(data.get(Calendar.YEAR), 2020);      
            
            data = Service.sqlDateToCalendar("2020-12-05");
            this.assertEquals(data.get(Calendar.DAY_OF_MONTH), 5);
            this.assertEquals(data.get(Calendar.MONTH), 11);
            this.assertEquals(data.get(Calendar.YEAR), 2020);      
                        
        } catch (DateConversionException ex) {
            Logger.getLogger(ServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
            
        }
    }   
    

}
