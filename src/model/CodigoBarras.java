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
@Table(name = "codigoBarras")
public class CodigoBarras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcodigoBarras")
    private Integer idcodigoBarras;
    @Column(name = "barras")
    private String barras;
    @Column(name = "produto_idproduto")
    private int produto;

    public CodigoBarras() {
    }

    public CodigoBarras(Integer idcodigoBarras) {
        this.idcodigoBarras = idcodigoBarras;
    }

    public Integer getIdcodigoBarras() {
        return idcodigoBarras;
    }

    public void setIdcodigoBarras(Integer idcodigoBarras) {
        this.idcodigoBarras = idcodigoBarras;
    }

    public String getBarras() {
        return barras;
    }

    public void setBarras(String barras) {
        this.barras = barras;
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
        hash += (idcodigoBarras != null ? idcodigoBarras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoBarras)) {
            return false;
        }
        CodigoBarras other = (CodigoBarras) object;
        if ((this.idcodigoBarras == null && other.idcodigoBarras != null) || (this.idcodigoBarras != null && !this.idcodigoBarras.equals(other.idcodigoBarras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getBarras();
    }
    
}
