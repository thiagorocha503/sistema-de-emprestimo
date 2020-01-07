package util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateConversion {
    
    /**
     * Retorna objeto calendar
     * 
     * @param calendar
     * @return 
     */
    public static String calendarToDateSQL(Calendar calendar){
        String day, month, year;
        //Day
        if (calendar.get(Calendar.DAY_OF_MONTH) < 10){
            day= "0"+String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        } else {
            day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        }
        //Month
        if (calendar.get(Calendar.MONTH)+1 < 10){// January = 0, Februray = 1 [...]
            month = "0"+String.valueOf(calendar.get(Calendar.MONTH)+1);
        } else {
            month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        }
        year = String.valueOf(calendar.get(Calendar.YEAR));
        return year+"-"+month+"-"+day;

    }


    public static Calendar sqlDateToCalendar(String date) throws DateConversionException {
        try{      
            DateFormat dateFormt = new SimpleDateFormat("yyyy-MM-dd");
            // bloqueiar correção de data
            dateFormt.setLenient (false);
            dateFormt.parse (date); 
            int year = Integer.parseInt(date.substring(0,3));
            int month = Integer.parseInt(date.substring(5,6));
            int day = Integer.parseInt(date.substring(8,9));
                     
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.MONTH, month - 1);
            calendar.set(Calendar.YEAR, year);
            return calendar;
        } catch( ParseException | ArrayIndexOutOfBoundsException ex){
            throw  new DateConversionException("Data inválida");
        }
        
    }
}
