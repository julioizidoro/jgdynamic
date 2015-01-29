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
 * @author wolverine
 */
@Entity
@Table(name = "chequeMovBanco")
public class ChequeMovBanco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchequeMovBanco")
    private Integer idchequeMovBanco;
    @Column(name = "movimentobanco_idmovimentoBanco")
    private int movimentobanco;
    @Column(name = "controlecheques_idcontroleCheques")
    private int controlecheques;

    public ChequeMovBanco() {
    }

    public ChequeMovBanco(Integer idchequeMovBanco) {
        this.idchequeMovBanco = idchequeMovBanco;
    }

    public Integer getIdchequeMovBanco() {
        return idchequeMovBanco;
    }

    public void setIdchequeMovBanco(Integer idchequeMovBanco) {
        this.idchequeMovBanco = idchequeMovBanco;
    }

    public int getMovimentobanco() {
        return movimentobanco;
    }

    public void setMovimentobanco(int movimentobanco) {
        this.movimentobanco = movimentobanco;
    }

    public int getControlecheques() {
        return controlecheques;
    }

    public void setControlecheques(int controlecheques) {
        this.controlecheques = controlecheques;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchequeMovBanco != null ? idchequeMovBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChequeMovBanco)) {
            return false;
        }
        ChequeMovBanco other = (ChequeMovBanco) object;
        if ((this.idchequeMovBanco == null && other.idchequeMovBanco != null) || (this.idchequeMovBanco != null && !this.idchequeMovBanco.equals(other.idchequeMovBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ChequeMovBanco[ idchequeMovBanco=" + idchequeMovBanco + " ]";
    }
    
}
