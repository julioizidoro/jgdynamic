/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber.Relatorios;

import java.util.Date;

/**
 *
 * @author Wolverine
 */
public class RelContasReceberTodas {
    
    private int idCliente;
    private String nomeCliente;
    private String telefone01;
    private String telefone02;
    private Date dataConta;
    private float valorConta;
    private float valorCredito;
    private float valorDevido;
    private int diasAtraso;
    private String formaPagamento;
    private int diaFechamento;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone01() {
        return telefone01;
    }

    public void setTelefone01(String telefone01) {
        this.telefone01 = telefone01;
    }

    public String getTelefone02() {
        return telefone02;
    }

    public void setTelefone02(String telefone02) {
        this.telefone02 = telefone02;
    }

    public Date getDataConta() {
        return dataConta;
    }

    public void setDataConta(Date dataConta) {
        this.dataConta = dataConta;
    }

    public float getValorConta() {
        return valorConta;
    }

    public void setValorConta(float valorConta) {
        this.valorConta = valorConta;
    }

    public float getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(float valorCredito) {
        this.valorCredito = valorCredito;
    }

    public float getValorDevido() {
        return valorDevido;
    }

    public void setValorDevido(float valorDevido) {
        this.valorDevido = valorDevido;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getDiaFechamento() {
        return diaFechamento;
    }

    public void setDiaFechamento(int diaFechamento) {
        this.diaFechamento = diaFechamento;
    }

}
