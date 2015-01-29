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
@Table(name = "fechamentoCliente")
public class FechamentoCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfechamentoCliente")
    private Integer idfechamentoCliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorConta")
    private Float valorConta;
    @Column(name = "diasAtraso")
    private Integer diasAtraso;
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "valorCredito")
    private Float valorCredito;
    @Column(name = "valorPagar")
    private Float valorPagar;
    @Column(name = "fechamentoMes_idfechamentoMes")
    private int fechamentoMes;
    @Column(name = "cliente_idcliente")
    private int cliente;

    public FechamentoCliente() {
    }

    public FechamentoCliente(Integer idfechamentoCliente) {
        this.idfechamentoCliente = idfechamentoCliente;
    }

    public Integer getIdfechamentoCliente() {
        return idfechamentoCliente;
    }

    public void setIdfechamentoCliente(Integer idfechamentoCliente) {
        this.idfechamentoCliente = idfechamentoCliente;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }


    public Integer getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(Integer diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Float getValorConta() {
        return valorConta;
    }

    public void setValorConta(Float valorConta) {
        this.valorConta = valorConta;
    }

    public Float getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(Float valorCredito) {
        this.valorCredito = valorCredito;
    }

    public Float getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(Float valorPagar) {
        this.valorPagar = valorPagar;
    }


    public int getFechamentoMes() {
        return fechamentoMes;
    }

    public void setFechamentoMes(int fechamentoMes) {
        this.fechamentoMes = fechamentoMes;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfechamentoCliente != null ? idfechamentoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechamentoCliente)) {
            return false;
        }
        FechamentoCliente other = (FechamentoCliente) object;
        if ((this.idfechamentoCliente == null && other.idfechamentoCliente != null) || (this.idfechamentoCliente != null && !this.idfechamentoCliente.equals(other.idfechamentoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FechamentoCliente[ idfechamentoCliente=" + idfechamentoCliente + " ]";
    }
    
}
