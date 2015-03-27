/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beanController;

import java.util.Date;

/**
 *
 * @author wolverine
 */
public class NotaEletronica {

    private String numero;
    private Date dataEmissao;
    private Date dataSaida;
    private float valorTotal;
    private String naturezaOperacao;
    private String tipoOperacao;
    private String formaPagamento;
    private float baseICMS;
    private float valorICMS;
    private float baseICMSST;
    private float valorICMSST;
    private float valorProdutos;
    private float valorFrete;
    private float valorSeguro;
    private float valorOutrasDespesass;
    private float valorIPI;
    private float valorDesconto;
    private String numeroFatura;
    private float valorFatura;
    private String serie;
    private String subSerie;

    public float getBaseICMS() {
        return baseICMS;
    }

    public void setBaseICMS(float baseICMS) {
        this.baseICMS = baseICMS;
    }

    public float getBaseICMSST() {
        return baseICMSST;
    }

    public void setBaseICMSST(float baseICMSST) {
        this.baseICMSST = baseICMSST;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public void setNaturezaOperacao(String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(String numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSubSerie() {
        return subSerie;
    }

    public void setSubSerie(String subSerie) {
        this.subSerie = subSerie;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public float getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(float valorFatura) {
        this.valorFatura = valorFatura;
    }

    public float getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(float valorFrete) {
        this.valorFrete = valorFrete;
    }

    public float getValorICMS() {
        return valorICMS;
    }

    public void setValorICMS(float valorICMS) {
        this.valorICMS = valorICMS;
    }

    public float getValorICMSST() {
        return valorICMSST;
    }

    public void setValorICMSST(float valorICMSST) {
        this.valorICMSST = valorICMSST;
    }

    public float getValorIPI() {
        return valorIPI;
    }

    public void setValorIPI(float valorIPI) {
        this.valorIPI = valorIPI;
    }

    public float getValorOutrasDespesass() {
        return valorOutrasDespesass;
    }

    public void setValorOutrasDespesass(float valorOutrasDespesass) {
        this.valorOutrasDespesass = valorOutrasDespesass;
    }

    public float getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(float valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public float getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(float valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
