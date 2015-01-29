/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "subgrupoproduto")
public class Subgrupoproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubGrupoProduto")
    private Integer idsubGrupoProduto;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "percentualComissao")
    private double percentualComissao;
    @Column(name = "grupoproduto_idgrupoProduto")
    private int grupoproduto;

    public Subgrupoproduto() {
    }

    public Subgrupoproduto(Integer idsubGrupoProduto) {
        this.idsubGrupoProduto = idsubGrupoProduto;
    }

    public Integer getIdsubGrupoProduto() {
        return idsubGrupoProduto;
    }

    public void setIdsubGrupoProduto(Integer idsubGrupoProduto) {
        this.idsubGrupoProduto = idsubGrupoProduto;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getGrupoproduto() {
        return grupoproduto;
    }

    public void setGrupoproduto(int grupoproduto) {
        this.grupoproduto = grupoproduto;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubGrupoProduto != null ? idsubGrupoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subgrupoproduto)) {
            return false;
        }
        Subgrupoproduto other = (Subgrupoproduto) object;
        if ((this.idsubGrupoProduto == null && other.idsubGrupoProduto != null) || (this.idsubGrupoProduto != null && !this.idsubGrupoProduto.equals(other.idsubGrupoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getIdsubGrupoProduto() + " - " + getDescricao();
    }


}
