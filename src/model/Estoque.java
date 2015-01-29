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

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestoque")
    private Integer idestoque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeMinima")
    private Double quantidadeMinima;
    @Column(name = "quantidadeEstoque")
    private Double quantidadeEstoque;
    @Column(name = "quantidadeMaxima")
    private Double quantidadeMaxima;
    @Column(name = "valorVenda")
    private Float valorVenda;
    @Column(name = "percentualVendas")
    private Double percentualVendas;
    @Column(name = "valorCusto")
    private Double valorCusto;
    @Column(name = "valorCompra")
    private Double valorCompra;
    @Column(name = "dataVenda")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVenda;
    @Column(name = "dataCompra")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCompra;
    @Column(name = "dataPedido")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPedido;
    @Column(name = "dataEntrada")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "dataPrevisao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPrevisao;
    @Column(name = "pedido")
    private int pedido;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "produto_idProduto")
    private int produto;
    @Column(name = "valorDesconto")
    private Float valorDesconto;
    
    
    

    public Estoque() {
    }

    public Estoque(Integer idestoque) {
        this.idestoque = idestoque;
    }

    public int getEmpresa() {
        return empresa;
    }

    public Integer getIdestoque() {
        return idestoque;
    }

    public void setIdestoque(Integer idestoque) {
        this.idestoque = idestoque;
    }

    public Double getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Double quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public Double getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(Double quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Double getPercentualVendas() {
        return percentualVendas;
    }

    public void setPercentualVendas(Double percentualVendas) {
        this.percentualVendas = percentualVendas;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestoque != null ? idestoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.idestoque == null && other.idestoque != null) || (this.idestoque != null && !this.idestoque.equals(other.idestoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estoque[ idestoque=" + idestoque + " ]";
    }

    
}
