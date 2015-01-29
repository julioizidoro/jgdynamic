/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "viewConsultaProdutoFornecedor")
@NamedQueries({
    @NamedQuery(name = "ViewConsultaProdutoFornecedor.findAll", query = "SELECT v FROM ViewConsultaProdutoFornecedor v")})
public class ViewConsultaProdutoFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idproduto")
    @Id
    private int idproduto;
    @Column(name = "referencia")
    private Integer referencia;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "unidade")
    private String unidade;
    @Basic(optional = false)
    @Column(name = "produto_idproduto")
    private int produtoIdproduto;
    @Basic(optional = false)
    @Column(name = "fornecedor_idfornecedor")
    private int fornecedorIdfornecedor;
    @Basic(optional = false)
    @Column(name = "idfornecedor")
    private int idfornecedor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeEstoque")
    private Double quantidadeEstoque;

    public ViewConsultaProdutoFornecedor() {
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
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

    public int getProdutoIdproduto() {
        return produtoIdproduto;
    }

    public void setProdutoIdproduto(int produtoIdproduto) {
        this.produtoIdproduto = produtoIdproduto;
    }

    public int getFornecedorIdfornecedor() {
        return fornecedorIdfornecedor;
    }

    public void setFornecedorIdfornecedor(int fornecedorIdfornecedor) {
        this.fornecedorIdfornecedor = fornecedorIdfornecedor;
    }

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
}
