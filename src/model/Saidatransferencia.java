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
 * @author Wolverine
 */
@Entity
@Table(name = "saidatransferencia")
public class Saidatransferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsaidaTransferencia")
    private Integer idsaidaTransferencia;
    @Column(name = "dataTransferencia")
    @Temporal(TemporalType.DATE)
    private Date dataTransferencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorTotal")
    private Double valorTotal;
    @Column(name = "empresa_detinatario")
    private int empresaDetinatario;
    @Column(name = "empresa_emitente")
    private int empresaEmitente;
    
    public Saidatransferencia() {
    }

    public Saidatransferencia(Integer idsaidaTransferencia) {
        this.idsaidaTransferencia = idsaidaTransferencia;
    }

    public Integer getIdsaidaTransferencia() {
        return idsaidaTransferencia;
    }

    public void setIdsaidaTransferencia(Integer idsaidaTransferencia) {
        this.idsaidaTransferencia = idsaidaTransferencia;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getEmpresaDetinatario() {
        return empresaDetinatario;
    }

    public void setEmpresaDetinatario(int empresaDetinatario) {
        this.empresaDetinatario = empresaDetinatario;
    }

    public int getEmpresaEmitente() {
        return empresaEmitente;
    }

    public void setEmpresaEmitente(int empresaEmitente) {
        this.empresaEmitente = empresaEmitente;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsaidaTransferencia != null ? idsaidaTransferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saidatransferencia)) {
            return false;
        }
        Saidatransferencia other = (Saidatransferencia) object;
        if ((this.idsaidaTransferencia == null && other.idsaidaTransferencia != null) || (this.idsaidaTransferencia != null && !this.idsaidaTransferencia.equals(other.idsaidaTransferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Saidatransferencia[ idsaidaTransferencia=" + idsaidaTransferencia + " ]";
    }
    
}
