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
@Table(name = "chequeMovCaixa")
public class ChequeMovCaixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchequeMovCaixa")
    private Integer idchequeMovCaixa;
    @Column(name = "movimentocaixa_idmovimentoCaixa")
    private int movimentocaixa;
    @Column(name = "controlecheques_idcontroleCheques")
    private int controlecheques;

    public ChequeMovCaixa() {
    }

    public ChequeMovCaixa(Integer idchequeMovCaixa) {
        this.idchequeMovCaixa = idchequeMovCaixa;
    }

    public Integer getIdchequeMovCaixa() {
        return idchequeMovCaixa;
    }

    public void setIdchequeMovCaixa(Integer idchequeMovCaixa) {
        this.idchequeMovCaixa = idchequeMovCaixa;
    }

    public int getMovimentocaixa() {
        return movimentocaixa;
    }

    public void setMovimentocaixa(int movimentocaixa) {
        this.movimentocaixa = movimentocaixa;
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
        hash += (idchequeMovCaixa != null ? idchequeMovCaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChequeMovCaixa)) {
            return false;
        }
        ChequeMovCaixa other = (ChequeMovCaixa) object;
        if ((this.idchequeMovCaixa == null && other.idchequeMovCaixa != null) || (this.idchequeMovCaixa != null && !this.idchequeMovCaixa.equals(other.idchequeMovCaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ChequeMovCaixa[ idchequeMovCaixa=" + idchequeMovCaixa + " ]";
    }
    
}
