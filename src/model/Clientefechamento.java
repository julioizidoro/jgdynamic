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
 * @author Wolverine
 */
@Entity
@Table(name = "clientefechamento")
@NamedQueries({
    @NamedQuery(name = "Clientefechamento.findAll", query = "SELECT c FROM Clientefechamento c")})
public class Clientefechamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclienteFechamento")
    private Integer idclienteFechamento;
    @Column(name = "tipoFechamento")
    private String tipoFechamento;
    @Column(name = "diaPagamento")
    private Integer diaPagamento;
    @Column(name = "formaPagamento")
    private String formaPagamento;
    @Column(name = "notaFiscal")
    private String notaFiscal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limiteCredito")
    private Double limiteCredito;
    @Basic(optional = false)
    @Column(name = "cliente_idcliente")
    private int clienteIdcliente;

    public Clientefechamento() {
    }

    public Clientefechamento(Integer idclienteFechamento) {
        this.idclienteFechamento = idclienteFechamento;
    }

    public Clientefechamento(Integer idclienteFechamento, int clienteIdcliente) {
        this.idclienteFechamento = idclienteFechamento;
        this.clienteIdcliente = clienteIdcliente;
    }

    public Integer getIdclienteFechamento() {
        return idclienteFechamento;
    }

    public void setIdclienteFechamento(Integer idclienteFechamento) {
        this.idclienteFechamento = idclienteFechamento;
    }

    public String getTipoFechamento() {
        return tipoFechamento;
    }

    public void setTipoFechamento(String tipoFechamento) {
        this.tipoFechamento = tipoFechamento;
    }

    public Integer getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(Integer diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public int getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(int clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclienteFechamento != null ? idclienteFechamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientefechamento)) {
            return false;
        }
        Clientefechamento other = (Clientefechamento) object;
        if ((this.idclienteFechamento == null && other.idclienteFechamento != null) || (this.idclienteFechamento != null && !this.idclienteFechamento.equals(other.idclienteFechamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clientefechamento[ idclienteFechamento=" + idclienteFechamento + " ]";
    }
    
}
