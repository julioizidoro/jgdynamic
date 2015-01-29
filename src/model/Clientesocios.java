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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "clientesocios")
@NamedQueries({
    @NamedQuery(name = "Clientesocios.findAll", query = "SELECT c FROM Clientesocios c")})
public class Clientesocios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclienteSocios")
    private Integer idclienteSocios;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "tipoSocio")
    private String tipoSocio;
    @Basic(optional = false)
    @Column(name = "cliente_idcliente")
    private int clienteIdcliente;

    public Clientesocios() {
    }

    public Clientesocios(Integer idclienteSocios) {
        this.idclienteSocios = idclienteSocios;
    }

    public Clientesocios(Integer idclienteSocios, int clienteIdcliente) {
        this.idclienteSocios = idclienteSocios;
        this.clienteIdcliente = clienteIdcliente;
    }

    public Integer getIdclienteSocios() {
        return idclienteSocios;
    }

    public void setIdclienteSocios(Integer idclienteSocios) {
        this.idclienteSocios = idclienteSocios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getClienteIdcliente() {
        return clienteIdcliente;
    }

    public String getTipoSocio() {
        return tipoSocio;
    }

    public void setTipoSocio(String tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

    public void setClienteIdcliente(int clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclienteSocios != null ? idclienteSocios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientesocios)) {
            return false;
        }
        Clientesocios other = (Clientesocios) object;
        if ((this.idclienteSocios == null && other.idclienteSocios != null) || (this.idclienteSocios != null && !this.idclienteSocios.equals(other.idclienteSocios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clientesocios[ idclienteSocios=" + idclienteSocios + " ]";
    }
    
}
