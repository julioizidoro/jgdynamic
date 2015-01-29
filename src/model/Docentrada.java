/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "docentrada")
public class Docentrada implements Serializable {
    @Column(name =     "dataEntrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docentrada")
    private List<Entradaproduto> entradaprodutoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDocEntrada")
    private Integer idDocEntrada;
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Column(name = "condicaoPagamento")
    private String condicaoPagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorEncargos")
    private Float valorEncargos;
    @Column(name = "valorDesconto")
    private Float valorDesconto;
    @Column(name = "valorTotal")
    private Float valorTotal;
    @Basic(optional = false)
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "fornecedor_idfornecedor1")
    private int fornecedor;
    @Column(name = "empresa_idempresa")
    private int empresa;

    
    public Docentrada() {
    }

    public Docentrada(Integer idDocEntrada) {
        this.idDocEntrada = idDocEntrada;
    }

    public Docentrada(Integer idDocEntrada, String situacao) {
        this.idDocEntrada = idDocEntrada;
        this.situacao = situacao;
    }

    public Integer getIdDocEntrada() {
        return idDocEntrada;
    }

    public void setIdDocEntrada(Integer idDocEntrada) {
        this.idDocEntrada = idDocEntrada;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(String condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

    public Float getValorEncargos() {
        return valorEncargos;
    }

    public void setValorEncargos(Float valorEncargos) {
        this.valorEncargos = valorEncargos;
    }

    public Float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocEntrada != null ? idDocEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentrada)) {
            return false;
        }
        Docentrada other = (Docentrada) object;
        if ((this.idDocEntrada == null && other.idDocEntrada != null) || (this.idDocEntrada != null && !this.idDocEntrada.equals(other.idDocEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Docentrada[ idDocEntrada=" + idDocEntrada + " ]";
    }

   

   

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
}
