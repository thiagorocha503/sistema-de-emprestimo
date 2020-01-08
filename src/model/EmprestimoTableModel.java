/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.bean.Emprestimo;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author thiago
 */
public class EmprestimoTableModel  extends AbstractTableModel{
    
    private final ArrayList<Emprestimo> rows = new ArrayList<>();
    private final String[] colums = {"id","item","nome","contato","data de emprestimo", "data de devolução","data devolvido"};
    
    @Override
    public String getColumnName(int column){
        return this.colums[column];
    }
    
    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    @Override
    public int getColumnCount() {
        return this.colums.length;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        this.rows.add(emprestimo);
        this.fireTableDataChanged();
    }
    
    public void removeEmprestimo(int row){
        this.rows.remove(row);
        this.fireTableRowsDeleted(row, row);
    }
    
    //
    public void updateTable(ArrayList<Emprestimo> emprestimos){
        //apaga tudo  
        if(emprestimos != null){
            this.removeAll();
            for(Emprestimo emprestimo: emprestimos){
                this.addEmprestimo(emprestimo);
            }
        }
    }
    
    public void removeAll(){
        this.rows.clear();
        fireTableRowsDeleted(0,getRowCount());
    
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        Calendar data;
        String day, month, year;
        switch(column) {
            case 0:
                return this.rows.get(row).getId();
            case 1:
                return this.rows.get(row).getItem();
            case 2:
                return this.rows.get(row).getAmigoNome();
            case 3:
                return this.rows.get(row).getAmigoContato();
            case 4:
                data = this.rows.get(row).getDataEmprestimo();
                return calendarFormat(data);
            case 5:
                data = this.rows.get(row).getDataDevolucao();
                return calendarFormat(data);
            case 6:
                data = this.rows.get(row).getDataDevolvido();
                return calendarFormat(data);
        }
        return null;
    }
    @Override
    public void setValueAt(Object o, int row, int column) {
        switch(column) {
            case 0:
                this.rows.get(row).setId(Integer.parseInt(o.toString()));
                break;
            case 1:
                this.rows.get(row).setItem(o.toString());
                break;
            case 2:
                this.rows.get(row).setAmigoNome(o.toString());
                break;
            case 3:
                this.rows.get(row).setAmigoContato(o.toString());
                break;
            case 4:
                this.rows.get(row).setDataEmprestimo((Calendar)o);
                break;
            case 5:
                this.rows.get(row).setDataDevolucao((Calendar)o);
                break;
            case 6:
                this.rows.get(row).setDataDevolvido((Calendar)o);
                break;
            default:
                throw new RuntimeException("Coluna inexistente");
        }
        this.fireTableRowsUpdated(row, row);
    }
    
    public String calendarFormat(Calendar c){
        if(c == null){
            return "";
        }
        String day, month, year;
        //Day
        if (c.get(Calendar.DAY_OF_MONTH) < 10){
            day= "0"+String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        } else {
            day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        }
        //Month
        if (c.get(Calendar.MONTH)+1 < 10){// January = 0, Februray = 1 [...]
            month = "0"+String.valueOf(c.get(Calendar.MONTH)+1);
        } else {
            month = String.valueOf(c.get(Calendar.MONTH)+1);
        }
        year = String.valueOf(c.get(Calendar.YEAR));
        return day+"/"+month+"/"+year;
    }
}
