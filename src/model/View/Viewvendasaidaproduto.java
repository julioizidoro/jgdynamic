/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.View;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "viewvendasaidaproduto")
public class Viewvendasaidaproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idvenda")
    @Id
    private int idvenda;
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Basic(optional = false)
    @Column(name = "numeroECF")
    private String numeroECF;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorVenda")
    private Float valorVenda;
    @Column(name = "valorDesconto")
    private Float valorDesconto;
    @Column(name = "valorImpostofederal")
    private Double valorImpostofederal;
    @Column(name = "valorimpostoestadual")
    private Double valorimpostoestadual;
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "aliquota_idaliquota")
    private int aliquotaIdaliquota;
    @Column(name = "unidade")
    private String unidade;
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "referencia")
    private Integer referencia;
    @Basic(optional = false)
    @Column(name = "idproduto")
    private int idproduto;
    @Basic(optional = false)
    @Column(name = "idsaida")
    private int idsaida;

    public Viewvendasaidaproduto() {
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNumeroECF() {
        return numeroECF;
    }

    public void setNumeroECF(String numeroECF) {
        this.numeroECF = numeroECF;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getValorImpostofederal() {
        return valorImpostofederal;
    }

    public void setValorImpostofederal(Double valorImpostofederal) {
        this.valorImpostofederal = valorImpostofederal;
    }

    public Double getValorimpostoestadual() {
        return valorimpostoestadual;
    }

    public void setValorimpostoestadual(Double valorimpostoestadual) {
        this.valorimpostoestadual = valorimpostoestadual;
    }

    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAliquotaIdaliquota() {
        return aliquotaIdaliquota;
    }

    public void setAliquotaIdaliquota(int aliquotaIdaliquota) {
        this.aliquotaIdaliquota = aliquotaIdaliquota;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public int getIdsaida() {
        return idsaida;
    }

    public void setIdsaida(int idsaida) {
        this.idsaida = idsaida;
    }
    
}
