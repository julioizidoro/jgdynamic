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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "viewvendasaidaproduto")
public class Viewvendasaidaproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvenda")
    @Id
    private int idvenda;
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numeroECF")
    private String numeroECF;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorVenda")
    private Float valorVenda;
    @Column(name = "valorDesconto")
    private Float valorDesconto;
    @Column(name = "valorImposto")
    private Double valorImposto;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aliquota_idaliquota")
    private int aliquotaIdaliquota;
    @Size(max = 5)
    @Column(name = "unidade")
    private String unidade;
    @Size(max = 10)
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "referencia")
    private Integer referencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproduto")
    private int idproduto;
    @Basic(optional = false)
    @NotNull
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

    public Double getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(Double valorImposto) {
        this.valorImposto = valorImposto;
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
