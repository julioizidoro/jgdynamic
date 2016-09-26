/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Julio
 */
@Entity
@Table(name = "contasreceberforma")
public class Contasreceberforma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontasReceberForma")
    private Integer idcontasReceberForma;
    @Column(name = "formaRecebimento")
    private String formaRecebimento;
    @Column(name = "idBanco")
    private Integer idBanco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorPago")
    private Double valorPago;
    @JoinColumn(name = "formapagamento_idformaPagamento", referencedColumnName = "idformaPagamento")
    @ManyToOne(optional = false)
    private Formapagamento formapagamento;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "contasReceberPagamento_idcontasReceberPagamento", referencedColumnName = "idcontasReceberPagamento")
    @ManyToOne(optional = false)
    private Contasreceberpagamento contasreceberpagamento;

    public Contasreceberforma() {
    }

    public Contasreceberforma(Integer idcontasReceberForma) {
        this.idcontasReceberForma = idcontasReceberForma;
    }

    public Integer getIdcontasReceberForma() {
        return idcontasReceberForma;
    }

    public void setIdcontasReceberForma(Integer idcontasReceberForma) {
        this.idcontasReceberForma = idcontasReceberForma;
    }

    public String getFormaRecebimento() {
        return formaRecebimento;
    }

    public void setFormaRecebimento(String formaRecebimento) {
        this.formaRecebimento = formaRecebimento;
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

    public Formapagamento getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(Formapagamento formapagamento) {
        this.formapagamento = formapagamento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Contasreceberpagamento getContasreceberpagamento() {
        return contasreceberpagamento;
    }

    public void setContasreceberpagamento(Contasreceberpagamento contasreceberpagamento) {
        this.contasreceberpagamento = contasreceberpagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontasReceberForma != null ? idcontasReceberForma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contasreceberforma)) {
            return false;
        }
        Contasreceberforma other = (Contasreceberforma) object;
        if ((this.idcontasReceberForma == null && other.idcontasReceberForma != null) || (this.idcontasReceberForma != null && !this.idcontasReceberForma.equals(other.idcontasReceberForma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contasreceberforma[ idcontasReceberForma=" + idcontasReceberForma + " ]";
    }
    
}
