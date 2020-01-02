/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;


/**
 *
 * @author thiago
 */
public class Emprestimo {
    private int id;
    private String item;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String dataDevolvido;
    private String amigoContato;
    private String amigoNome;

    public Emprestimo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getDataDevolvido() {
        return dataDevolvido;
    }

    public void setDataDevolvido(String dataDevolvido) {
        this.dataDevolvido = dataDevolvido;
    }

    public String getAmigoContato() {
        return amigoContato;
    }

    public void setAmigoContato(String AmigoContato) {
        this.amigoContato = AmigoContato;
    }

    public String getAmigoNome() {
        return amigoNome;
    }

    public void setAmigoNome(String AmigoNome) {
        this.amigoNome = AmigoNome;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "item=" + item + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", dataDevolvido=" + dataDevolvido + ", AmigoContato=" + amigoContato + ", AmigoNome=" + amigoNome + '}';
    }
    
    
    
    
}
