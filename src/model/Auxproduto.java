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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "auxproduto")
public class Auxproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauxProduto")
    private Integer idauxProduto;
    @Lob
    @Column(name = "imagem")
    private byte[] imagem;
    @Lob
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "produto_idProduto")
    private int produto;

    public Auxproduto() {
    }

    public Auxproduto(Integer idauxProduto) {
        this.idauxProduto = idauxProduto;
    }

    public Integer getIdauxProduto() {
        return idauxProduto;
    }

    public void setIdauxProduto(Integer idauxProduto) {
        this.idauxProduto = idauxProduto;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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
        hash += (idauxProduto != null ? idauxProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auxproduto)) {
            return false;
        }
        Auxproduto other = (Auxproduto) object;
        if ((this.idauxProduto == null && other.idauxProduto != null) || (this.idauxProduto != null && !this.idauxProduto.equals(other.idauxProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Auxproduto[ idauxProduto=" + idauxProduto + " ]";
    }
    
}
