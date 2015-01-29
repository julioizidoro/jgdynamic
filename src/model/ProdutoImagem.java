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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "produtoImagem")
@NamedQueries({
    @NamedQuery(name = "ProdutoImagem.findAll", query = "SELECT p FROM ProdutoImagem p")})
public class ProdutoImagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprodutoImagem")
    private Integer idprodutoImagem;
    @Lob
    @Column(name = "imagem")
    private byte[] imagem;
    @Column(name = "produto_idproduto")
    private int produto;

    public ProdutoImagem() {
    }

    public ProdutoImagem(Integer idprodutoImagem) {
        this.idprodutoImagem = idprodutoImagem;
    }

    public Integer getIdprodutoImagem() {
        return idprodutoImagem;
    }

    public void setIdprodutoImagem(Integer idprodutoImagem) {
        this.idprodutoImagem = idprodutoImagem;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
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
        hash += (idprodutoImagem != null ? idprodutoImagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoImagem)) {
            return false;
        }
        ProdutoImagem other = (ProdutoImagem) object;
        if ((this.idprodutoImagem == null && other.idprodutoImagem != null) || (this.idprodutoImagem != null && !this.idprodutoImagem.equals(other.idprodutoImagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProdutoImagem[ idprodutoImagem=" + idprodutoImagem + " ]";
    }
    
}
