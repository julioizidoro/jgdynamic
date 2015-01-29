/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "entradaproduto")
public class Entradaproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEntradaProduto")
    private Integer idEntradaProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorUnitario")
    private Float valorUnitario;
    @Column(name = "valorCusto")
    private Float valorCusto;
    @Column(name = "valorTotal")
    private Float valorTotal;
    @Column(name = "valorTotalCusto")
    private Float valorTotalCusto;
    @Column(name = "aliquitaICMS")
    private Double aliquitaICMS;
    @Column(name = "valorICMS")
    private Float valorICMS;
    @Column(name = "valorIPI")
    private Float valorIPI;
    @Column(name = "valorST")
    private Float valorST;
    @Column(name = "quantiaddeAnterior")
    private Double quantiaddeAnterior;
    @Column(name = "quantdadeAtual")
    private Double quantdadeAtual;
    @Column(name = "preco")
    private String preco;
    @Column(name = "produto_idProduto")
    private int produto;
    @Column(name = "docentrada_idDocEntrada")
    private int docentrada;
    


    public Entradaproduto() {
    }

    public Entradaproduto(Integer idEntradaProduto) {
        this.idEntradaProduto = idEntradaProduto;
    }

    public Integer getIdEntradaProduto() {
        return idEntradaProduto;
    }

    public void setIdEntradaProduto(Integer idEntradaProduto) {
        this.idEntradaProduto = idEntradaProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Float getValorTotalCusto() {
        return valorTotalCusto;
    }

    public void setValorTotalCusto(Float valorTotalCusto) {
        this.valorTotalCusto = valorTotalCusto;
    }

    public Double getAliquitaICMS() {
        return aliquitaICMS;
    }

    public void setAliquitaICMS(Double aliquitaICMS) {
        this.aliquitaICMS = aliquitaICMS;
    }

    public Float getValorICMS() {
        return valorICMS;
    }

    public void setValorICMS(Float valorICMS) {
        this.valorICMS = valorICMS;
    }

    public Float getValorIPI() {
        return valorIPI;
    }

    public void setValorIPI(Float valorIPI) {
        this.valorIPI = valorIPI;
    }

    public Float getValorST() {
        return valorST;
    }

    public void setValorST(Float valorST) {
        this.valorST = valorST;
    }

    public Double getQuantiaddeAnterior() {
        return quantiaddeAnterior;
    }

    public void setQuantiaddeAnterior(Double quantiaddeAnterior) {
        this.quantiaddeAnterior = quantiaddeAnterior;
    }

    public Double getQuantdadeAtual() {
        return quantdadeAtual;
    }

    public void setQuantdadeAtual(Double quantdadeAtual) {
        this.quantdadeAtual = quantdadeAtual;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getDocentrada() {
        return docentrada;
    }

    public void setDocentrada(int docentrada) {
        this.docentrada = docentrada;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntradaProduto != null ? idEntradaProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entradaproduto)) {
            return false;
        }
        Entradaproduto other = (Entradaproduto) object;
        if ((this.idEntradaProduto == null && other.idEntradaProduto != null) || (this.idEntradaProduto != null && !this.idEntradaProduto.equals(other.idEntradaProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Entradaproduto[ idEntradaProduto=" + idEntradaProduto + " ]";
    }
    
}
