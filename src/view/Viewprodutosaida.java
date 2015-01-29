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
 * @author Wolverine
 */
@Entity
@Table(name = "viewprodutosaida")
@NamedQueries({
    @NamedQuery(name = "Viewprodutosaida.findAll", query = "SELECT v FROM Viewprodutosaida v")})
public class Viewprodutosaida implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorVenda")
    private Float valorVenda;
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorCompra")
    private Float valorCompra;
    @Basic(optional = false)
    @Column(name = "produto_idproduto")
    private int produtoIdproduto;
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Basic(optional = false)
    @Column(name = "idSaida")
    @Id
    private int idSaida;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Viewprodutosaida() {
    }

    public Float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getProdutoIdproduto() {
        return produtoIdproduto;
    }

    public void setProdutoIdproduto(int produtoIdproduto) {
        this.produtoIdproduto = produtoIdproduto;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdSaida() {
        return idSaida;
    }

    public void setIdSaida(int idSaida) {
        this.idSaida = idSaida;
    }

    
}
