/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "fechamentoMes")
public class FechamentoMes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfechamentoMes")
    private Integer idfechamentoMes;
    @Column(name = "mes")
    private String mes;
    @Column(name = "dataGeracao")
    @Temporal(TemporalType.DATE)
    private Date dataGeracao;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "empresa_idempresa")
    private int empresa;
    

    public FechamentoMes() {
    }

    public FechamentoMes(Integer idfechamentoMes) {
        this.idfechamentoMes = idfechamentoMes;
    }

    public Integer getIdfechamentoMes() {
        return idfechamentoMes;
    }

    public void setIdfechamentoMes(Integer idfechamentoMes) {
        this.idfechamentoMes = idfechamentoMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfechamentoMes != null ? idfechamentoMes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechamentoMes)) {
            return false;
        }
        FechamentoMes other = (FechamentoMes) object;
        if ((this.idfechamentoMes == null && other.idfechamentoMes != null) || (this.idfechamentoMes != null && !this.idfechamentoMes.equals(other.idfechamentoMes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FechamentoMes[ idfechamentoMes=" + idfechamentoMes + " ]";
    }
    
}
