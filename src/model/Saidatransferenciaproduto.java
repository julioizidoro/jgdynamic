/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "saidatransferenciaproduto")
public class Saidatransferenciaproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsaidaTransferenciaProduto")
    private Integer idsaidaTransferenciaProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorUnitario")
    private Double valorUnitario;
    @Column(name = "valorTotal")
    private Double valorTotal;
    @Column(name = "saidaTransferencia_idsaidaTransferencia")
    private int saidaTransferencia;
    @Column(name = "produto_idProduto")
    private int produto;

    public Saidatransferenciaproduto() {
    }

    public Saidatransferenciaproduto(Integer idsaidaTransferenciaProduto) {
        this.idsaidaTransferenciaProduto = idsaidaTransferenciaProduto;
    }

    public Integer getIdsaidaTransferenciaProduto() {
        return idsaidaTransferenciaProduto;
    }

    public void setIdsaidaTransferenciaProduto(Integer idsaidaTransferenciaProduto) {
        this.idsaidaTransferenciaProduto = idsaidaTransferenciaProduto;
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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getSaidaTransferencia() {
        return saidaTransferencia;
    }

    public void setSaidaTransferencia(int saidaTransferencia) {
        this.saidaTransferencia = saidaTransferencia;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsaidaTransferenciaProduto != null ? idsaidaTransferenciaProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saidatransferenciaproduto)) {
            return false;
        }
        Saidatransferenciaproduto other = (Saidatransferenciaproduto) object;
        if ((this.idsaidaTransferenciaProduto == null && other.idsaidaTransferenciaProduto != null) || (this.idsaidaTransferenciaProduto != null && !this.idsaidaTransferenciaProduto.equals(other.idsaidaTransferenciaProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Saidatransferenciaproduto[ idsaidaTransferenciaProduto=" + idsaidaTransferenciaProduto + " ]";
    }
    
}
