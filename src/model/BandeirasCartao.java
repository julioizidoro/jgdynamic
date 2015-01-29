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
@Table(name = "bandeirasCartao")
public class BandeirasCartao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbandeirasCartao")
    private Integer idbandeirasCartao;
    @Column(name = "nome")
    private String nome;

    public BandeirasCartao() {
    }

    public BandeirasCartao(Integer idbandeirasCartao) {
        this.idbandeirasCartao = idbandeirasCartao;
    }

    public Integer getIdbandeirasCartao() {
        return idbandeirasCartao;
    }

    public void setIdbandeirasCartao(Integer idbandeirasCartao) {
        this.idbandeirasCartao = idbandeirasCartao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbandeirasCartao != null ? idbandeirasCartao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BandeirasCartao)) {
            return false;
        }
        BandeirasCartao other = (BandeirasCartao) object;
        if ((this.idbandeirasCartao == null && other.idbandeirasCartao != null) || (this.idbandeirasCartao != null && !this.idbandeirasCartao.equals(other.idbandeirasCartao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
