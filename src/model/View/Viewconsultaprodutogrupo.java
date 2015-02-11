/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.View;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "viewconsultaprodutogrupo")
public class Viewconsultaprodutogrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduto")
    @Id
    private int idProduto;
    @Column(name = "referencia")
    private Integer referencia;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 5)
    @Column(name = "unidade")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeEstoque")
    private Double quantidadeEstoque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_idempresa")
    private int empresaIdempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subgrupoproduto_idsubGrupoProduto")
    private int subgrupoprodutoidsubGrupoProduto;

    public Viewconsultaprodutogrupo() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
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

    public int getEmpresaIdempresa() {
        return empresaIdempresa;
    }

    public void setEmpresaIdempresa(int empresaIdempresa) {
        this.empresaIdempresa = empresaIdempresa;
    }

    public int getSubgrupoprodutoidsubGrupoProduto() {
        return subgrupoprodutoidsubGrupoProduto;
    }

    public void setSubgrupoprodutoidsubGrupoProduto(int subgrupoprodutoidsubGrupoProduto) {
        this.subgrupoprodutoidsubGrupoProduto = subgrupoprodutoidsubGrupoProduto;
    }
    
}
