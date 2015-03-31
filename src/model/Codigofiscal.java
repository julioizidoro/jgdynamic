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
@Table(name = "CodigoFiscal")
@NamedQueries({
    @NamedQuery(name = "Codigofiscal.findAll", query = "SELECT c FROM Codigofiscal c")})
public class Codigofiscal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcodigoFiscal")
    private Integer idcodigoFiscal;
    @Column(name = "cfop")
    private String cfop;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "tipoemissao")
    private String tipoemissao;
    @Column(name = "estadopadrao")
    private String estadopadrao;
    
    
            

    public Codigofiscal() {
    }

    public Codigofiscal(Integer idcodigoFiscal) {
        this.idcodigoFiscal = idcodigoFiscal;
    }

    public Integer getIdcodigoFiscal() {
        return idcodigoFiscal;
    }

    public void setIdcodigoFiscal(Integer idcodigoFiscal) {
        this.idcodigoFiscal = idcodigoFiscal;
    }

    public String getTipoemissao() {
        return tipoemissao;
    }

    public void setTipoemissao(String tipoemissao) {
        this.tipoemissao = tipoemissao;
    }

    public String getEstadopadrao() {
        return estadopadrao;
    }

    public void setEstadopadrao(String estadopadrao) {
        this.estadopadrao = estadopadrao;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcodigoFiscal != null ? idcodigoFiscal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codigofiscal)) {
            return false;
        }
        Codigofiscal other = (Codigofiscal) object;
        if ((this.idcodigoFiscal == null && other.idcodigoFiscal != null) || (this.idcodigoFiscal != null && !this.idcodigoFiscal.equals(other.idcodigoFiscal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String desc = getDescricao();
        if (desc.length()>130){
            return getCfop() + " - " + getDescricao().substring(0, 130);
        }else return getCfop() + " - " + getDescricao();
        
    }
    
}
