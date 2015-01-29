/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.View;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "viewentradaproduto")
public class Viewentradaproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEntradaProduto")
    @Id
    private int idEntradaProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorUnitario")
    private Float valorUnitario;
    @Column(name = "valorCusto")
    private Float valorCusto;
    @Column(name = "valorTotal")
    private Float valorTotal;
    @Column(name = "valorTotalCusto")
    private Float valorTotalCusto;
    @Column(name = "aliquitaICMS")
    private Double aliquitaICMS;
    @Column(name = "valorICMS")
    private Float valorICMS;
    @Column(name = "valorIPI")
    private Float valorIPI;
    @Column(name = "valorST")
    private Float valorST;
    @Column(name = "quantiaddeAnterior")
    private Double quantiaddeAnterior;
    @Column(name = "quantdadeAtual")
    private Double quantdadeAtual;
    @Size(max = 1)
    @Column(name = "preco")
    private String preco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "docentrada_idDocEntrada")
    private int docentradaidDocEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduto")
    private int idProduto;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 5)
    @Column(name = "unidade")
    private String unidade;
    @Column(name = "referencia")
    private int referencia;

    public Viewentradaproduto() {
    }

    public int getIdEntradaProduto() {
        return idEntradaProduto;
    }

    public void setIdEntradaProduto(int idEntradaProduto) {
        this.idEntradaProduto = idEntradaProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Float getValorTotalCusto() {
        return valorTotalCusto;
    }

    public void setValorTotalCusto(Float valorTotalCusto) {
        this.valorTotalCusto = valorTotalCusto;
    }

    public Double getAliquitaICMS() {
        return aliquitaICMS;
    }

    public void setAliquitaICMS(Double aliquitaICMS) {
        this.aliquitaICMS = aliquitaICMS;
    }

    public Float getValorICMS() {
        return valorICMS;
    }

    public void setValorICMS(Float valorICMS) {
        this.valorICMS = valorICMS;
    }

    public Float getValorIPI() {
        return valorIPI;
    }

    public void setValorIPI(Float valorIPI) {
        this.valorIPI = valorIPI;
    }

    public Float getValorST() {
        return valorST;
    }

    public void setValorST(Float valorST) {
        this.valorST = valorST;
    }

    public Double getQuantiaddeAnterior() {
        return quantiaddeAnterior;
    }

    public void setQuantiaddeAnterior(Double quantiaddeAnterior) {
        this.quantiaddeAnterior = quantiaddeAnterior;
    }

    public Double getQuantdadeAtual() {
        return quantdadeAtual;
    }

    public void setQuantdadeAtual(Double quantdadeAtual) {
        this.quantdadeAtual = quantdadeAtual;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getDocentradaidDocEntrada() {
        return docentradaidDocEntrada;
    }

    public void setDocentradaidDocEntrada(int docentradaidDocEntrada) {
        this.docentradaidDocEntrada = docentradaidDocEntrada;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
}
