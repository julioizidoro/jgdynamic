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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "formavenda")
public class Formavenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformaVenda")
    private Integer idformaVenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorRecebido")
    private Float valorRecebido;
    @Column(name = "venda_idvenda")
    private int venda;
    @Column(name = "formapagamento_idformaPagamento")
    private int formapagamento;

    public Formavenda() {
    }

    public Formavenda(Integer idformaVenda) {
        this.idformaVenda = idformaVenda;
    }

    public Integer getIdformaVenda() {
        return idformaVenda;
    }

    public void setIdformaVenda(Integer idformaVenda) {
        this.idformaVenda = idformaVenda;
    }

    public Float getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(Float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }
    
    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public int getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(int formapagamento) {
        this.formapagamento = formapagamento;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformaVenda != null ? idformaVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formavenda)) {
            return false;
        }
        Formavenda other = (Formavenda) object;
        if ((this.idformaVenda == null && other.idformaVenda != null) || (this.idformaVenda != null && !this.idformaVenda.equals(other.idformaVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Formavenda[ idformaVenda=" + idformaVenda + " ]";
    }
    
}
