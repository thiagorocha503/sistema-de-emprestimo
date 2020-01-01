/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author thiago
 */
public class Emprestimo {
    private String item;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String dataDevolvido;
    private String AmigoContato;
    private String AmigoNome;

    public Emprestimo() {
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
        return AmigoContato;
    }

    public void setAmigoContato(String AmigoContato) {
        this.AmigoContato = AmigoContato;
    }

    public String getAmigoNome() {
        return AmigoNome;
    }

    public void setAmigoNome(String AmigoNome) {
        this.AmigoNome = AmigoNome;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "item=" + item + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", dataDevolvido=" + dataDevolvido + ", AmigoContato=" + AmigoContato + ", AmigoNome=" + AmigoNome + '}';
    }
    
    
    
    
}
