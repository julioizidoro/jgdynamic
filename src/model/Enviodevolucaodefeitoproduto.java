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
@Table(name = "enviodevolucaodefeitoproduto")
public class Enviodevolucaodefeitoproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idenvioDevolucaoDefeitoProduto")
    private Integer idenvioDevolucaoDefeitoProduto;
    @Column(name = "envioDevolucaoDefeito_idenvioDevolucaoDefeito")
    private Integer envioDevolucaoDefeito;
    @Column(name = "devolucaoDefeito_iddevolucaoDefeito")
    private Integer devolucaoDefeito;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Enviodevolucaodefeitoproduto() {
    }

    public Enviodevolucaodefeitoproduto(Integer idenvioDevolucaoDefeitoProduto) {
        this.idenvioDevolucaoDefeitoProduto = idenvioDevolucaoDefeitoProduto;
    }

    public Integer getIdenvioDevolucaoDefeitoProduto() {
        return idenvioDevolucaoDefeitoProduto;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public void setIdenvioDevolucaoDefeitoProduto(Integer idenvioDevolucaoDefeitoProduto) {
        this.idenvioDevolucaoDefeitoProduto = idenvioDevolucaoDefeitoProduto;
    }

    public Integer getEnvioDevolucaoDefeito() {
        return envioDevolucaoDefeito;
    }

    public void setEnvioDevolucaoDefeito(Integer envioDevolucaoDefeito) {
        this.envioDevolucaoDefeito = envioDevolucaoDefeito;
    }

    

    public Integer getDevolucaoDefeito() {
        return devolucaoDefeito;
    }

    public void setDevolucaoDefeito(Integer devolucaoDefeito) {
        this.devolucaoDefeito = devolucaoDefeito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenvioDevolucaoDefeitoProduto != null ? idenvioDevolucaoDefeitoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enviodevolucaodefeitoproduto)) {
            return false;
        }
        Enviodevolucaodefeitoproduto other = (Enviodevolucaodefeitoproduto) object;
        if ((this.idenvioDevolucaoDefeitoProduto == null && other.idenvioDevolucaoDefeitoProduto != null) || (this.idenvioDevolucaoDefeitoProduto != null && !this.idenvioDevolucaoDefeitoProduto.equals(other.idenvioDevolucaoDefeitoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Enviodevolucaodefeitoproduto[ idenvioDevolucaoDefeitoProduto=" + idenvioDevolucaoDefeitoProduto + " ]";
    }
    
}
