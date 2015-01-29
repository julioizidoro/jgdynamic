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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "grupoconta")
public class Grupoconta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupoConta")
    private Integer idgrupoConta;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "numeroConta")
    private String numeroConta;
    @Column(name = "numeroSubGrupo")
    private Integer numeroSubGrupo;

    public Grupoconta() {
    }

    public Grupoconta(Integer idgrupoConta) {
        this.idgrupoConta = idgrupoConta;
    }

    public Integer getIdgrupoConta() {
        return idgrupoConta;
    }

    public void setIdgrupoConta(Integer idgrupoConta) {
        this.idgrupoConta = idgrupoConta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Integer getNumeroSubGrupo() {
        return numeroSubGrupo;
    }

    public void setNumeroSubGrupo(Integer numeroSubGrupo) {
        this.numeroSubGrupo = numeroSubGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupoConta != null ? idgrupoConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoconta)) {
            return false;
        }
        Grupoconta other = (Grupoconta) object;
        if ((this.idgrupoConta == null && other.idgrupoConta != null) || (this.idgrupoConta != null && !this.idgrupoConta.equals(other.idgrupoConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Grupoconta[ idgrupoConta=" + idgrupoConta + " ]";
    }

    
}
