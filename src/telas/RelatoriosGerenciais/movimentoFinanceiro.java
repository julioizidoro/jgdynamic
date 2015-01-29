/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.RelatoriosGerenciais;

import java.util.Date;

/**
 *
 * @author Wolverine
 */
public class movimentoFinanceiro {
    
    private Date data;
    private double vendaVista;
    private double vendaPrazo;
    private double cartaoCredito;
    private double chequePre;
    private double totalVendas;
    private double recebimentos;
    private double totalGeral;
    private double credito;
    private double desconto;
    
    
    public movimentoFinanceiro() {
        this.data = new Date();
        this.vendaVista = 0;
        this.vendaPrazo = 0;
        this.cartaoCredito = 0;
        this.chequePre = 0;
        this.totalVendas = 0;
        this.recebimentos = 0;
        this.totalGeral = 0;
        credito=0;
        desconto=0;
    }

    
    
    public double getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(double cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public double getChequePre() {
        return chequePre;
    }

    public void setChequePre(double chequePre) {
        this.chequePre = chequePre;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getRecebimentos() {
        return recebimentos;
    }

    public void setRecebimentos(double recebimentos) {
        this.recebimentos = recebimentos;
    }

    public double getTotalGeral() {
        return totalGeral;
    }

    public void setTotalGeral(double totalGeral) {
        this.totalGeral = totalGeral;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getVendaPrazo() {
        return vendaPrazo;
    }

    public void setVendaPrazo(double vendaPrazo) {
        this.vendaPrazo = vendaPrazo;
    }

    public double getVendaVista() {
        return vendaVista;
    }

    public void setVendaVista(double vendaVista) {
        this.vendaVista = vendaVista;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    
}
