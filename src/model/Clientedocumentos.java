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
@Table(name = "clientedocumentos")
public class Clientedocumentos implements Serializable {
    @Lob
    @Column(name = "imagem")
    private byte[] imagem;
    @Column(name = "cliente_idcliente")
    private Cliente cliente;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclienteDocumentos")
    private Integer idclienteDocumentos;
    @Column(name = "nomeDocumento")
    private String nomeDocumento;
  

    public Clientedocumentos() {
    }

    public Clientedocumentos(Integer idclienteDocumentos) {
        this.idclienteDocumentos = idclienteDocumentos;
    }

    public Integer getIdclienteDocumentos() {
        return idclienteDocumentos;
    }

    public void setIdclienteDocumentos(Integer idclienteDocumentos) {
        this.idclienteDocumentos = idclienteDocumentos;
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclienteDocumentos != null ? idclienteDocumentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientedocumentos)) {
            return false;
        }
        Clientedocumentos other = (Clientedocumentos) object;
        if ((this.idclienteDocumentos == null && other.idclienteDocumentos != null) || (this.idclienteDocumentos != null && !this.idclienteDocumentos.equals(other.idclienteDocumentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clientedocumentos[ idclienteDocumentos=" + idclienteDocumentos + " ]";
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
