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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "controlecartao")
public class Controlecartao implements Serializable {
    @Column(name = "dataPrevista")
    @Temporal(TemporalType.DATE)
    private Date dataPrevista;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontroleCartao")
    private Integer idcontroleCartao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorBruto")
    private Double valorBruto;
    @Column(name = "valorTaxa")
    private Double valorTaxa;
    @Column(name = "valorLiquido")
    private Double valorLiquido;
    @Column(name = "formapagamento_idformaPagamento")
    private int formapagamento;
    @Column(name = "fechacaixa_idfechaCaixa")
    private int fechacaixa;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "banco_idbanco")
    private int banco;

    public Controlecartao() {
    }

    public Controlecartao(Integer idcontroleCartao) {
        this.idcontroleCartao = idcontroleCartao;
    }

    public Integer getIdcontroleCartao() {
        return idcontroleCartao;
    }

    public void setIdcontroleCartao(Integer idcontroleCartao) {
        this.idcontroleCartao = idcontroleCartao;
    }

    public Double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(Double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public Double getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(Double valorTaxa) {
        this.valorTaxa = valorTaxa;
    }

    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getFechacaixa() {
        return fechacaixa;
    }

    public void setFechacaixa(int fechacaixa) {
        this.fechacaixa = fechacaixa;
    }

    public int getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(int formapagamento) {
        this.formapagamento = formapagamento;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontroleCartao != null ? idcontroleCartao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controlecartao)) {
            return false;
        }
        Controlecartao other = (Controlecartao) object;
        if ((this.idcontroleCartao == null && other.idcontroleCartao != null) || (this.idcontroleCartao != null && !this.idcontroleCartao.equals(other.idcontroleCartao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Controlecartao[ idcontroleCartao=" + idcontroleCartao + " ]";
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    
}
