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
@Table(name = "chequefechacaixa")
public class ChequeFechaCaixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchequeFechaCaixa")
    private Integer idchequeFechaCaixa;
    @Column(name = "fechacaixa_idfechaCaixa")
    private int fechacaixa;
    @Column(name = "controlecheques_idcontroleCheques")
    private int controlecheques;

    public ChequeFechaCaixa() {
    }

    public ChequeFechaCaixa(Integer idchequeFechaCaixa) {
        this.idchequeFechaCaixa = idchequeFechaCaixa;
    }

    public Integer getIdchequeFechaCaixa() {
        return idchequeFechaCaixa;
    }

    public void setIdchequeFechaCaixa(Integer idchequeFechaCaixa) {
        this.idchequeFechaCaixa = idchequeFechaCaixa;
    }

    public int getFechacaixa() {
        return fechacaixa;
    }

    public void setFechacaixa(int fechacaixa) {
        this.fechacaixa = fechacaixa;
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
        hash += (idchequeFechaCaixa != null ? idchequeFechaCaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChequeFechaCaixa)) {
            return false;
        }
        ChequeFechaCaixa other = (ChequeFechaCaixa) object;
        if ((this.idchequeFechaCaixa == null && other.idchequeFechaCaixa != null) || (this.idchequeFechaCaixa != null && !this.idchequeFechaCaixa.equals(other.idchequeFechaCaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ChequeFechaCaixa[ idchequeFechaCaixa=" + idchequeFechaCaixa + " ]";
    }
    
}
