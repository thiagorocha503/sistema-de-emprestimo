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
    private String[] colums = {"id","item","nome","contato","data de emprestimo", "data de devolução","data devolvido"};
    
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
                return this.rows.get(row).getDataEmprestimo();
            case 5:
                return this.rows.get(row).getDataDevolucao();
            case 6:
                return this.rows.get(row).getDataDevolvido();             
        }
        return null;
    }
    @Override
    public void setValueAt(Object o, int row, int column) {
        System.err.println(">>> "+column);
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
                this.rows.get(row).setDataEmprestimo(o.toString());
                break;
            case 5:
                this.rows.get(row).setDataDevolucao(o.toString());
                break;
            case 6:
                this.rows.get(row).setDataDevolvido(o.toString());
                break;
            default:
                throw new RuntimeException("Coluna inexistente");
        }
        this.fireTableRowsUpdated(row, row);
    }
}
