/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
 * @author wolverine
 */
@Entity
@Table(name = "viewconsultaprodutoestoque")
@NamedQueries({
    @NamedQuery(name = "Viewconsultaprodutoestoque.findAll", query = "SELECT v FROM Viewconsultaprodutoestoque v")})
public class Viewconsultaprodutoestoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idProduto")
    @Id
    private int idProduto;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "unidade")
    private String unidade;
    @Column(name = "referencia")
    private Integer referencia;
    @Column(name = "codigonovo")
    private Integer codigonovo;
    @Column(name = "codigoBarras")
    private String codigoBarras;
    @Column(name = "precoFixo")
    private Integer precoFixo;
    @Basic(optional = false)
    @Column(name = "subgrupoproduto_idsubGrupoProduto")
    private int subgrupoprodutoidsubGrupoProduto;
    @Basic(optional = false)
    @Column(name = "idEstoque")
    private int idEstoque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeMinima")
    private Double quantidadeMinima;
    @Column(name = "quantidadeEstoque")
    private Double quantidadeEstoque;
    @Column(name = "valorVenda")
    private Float valorVenda;
    @Column(name = "valorCusto")
    private Double valorCusto;
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Column(name = "dataCompra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Column(name = "dataEntrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "dataPedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @Column(name = "dataPrevisao")
    @Temporal(TemporalType.DATE)
    private Date dataPrevisao;
    @Column(name = "pedido")
    private Integer pedido;
    @Column(name = "empresa")
    private Integer empresa;

    public Viewconsultaprodutoestoque() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getCodigonovo() {
        return codigonovo;
    }

    public void setCodigonovo(Integer codigonovo) {
        this.codigonovo = codigonovo;
    }

    public Integer getPrecoFixo() {
        return precoFixo;
    }

    public void setPrecoFixo(Integer precoFixo) {
        this.precoFixo = precoFixo;
    }

    public int getSubgrupoprodutoidsubGrupoProduto() {
        return subgrupoprodutoidsubGrupoProduto;
    }

    public void setSubgrupoprodutoidsubGrupoProduto(int subgrupoprodutoidsubGrupoProduto) {
        this.subgrupoprodutoidsubGrupoProduto = subgrupoprodutoidsubGrupoProduto;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Double getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Double quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
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

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
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

    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }
    
}
