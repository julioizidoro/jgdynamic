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
@Table(name = "configuracao")
public class Configuracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconfiguracao")
    private Integer idconfiguracao;
    @Column(name = "contafornecedor")
    private Integer contafornecedor;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "formapagamento_idformapagamento")
    private int formaPagamento;

    public Configuracao() {
    }

    public Configuracao(Integer idconfiguracao) {
        this.idconfiguracao = idconfiguracao;
    }

    public Integer getIdconfiguracao() {
        return idconfiguracao;
    }

    public void setIdconfiguracao(Integer idconfiguracao) {
        this.idconfiguracao = idconfiguracao;
    }

    public Integer getContafornecedor() {
        return contafornecedor;
    }

    public void setContafornecedor(Integer contafornecedor) {
        this.contafornecedor = contafornecedor;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconfiguracao != null ? idconfiguracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracao)) {
            return false;
        }
        Configuracao other = (Configuracao) object;
        if ((this.idconfiguracao == null && other.idconfiguracao != null) || (this.idconfiguracao != null && !this.idconfiguracao.equals(other.idconfiguracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Configuracao[ idconfiguracao=" + idconfiguracao + " ]";
    }
    
}
