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
@Table(name = "ibpt")
public class Ibpt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idibpt")
    private Integer idibpt;
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "aliquotaNacional")
    private Double aliquotaNacional;
    @Column(name = "aliquotaImposto")
    private Double aliquotaImposto;

    public Ibpt() {
    }

    public Ibpt(Integer idibpt) {
        this.idibpt = idibpt;
    }

    public Integer getIdibpt() {
        return idibpt;
    }

    public void setIdibpt(Integer idibpt) {
        this.idibpt = idibpt;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getAliquotaNacional() {
        return aliquotaNacional;
    }

    public void setAliquotaNacional(Double aliquotaNacional) {
        this.aliquotaNacional = aliquotaNacional;
    }

    public Double getAliquotaImposto() {
        return aliquotaImposto;
    }

    public void setAliquotaImposto(Double aliquotaImposto) {
        this.aliquotaImposto = aliquotaImposto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idibpt != null ? idibpt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ibpt)) {
            return false;
        }
        Ibpt other = (Ibpt) object;
        if ((this.idibpt == null && other.idibpt != null) || (this.idibpt != null && !this.idibpt.equals(other.idibpt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ibpt[ idibpt=" + idibpt + " ]";
    }
    
}
