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
@Table(name = "clienteenderecoentrega")
public class Clienteenderecoentrega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclienteEnderecoEntrega")
    private Integer idclienteEnderecoEntrega;
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
    @Column(name = "pontoReferencia")
    private String pontoReferencia;
    @Basic(optional = false)
    @Column(name = "cliente_idcliente")
    private int clienteIdcliente;

    public Clienteenderecoentrega() {
    }

    public Clienteenderecoentrega(Integer idclienteEnderecoEntrega) {
        this.idclienteEnderecoEntrega = idclienteEnderecoEntrega;
    }

    public Clienteenderecoentrega(Integer idclienteEnderecoEntrega, int clienteIdcliente) {
        this.idclienteEnderecoEntrega = idclienteEnderecoEntrega;
        this.clienteIdcliente = clienteIdcliente;
    }

    public Integer getIdclienteEnderecoEntrega() {
        return idclienteEnderecoEntrega;
    }

    public void setIdclienteEnderecoEntrega(Integer idclienteEnderecoEntrega) {
        this.idclienteEnderecoEntrega = idclienteEnderecoEntrega;
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

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
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
        hash += (idclienteEnderecoEntrega != null ? idclienteEnderecoEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteenderecoentrega)) {
            return false;
        }
        Clienteenderecoentrega other = (Clienteenderecoentrega) object;
        if ((this.idclienteEnderecoEntrega == null && other.idclienteEnderecoEntrega != null) || (this.idclienteEnderecoEntrega != null && !this.idclienteEnderecoEntrega.equals(other.idclienteEnderecoEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clienteenderecoentrega[ idclienteEnderecoEntrega=" + idclienteEnderecoEntrega + " ]";
    }
    
}
