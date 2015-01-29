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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "custoProduto")
public class CustoProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcustoProduto")
    private Integer idcustoProduto;
    @Column(name = "valorST")
    private double valorST;
    @Column(name = "produto_idProduto")
    private int produto;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public CustoProduto() {
    }

    public CustoProduto(Integer idcustoProduto) {
        this.idcustoProduto = idcustoProduto;
    }

    public Integer getIdcustoProduto() {
        return idcustoProduto;
    }

    public void setIdcustoProduto(Integer idcustoProduto) {
        this.idcustoProduto = idcustoProduto;
    }

    public double getValorST() {
        return valorST;
    }

    public void setValorST(double valorST) {
        this.valorST = valorST;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcustoProduto != null ? idcustoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustoProduto)) {
            return false;
        }
        CustoProduto other = (CustoProduto) object;
        if ((this.idcustoProduto == null && other.idcustoProduto != null) || (this.idcustoProduto != null && !this.idcustoProduto.equals(other.idcustoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CustoProduto[ idcustoProduto=" + idcustoProduto + " ]";
    }
    
}
