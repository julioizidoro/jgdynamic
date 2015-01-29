/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber.FormaPagamento;

import java.util.Date;

/**
 *
 * @author wolverine
 */
public class CrFomaDiasBean {
    
    private Date data;
    private Double dineiro;
    private Double cheque;
    private Double chequePre;
    private Double cartaoDebito;
    private Double cartaoCredito;
    private Double sicob;
    private Double creditoCliente;
    private Double total;

    public CrFomaDiasBean() {
        this.dineiro = 0.0;
        this.cheque =  0.0;
        this.chequePre =  0.0;
        this.cartaoDebito =  0.0;
        this.cartaoCredito =  0.0;
        this.sicob =  0.0;
        this.creditoCliente=0.0;
        this.total=0.0;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getDineiro() {
        return dineiro;
    }

    public void setDineiro(Double dineiro) {
        this.dineiro = dineiro;
    }

    public Double getCheque() {
        return cheque;
    }

    public void setCheque(Double cheque) {
        this.cheque = cheque;
    }

    public Double getChequePre() {
        return chequePre;
    }

    public void setChequePre(Double chequePre) {
        this.chequePre = chequePre;
    }

    public Double getCartaoDebito() {
        return cartaoDebito;
    }

    public void setCartaoDebito(Double cartaoDebito) {
        this.cartaoDebito = cartaoDebito;
    }

    public Double getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(Double cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Double getSicob() {
        return sicob;
    }

    public void setSicob(Double sicob) {
        this.sicob = sicob;
    }

    public Double getCreditoCliente() {
        return creditoCliente;
    }

    public void setCreditoCliente(Double creditoCliente) {
        this.creditoCliente = creditoCliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    
}
