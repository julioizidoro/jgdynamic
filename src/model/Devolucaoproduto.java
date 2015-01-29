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
@Table(name = "devolucaoproduto")
public class Devolucaoproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddevolucaoProduto")
    private Integer iddevolucaoProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeDevolucao")
    private Double quantidadeDevolucao;
    @Column(name = "valorUnitario")
    private Float valorUnitario;
    @Column(name = "valorTotal")
    private Float valorTotal;
    @Column(name = "valorCompra")
    private Float valorCompra;
    @Column(name = "produto_idProduto")
    private int produto;
    @Column(name = "devolucao_iddevolucao")
    private int devolucao;

    public Devolucaoproduto() {
    }

    public Devolucaoproduto(Integer iddevolucaoProduto) {
        this.iddevolucaoProduto = iddevolucaoProduto;
    }

    public Integer getIddevolucaoProduto() {
        return iddevolucaoProduto;
    }

    public void setIddevolucaoProduto(Integer iddevolucaoProduto) {
        this.iddevolucaoProduto = iddevolucaoProduto;
    }

    public Double getQuantidadeDevolucao() {
        return quantidadeDevolucao;
    }

    public void setQuantidadeDevolucao(Double quantidadeDevolucao) {
        this.quantidadeDevolucao = quantidadeDevolucao;
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
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

    public int getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(int devolucao) {
        this.devolucao = devolucao;
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
        hash += (iddevolucaoProduto != null ? iddevolucaoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucaoproduto)) {
            return false;
        }
        Devolucaoproduto other = (Devolucaoproduto) object;
        if ((this.iddevolucaoProduto == null && other.iddevolucaoProduto != null) || (this.iddevolucaoProduto != null && !this.iddevolucaoProduto.equals(other.iddevolucaoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Devolucaoproduto[ iddevolucaoProduto=" + iddevolucaoProduto + " ]";
    }
    
}
