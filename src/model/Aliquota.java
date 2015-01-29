/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "aliquota")
public class Aliquota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaliquota")
    private Integer idaliquota;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;

    public Aliquota() {
    }

    public Aliquota(Integer idaliquota) {
        this.idaliquota = idaliquota;
    }

    public Integer getIdaliquota() {
        return idaliquota;
    }

    public void setIdaliquota(Integer idaliquota) {
        this.idaliquota = idaliquota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaliquota != null ? idaliquota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aliquota)) {
            return false;
        }
        Aliquota other = (Aliquota) object;
        if ((this.idaliquota == null && other.idaliquota != null) || (this.idaliquota != null && !this.idaliquota.equals(other.idaliquota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getDescricao();
    }

    
}
