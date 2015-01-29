/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "enviodevolucaodefeito")
public class Enviodevolucaodefeito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idenvioDevolucaoDefeito")
    private Integer idenvioDevolucaoDefeito;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "vededor")
    private String vededor;
    @Column(name = "usuarios_idusuarios")
    private int usuarios;
    @Column(name = "fornecedor_idfornecedor")
    private int fornecedor;
     @Column(name = "recebida")
    private String recebida;
     @Column(name = "empresa_idempresa")
    private int empresa;

    public Enviodevolucaodefeito() {
    }

    public Enviodevolucaodefeito(Integer idenvioDevolucaoDefeito) {
        this.idenvioDevolucaoDefeito = idenvioDevolucaoDefeito;
    }

    public Integer getIdenvioDevolucaoDefeito() {
        return idenvioDevolucaoDefeito;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public void setIdenvioDevolucaoDefeito(Integer idenvioDevolucaoDefeito) {
        this.idenvioDevolucaoDefeito = idenvioDevolucaoDefeito;
    }

    public Date getData() {
        return data;
    }

    public String getRecebida() {
        return recebida;
    }

    public void setRecebida(String recebida) {
        this.recebida = recebida;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getVededor() {
        return vededor;
    }

    public void setVededor(String vededor) {
        this.vededor = vededor;
    }

    public int getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(int usuarios) {
        this.usuarios = usuarios;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenvioDevolucaoDefeito != null ? idenvioDevolucaoDefeito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enviodevolucaodefeito)) {
            return false;
        }
        Enviodevolucaodefeito other = (Enviodevolucaodefeito) object;
        if ((this.idenvioDevolucaoDefeito == null && other.idenvioDevolucaoDefeito != null) || (this.idenvioDevolucaoDefeito != null && !this.idenvioDevolucaoDefeito.equals(other.idenvioDevolucaoDefeito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Enviodevolucaodefeito[ idenvioDevolucaoDefeito=" + idenvioDevolucaoDefeito + " ]";
    }
    
}
