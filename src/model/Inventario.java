/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinventario")
    private Integer idinventario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorunitario")
    private Float valorunitario;
    @Column(name = "quantidadeestoque")
    private Double quantidadeestoque;
    @Column(name = "valortotal")
    private Float valortotal;
    @Column(name = "valorvenda")
    private Float valorvenda;
    @JoinColumn(name = "encerramento_idencerramento", referencedColumnName = "idencerramento")
    @ManyToOne(optional = false)
    private Encerramento encerramento;
    @JoinColumn(name = "produto_idProduto", referencedColumnName = "idProduto")
    @ManyToOne(optional = false)
    private Produto produto;

    public Inventario() {
    }

    public Inventario(Integer idinventario) {
        this.idinventario = idinventario;
    }

    public Integer getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(Integer idinventario) {
        this.idinventario = idinventario;
    }

    public Float getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(Float valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Double getQuantidadeestoque() {
        return quantidadeestoque;
    }

    public void setQuantidadeestoque(Double quantidadeestoque) {
        this.quantidadeestoque = quantidadeestoque;
    }

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
    }

    public Float getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(Float valorvenda) {
        this.valorvenda = valorvenda;
    }

    public Encerramento getEncerramento() {
        return encerramento;
    }

    public void setEncerramento(Encerramento encerramento) {
        this.encerramento = encerramento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinventario != null ? idinventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idinventario == null && other.idinventario != null) || (this.idinventario != null && !this.idinventario.equals(other.idinventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Inventario[ idinventario=" + idinventario + " ]";
    }
    
}
