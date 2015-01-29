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
@Table(name = "subgrupo")
public class Subgrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubGrupo")
    private Integer idsubGrupo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "numeroConta")
    private String numeroConta;
    @Column(name = "sequenciaConta")
    private Integer sequenciaConta;
    @Column(name = "grupoConta_idgrupoConta")
    private int grupoconta;

    public Subgrupo() {
    }

    public Subgrupo(Integer idsubGrupo) {
        this.idsubGrupo = idsubGrupo;
    }

    public Integer getIdsubGrupo() {
        return idsubGrupo;
    }

    public void setIdsubGrupo(Integer idsubGrupo) {
        this.idsubGrupo = idsubGrupo;
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

    public Integer getSequenciaConta() {
        return sequenciaConta;
    }

    public void setSequenciaConta(Integer sequenciaConta) {
        this.sequenciaConta = sequenciaConta;
    }

    public int getGrupoconta() {
        return grupoconta;
    }

    public void setGrupoconta(int grupoconta) {
        this.grupoconta = grupoconta;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubGrupo != null ? idsubGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subgrupo)) {
            return false;
        }
        Subgrupo other = (Subgrupo) object;
        if ((this.idsubGrupo == null && other.idsubGrupo != null) || (this.idsubGrupo != null && !this.idsubGrupo.equals(other.idsubGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getIdsubGrupo() + " - " + getDescricao();
    }

}
