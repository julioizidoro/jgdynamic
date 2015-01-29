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
import javax.persistence.Id;
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
@Table(name = "forproduto")
public class Forproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Integer idProduto;
    @Column(name = "referencia")
    private Integer referencia;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "unidade")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeEstoque")
    private Double quantidadeEstoque;
    @Column(name = "valorVenda")
    private Double valorVenda;
    @Column(name = "quantidadeUltimaVenda")
    private Double quantidadeUltimaVenda;
    @Column(name = "valorCompra")
    private Double valorCompra;
    @Column(name = "dataUltimaCompra")
    @Temporal(TemporalType.DATE)
    private Date dataUltimaCompra;
    @Column(name = "dataChegada")
    @Temporal(TemporalType.DATE)
    private Date dataChegada;
    @Column(name = "embalagem")
    private Double embalagem;
    @Column(name = "codigoFabricante")
    private String codigoFabricante;
    @Column(name = "idVinculo")
    private Integer idVinculo;
    private String pedido;

    public Forproduto() {
    }

    public Forproduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Double getQuantidadeUltimaVenda() {
        return quantidadeUltimaVenda;
    }

    public void setQuantidadeUltimaVenda(Double quantidadeUltimaVenda) {
        this.quantidadeUltimaVenda = quantidadeUltimaVenda;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getDataUltimaCompra() {
        return dataUltimaCompra;
    }

    public void setDataUltimaCompra(Date dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Double getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Double embalagem) {
        this.embalagem = embalagem;
    }

    public String getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(String codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    public Integer getIdVinculo() {
        return idVinculo;
    }

    public void setIdVinculo(Integer idVinculo) {
        this.idVinculo = idVinculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forproduto)) {
            return false;
        }
        Forproduto other = (Forproduto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Forproduto[ idProduto=" + idProduto + " ]";
    }
    
}
