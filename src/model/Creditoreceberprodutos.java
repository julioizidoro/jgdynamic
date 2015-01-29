/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "creditoreceberprodutos")
public class Creditoreceberprodutos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcreditoReceberProdutos")
    private Integer idcreditoReceberProdutos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorUnitario")
    private Double valorUnitario;
    @Column(name = "produto_idProduto")
    private int produto;
    @Column(name = "creditosReceber_idcreditosReceber")
    private int creditosreceber;

    public Creditoreceberprodutos() {
    }

    public Creditoreceberprodutos(Integer idcreditoReceberProdutos) {
        this.idcreditoReceberProdutos = idcreditoReceberProdutos;
    }

    public Integer getIdcreditoReceberProdutos() {
        return idcreditoReceberProdutos;
    }

    public void setIdcreditoReceberProdutos(Integer idcreditoReceberProdutos) {
        this.idcreditoReceberProdutos = idcreditoReceberProdutos;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCreditosreceber() {
        return creditosreceber;
    }

    public void setCreditosreceber(int creditosreceber) {
        this.creditosreceber = creditosreceber;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcreditoReceberProdutos != null ? idcreditoReceberProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditoreceberprodutos)) {
            return false;
        }
        Creditoreceberprodutos other = (Creditoreceberprodutos) object;
        if ((this.idcreditoReceberProdutos == null && other.idcreditoReceberProdutos != null) || (this.idcreditoReceberProdutos != null && !this.idcreditoReceberProdutos.equals(other.idcreditoReceberProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Creditoreceberprodutos[ idcreditoReceberProdutos=" + idcreditoReceberProdutos + " ]";
    }
    
}
