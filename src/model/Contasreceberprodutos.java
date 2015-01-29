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
 * @author Julio
 */
@Entity
@Table(name = "contasreceberprodutos")
@NamedQueries({
    @NamedQuery(name = "Contasreceberprodutos.findAll", query = "SELECT c FROM Contasreceberprodutos c")})
public class Contasreceberprodutos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontasReceberProdutos")
    private Integer idcontasReceberProdutos;
    @JoinColumn(name = "venda_idVenda", referencedColumnName = "idvenda")
    @ManyToOne(optional = false)
    private Venda venda;
    @JoinColumn(name = "contasreceber_idcontasReceber", referencedColumnName = "idcontasReceber")
    @ManyToOne(optional = false)
    private Contasreceber contasreceber;

    public Contasreceberprodutos() {
    }

    public Contasreceberprodutos(Integer idcontasReceberProdutos) {
        this.idcontasReceberProdutos = idcontasReceberProdutos;
    }

    public Integer getIdcontasReceberProdutos() {
        return idcontasReceberProdutos;
    }

    public void setIdcontasReceberProdutos(Integer idcontasReceberProdutos) {
        this.idcontasReceberProdutos = idcontasReceberProdutos;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Contasreceber getContasreceber() {
        return contasreceber;
    }

    public void setContasreceber(Contasreceber contasreceber) {
        this.contasreceber = contasreceber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontasReceberProdutos != null ? idcontasReceberProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contasreceberprodutos)) {
            return false;
        }
        Contasreceberprodutos other = (Contasreceberprodutos) object;
        if ((this.idcontasReceberProdutos == null && other.idcontasReceberProdutos != null) || (this.idcontasReceberProdutos != null && !this.idcontasReceberProdutos.equals(other.idcontasReceberProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contasreceberprodutos[ idcontasReceberProdutos=" + idcontasReceberProdutos + " ]";
    }
    
}
