/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Julio
 */
@Entity
@Table(name = "contasreceberpagamento")
public class Contasreceberpagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontasReceberPagamento")
    private Integer idcontasReceberPagamento;
    @Column(name = "dataPagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "juros")
    private Double juros;
    @Column(name = "desconto")
    private Double desconto;
    @Column(name = "valorRecebido")
    private Double valorRecebido;
    @Column(name = "fechacaixa_idfechaCaixa")
    private int fechaCaixa;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "cliente_idcliente")
    private int cliente;

    public Contasreceberpagamento() {
    }

    public Contasreceberpagamento(Integer idcontasReceberPagamento) {
        this.idcontasReceberPagamento = idcontasReceberPagamento;
    }

    public Integer getIdcontasReceberPagamento() {
        return idcontasReceberPagamento;
    }

    public void setIdcontasReceberPagamento(Integer idcontasReceberPagamento) {
        this.idcontasReceberPagamento = idcontasReceberPagamento;
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

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(Double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public int getFechacaixa() {
        return fechaCaixa;
    }

    public void setFechacaixa(int fechacaixa) {
        this.fechaCaixa = fechacaixa;
    }

    public int getFechaCaixa() {
        return fechaCaixa;
    }

    public void setFechaCaixa(int fechaCaixa) {
        this.fechaCaixa = fechaCaixa;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

   

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontasReceberPagamento != null ? idcontasReceberPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contasreceberpagamento)) {
            return false;
        }
        Contasreceberpagamento other = (Contasreceberpagamento) object;
        if ((this.idcontasReceberPagamento == null && other.idcontasReceberPagamento != null) || (this.idcontasReceberPagamento != null && !this.idcontasReceberPagamento.equals(other.idcontasReceberPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contasreceberpagamento[ idcontasReceberPagamento=" + idcontasReceberPagamento + " ]";
    }
    
}
