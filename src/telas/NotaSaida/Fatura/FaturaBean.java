/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida.Fatura;

import java.util.List;

/**
 *
 * @author Wolverine
 */
public class FaturaBean {
    
    private int idFatura;
    private String numero;
    private float valorOrigianl;
    private float valorDesconto;
    private float valorLiquido;
    private List<DuplicataBean> listaDuplicata;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getValorOrigianl() {
        return valorOrigianl;
    }

    public void setValorOrigianl(float valorOrigianl) {
        this.valorOrigianl = valorOrigianl;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public float getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(float valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public List<DuplicataBean> getListaDuplicata() {
        return listaDuplicata;
    }

    public void setListaDuplicata(List<DuplicataBean> listaDuplicata) {
        this.listaDuplicata = listaDuplicata;
    }

    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }
    
    
    
}
