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
@Table(name = "pagamentocontaspagar")
public class Pagamentocontaspagar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpagamentoContasPagar")
    private Integer idpagamentoContasPagar;
    @Column(name = "dataPagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "juros")
    private Double juros;
    @Column(name = "descontos")
    private Double descontos;
    @Column(name = "valorPago")
    private Double valorPago;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Pagamentocontaspagar() {
    }

    public Pagamentocontaspagar(Integer idpagamentoContasPagar) {
        this.idpagamentoContasPagar = idpagamentoContasPagar;
    }

    public Integer getIdpagamentoContasPagar() {
        return idpagamentoContasPagar;
    }

    public void setIdpagamentoContasPagar(Integer idpagamentoContasPagar) {
        this.idpagamentoContasPagar = idpagamentoContasPagar;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getJuros() {
        return juros;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getDescontos() {
        return descontos;
    }

    public void setDescontos(Double descontos) {
        this.descontos = descontos;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpagamentoContasPagar != null ? idpagamentoContasPagar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamentocontaspagar)) {
            return false;
        }
        Pagamentocontaspagar other = (Pagamentocontaspagar) object;
        if ((this.idpagamentoContasPagar == null && other.idpagamentoContasPagar != null) || (this.idpagamentoContasPagar != null && !this.idpagamentoContasPagar.equals(other.idpagamentoContasPagar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pagamentocontaspagar[ idpagamentoContasPagar=" + idpagamentoContasPagar + " ]";
    }
    
}
