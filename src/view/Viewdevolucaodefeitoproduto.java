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
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "viewdevolucaodefeitoproduto")
public class Viewdevolucaodefeitoproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "iddevolucaodefeito")
    @Id
    private int iddevolucaodefeito;
    @Column(name = "dataCompra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Column(name = "dataDevolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @Basic(optional = false)
    @Column(name = "fornecedor_idfornecedor")
    private int fornecedorIdfornecedor;
    @Basic(optional = false)
    @Column(name = "produto_idproduto")
    private int produtoIdproduto;
    @Basic(optional = false)
    @Column(name = "empresa_idempresa")
    private int empresaIdempresa;
    @Lob
    @Column(name = "descricaoDefeito")
    private String descricaoDefeito;
    @Column(name = "numeroEnvio")
    private Integer numeroEnvio;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorProduto")
    private Float valorProduto;
    @Column(name = "nome")
    private String nome;
    @Column(name = "referencia")
    private Integer referencia;

    public Viewdevolucaodefeitoproduto() {
    }

    public int getIddevolucaodefeito() {
        return iddevolucaodefeito;
    }

    public void setIddevolucaodefeito(int iddevolucaodefeito) {
        this.iddevolucaodefeito = iddevolucaodefeito;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getFornecedorIdfornecedor() {
        return fornecedorIdfornecedor;
    }

    public void setFornecedorIdfornecedor(int fornecedorIdfornecedor) {
        this.fornecedorIdfornecedor = fornecedorIdfornecedor;
    }

    public int getProdutoIdproduto() {
        return produtoIdproduto;
    }

    public void setProdutoIdproduto(int produtoIdproduto) {
        this.produtoIdproduto = produtoIdproduto;
    }

    public int getEmpresaIdempresa() {
        return empresaIdempresa;
    }

    public void setEmpresaIdempresa(int empresaIdempresa) {
        this.empresaIdempresa = empresaIdempresa;
    }

    public String getDescricaoDefeito() {
        return descricaoDefeito;
    }

    public void setDescricaoDefeito(String descricaoDefeito) {
        this.descricaoDefeito = descricaoDefeito;
    }

    public Integer getNumeroEnvio() {
        return numeroEnvio;
    }

    public void setNumeroEnvio(Integer numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }
    
}
