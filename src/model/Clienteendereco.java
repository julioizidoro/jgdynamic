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
@Table(name = "clienteendereco")
@NamedQueries({
    @NamedQuery(name = "Clienteendereco.findAll", query = "SELECT c FROM Clienteendereco c")})
public class Clienteendereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclienteEndereco")
    private Integer idclienteEndereco;
    @Column(name = "tipoLogradouro")
    private String tipoLogradouro;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "cliente_idcliente")
    private int clienteIdcliente;
    @Column(name = "municipios_idmunicipios")
    private int municipios;
    
    public Clienteendereco() {
    }

    public Clienteendereco(Integer idclienteEndereco) {
        this.idclienteEndereco = idclienteEndereco;
    }

    public Clienteendereco(Integer idclienteEndereco, int clienteIdcliente) {
        this.idclienteEndereco = idclienteEndereco;
        this.clienteIdcliente = clienteIdcliente;
    }

    public Integer getIdclienteEndereco() {
        return idclienteEndereco;
    }

    public void setIdclienteEndereco(Integer idclienteEndereco) {
        this.idclienteEndereco = idclienteEndereco;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(int clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    public int getMunicipios() {
        return municipios;
    }

    public void setMunicipios(int municipios) {
        this.municipios = municipios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclienteEndereco != null ? idclienteEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteendereco)) {
            return false;
        }
        Clienteendereco other = (Clienteendereco) object;
        if ((this.idclienteEndereco == null && other.idclienteEndereco != null) || (this.idclienteEndereco != null && !this.idclienteEndereco.equals(other.idclienteEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clienteendereco[ idclienteEndereco=" + idclienteEndereco + " ]";
    }
    
}
