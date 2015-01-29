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
@Table(name = "forpedproduto")
public class Forpedproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idForPedProduto")
    private Integer idForPedProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "entrada")
    private Integer entrada;
    @Column(name = "vinculo_idvinculo")
    private int vinculo;
    @Column(name = "produto_idProduto")
    private int produto;
    @Column(name = "forpedido_idForPedido")
    private int forpedido;

    public Forpedproduto() {
    }

    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    public int getForpedido() {
        return forpedido;
    }

    public void setForpedido(int forpedido) {
        this.forpedido = forpedido;
    }

    
    public Integer getIdForPedProduto() {
        return idForPedProduto;
    }

    public void setIdForPedProduto(Integer idForPedProduto) {
        this.idForPedProduto = idForPedProduto;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public int getVinculo() {
        return vinculo;
    }

    public void setVinculo(int vinculo) {
        this.vinculo = vinculo;
    }

   
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idForPedProduto != null ? idForPedProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forpedproduto)) {
            return false;
        }
        Forpedproduto other = (Forpedproduto) object;
        if ((this.idForPedProduto == null && other.idForPedProduto != null) || (this.idForPedProduto != null && !this.idForPedProduto.equals(other.idForPedProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Forpedproduto[ idForPedProduto=" + idForPedProduto + " ]";
    }
    
}
