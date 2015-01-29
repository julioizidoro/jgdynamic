/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "formacontaspagar")
public class Formacontaspagar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformaContasPagar")
    private Integer idformaContasPagar;
    @Column(name = "formaPagamento")
    private String formaPagamento;
    @Column(name = "idBanco")
    private Integer idBanco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorPago")
    private Double valorPago;
    @Column(name = "pagamentoContasPagar_idpagamentoContasPagar")
    private int pagamentocontaspagar;

    public Formacontaspagar() {
    }

    public Formacontaspagar(Integer idformaContasPagar) {
        this.idformaContasPagar = idformaContasPagar;
    }

    public Integer getIdformaContasPagar() {
        return idformaContasPagar;
    }

    public void setIdformaContasPagar(Integer idformaContasPagar) {
        this.idformaContasPagar = idformaContasPagar;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public int getPagamentocontaspagar() {
        return pagamentocontaspagar;
    }

    public void setPagamentocontaspagar(int pagamentocontaspagar) {
        this.pagamentocontaspagar = pagamentocontaspagar;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformaContasPagar != null ? idformaContasPagar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formacontaspagar)) {
            return false;
        }
        Formacontaspagar other = (Formacontaspagar) object;
        if ((this.idformaContasPagar == null && other.idformaContasPagar != null) || (this.idformaContasPagar != null && !this.idformaContasPagar.equals(other.idformaContasPagar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Formacontaspagar[ idformaContasPagar=" + idformaContasPagar + " ]";
    }
    
}
