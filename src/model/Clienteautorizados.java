/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "clienteautorizados")
public class Clienteautorizados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclienteAutorizados")
    private Integer idclienteAutorizados;
    @Column(name = "nome")
    private String nome;
    @Column(name = "rg")
    private String rg;
    @Column(name = "foneCelular")
    private String foneCelular;
    @Basic(optional = false)
    @Column(name = "cliente_idcliente")
    private int clienteIdcliente;

    public Clienteautorizados() {
    }

    public Clienteautorizados(Integer idclienteAutorizados) {
        this.idclienteAutorizados = idclienteAutorizados;
    }

    public Clienteautorizados(Integer idclienteAutorizados, int clienteIdcliente) {
        this.idclienteAutorizados = idclienteAutorizados;
        this.clienteIdcliente = clienteIdcliente;
    }

    public Integer getIdclienteAutorizados() {
        return idclienteAutorizados;
    }

    public void setIdclienteAutorizados(Integer idclienteAutorizados) {
        this.idclienteAutorizados = idclienteAutorizados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getFoneCelular() {
        return foneCelular;
    }

    public void setFoneCelular(String foneCelular) {
        this.foneCelular = foneCelular;
    }

    public int getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(int clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclienteAutorizados != null ? idclienteAutorizados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteautorizados)) {
            return false;
        }
        Clienteautorizados other = (Clienteautorizados) object;
        if ((this.idclienteAutorizados == null && other.idclienteAutorizados != null) || (this.idclienteAutorizados != null && !this.idclienteAutorizados.equals(other.idclienteAutorizados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clienteautorizados[ idclienteAutorizados=" + idclienteAutorizados + " ]";
    }
    
}
