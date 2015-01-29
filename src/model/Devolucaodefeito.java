/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "devolucaodefeito")
public class Devolucaodefeito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddevolucaoDefeito")
    private Integer iddevolucaoDefeito;
    @Column(name = "dataCompra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Column(name = "dataDevolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @Lob
    @Column(name = "descricaoDefeito")
    private String descricaoDefeito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorProduto")
    private Float valorProduto;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "produto_idProduto")
    private int produto;
    @Column(name = "vendedor_idvendedor")
    private int vendedor;
    @Column(name = "fornecedor_idfornecedor")
    private int fornecedor;
    @Column(name = "devolucaoEnviada")
    private String devolucaoEnviada;
    @Column(name = "dataEnvio")
    @Temporal(TemporalType.DATE)
    private Date dataEnvio;
    @Column(name = "numeroEnvio")
    private int numeroEnvio;
    
    

    public Devolucaodefeito() {
    }

    public Devolucaodefeito(Integer iddevolucaoDefeito) {
        this.iddevolucaoDefeito = iddevolucaoDefeito;
    }

    public Integer getIddevolucaoDefeito() {
        return iddevolucaoDefeito;
    }

    public void setIddevolucaoDefeito(Integer iddevolucaoDefeito) {
        this.iddevolucaoDefeito = iddevolucaoDefeito;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getNumeroEnvio() {
        return numeroEnvio;
    }

    public void setNumeroEnvio(int numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getDescricaoDefeito() {
        return descricaoDefeito;
    }

    public void setDescricaoDefeito(String descricaoDefeito) {
        this.descricaoDefeito = descricaoDefeito;
    }

    public Float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDevolucaoEnviada() {
        return devolucaoEnviada;
    }

    public void setDevolucaoEnviada(String devolucaoEnviada) {
        this.devolucaoEnviada = devolucaoEnviada;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddevolucaoDefeito != null ? iddevolucaoDefeito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucaodefeito)) {
            return false;
        }
        Devolucaodefeito other = (Devolucaodefeito) object;
        if ((this.iddevolucaoDefeito == null && other.iddevolucaoDefeito != null) || (this.iddevolucaoDefeito != null && !this.iddevolucaoDefeito.equals(other.iddevolucaoDefeito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Devolucaodefeito[ iddevolucaoDefeito=" + iddevolucaoDefeito + " ]";
    }
    
}
