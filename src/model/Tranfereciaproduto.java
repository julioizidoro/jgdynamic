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
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "tranfereciaproduto")
public class Tranfereciaproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtranfereciaProduto")
    private Integer idtranfereciaProduto;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private double quantidade;
    @Basic(optional = false)
    @Column(name = "valorUnitario")
    private Float valorUnitario;
    @Basic(optional = false)
    @Column(name = "valorTotal")
    private Float valorTotal;
    @Column(name = "transferencia_idtransferencia")
    private int transferencia;
    @Column(name = "produto_idProduto")
    private int produto;

    public Tranfereciaproduto() {
    }

    public Tranfereciaproduto(Integer idtranfereciaProduto) {
        this.idtranfereciaProduto = idtranfereciaProduto;
    }

    public Tranfereciaproduto(Integer idtranfereciaProduto, double quantidade, float valorUnitario, float valorTotal) {
        this.idtranfereciaProduto = idtranfereciaProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public Integer getIdtranfereciaProduto() {
        return idtranfereciaProduto;
    }

    public void setIdtranfereciaProduto(Integer idtranfereciaProduto) {
        this.idtranfereciaProduto = idtranfereciaProduto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

   

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(int transferencia) {
        this.transferencia = transferencia;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtranfereciaProduto != null ? idtranfereciaProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tranfereciaproduto)) {
            return false;
        }
        Tranfereciaproduto other = (Tranfereciaproduto) object;
        if ((this.idtranfereciaProduto == null && other.idtranfereciaProduto != null) || (this.idtranfereciaProduto != null && !this.idtranfereciaProduto.equals(other.idtranfereciaProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tranfereciaproduto[ idtranfereciaProduto=" + idtranfereciaProduto + " ]";
    }
    
}
