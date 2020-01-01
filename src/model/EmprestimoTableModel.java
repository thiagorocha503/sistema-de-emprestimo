/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.bean.Emprestimo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author thiago
 */
public class EmprestimoTableModel  extends AbstractTableModel{
    
    private ArrayList<Emprestimo> rows = new ArrayList<>();
    private String[] colums = {"item","nome","contato","data de emprestimo", "data de devolução","data devolvido"};
    
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
    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return this.rows.get(row).getItem();
            case 1:
                return this.rows.get(row).getAmigoNome();
            case 2:
                return this.rows.get(row).getAmigoContato();
            case 3:
                return this.rows.get(row).getDataEmprestimo();
            case 4:
                return this.rows.get(row).getDataDevolucao();
            case 5:
                return this.rows.get(row).getDataDevolvido();             
        }
        return null;
    }
    @Override
    public void setValueAt(Object o, int row, int column) {
        switch(column) {
            case 0:
                this.rows.get(row).setItem(o.toString());
                break;
            case 1:
                this.rows.get(row).setAmigoNome(o.toString());
                break;
            case 2:
                this.rows.get(row).setAmigoContato(o.toString());
                break;
            case 3:
                this.rows.get(row).setDataEmprestimo(o.toString());
                break;
            case 4:
                this.rows.get(row).setDataDevolucao(o.toString());
                break;
            case 5:
                this.rows.get(row).setDataDevolvido(o.toString());            
        }
        this.fireTableRowsUpdated(row, row);
    }
}
