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
@Table(name = "viewrelatoriodevolucao")
@NamedQueries({
    @NamedQuery(name = "Viewrelatoriodevolucao.findAll", query = "SELECT v FROM Viewrelatoriodevolucao v")})
public class Viewrelatoriodevolucao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "dataDevolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorDevolucao")
    private Float valorDevolucao;
    @Column(name = "numeroItens")
    private Integer numeroItens;
    @Column(name = "condicaoDevolucao")
    private String condicaoDevolucao;
    @Basic(optional = false)
    @Column(name = "idDevolucao")
    @Id
    private int idDevolucao;
    @Basic(optional = false)
    @Column(name = "vendedor_idVendedor")
    private int vendedoridVendedor;
    @Basic(optional = false)
    @Column(name = "idDevolucaoProduto")
    private int idDevolucaoProduto;
    @Column(name = "quantidadeDevolucao")
    private Double quantidadeDevolucao;
    @Column(name = "valorUnitario")
    private Float valorUnitario;
    @Column(name = "valorTotal")
    private Float valorTotal;
    @Basic(optional = false)
    @Column(name = "devolucao_iddevolucao")
    private int devolucaoIddevolucao;
    @Basic(optional = false)
    @Column(name = "produto_idproduto")
    private int produtoIdproduto;
    @Column(name = "referencia")
    private Integer referencia;
    @Basic(optional = false)
    @Column(name = "idproduto")
    private int idproduto;
    @Column(name = "unidade")
    private String unidade;
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "idVendedor")
    private int idVendedor;
    @Column(name = "nome")
    private String nome;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Viewrelatoriodevolucao() {
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Float getValorDevolucao() {
        return valorDevolucao;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public void setValorDevolucao(Float valorDevolucao) {
        this.valorDevolucao = valorDevolucao;
    }

    public Integer getNumeroItens() {
        return numeroItens;
    }

    public void setNumeroItens(Integer numeroItens) {
        this.numeroItens = numeroItens;
    }

    public String getCondicaoDevolucao() {
        return condicaoDevolucao;
    }

    public void setCondicaoDevolucao(String condicaoDevolucao) {
        this.condicaoDevolucao = condicaoDevolucao;
    }

    public int getIdDevolucao() {
        return idDevolucao;
    }

    public void setIdDevolucao(int idDevolucao) {
        this.idDevolucao = idDevolucao;
    }

    public int getVendedoridVendedor() {
        return vendedoridVendedor;
    }

    public void setVendedoridVendedor(int vendedoridVendedor) {
        this.vendedoridVendedor = vendedoridVendedor;
    }

    public int getIdDevolucaoProduto() {
        return idDevolucaoProduto;
    }

    public void setIdDevolucaoProduto(int idDevolucaoProduto) {
        this.idDevolucaoProduto = idDevolucaoProduto;
    }

    public Double getQuantidadeDevolucao() {
        return quantidadeDevolucao;
    }

    public void setQuantidadeDevolucao(Double quantidadeDevolucao) {
        this.quantidadeDevolucao = quantidadeDevolucao;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getDevolucaoIddevolucao() {
        return devolucaoIddevolucao;
    }

    public void setDevolucaoIddevolucao(int devolucaoIddevolucao) {
        this.devolucaoIddevolucao = devolucaoIddevolucao;
    }

    public int getProdutoIdproduto() {
        return produtoIdproduto;
    }

    public void setProdutoIdproduto(int produtoIdproduto) {
        this.produtoIdproduto = produtoIdproduto;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
