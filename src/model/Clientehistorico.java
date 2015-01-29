/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "clientehistorico")
public class Clientehistorico implements Serializable {
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "usuarios_idusuarios")
    private int usuarios;
    @Column(name = "cliente_idcliente")
    private int cliente;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclienteHistorico")
    private Integer idclienteHistorico;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    

    public Clientehistorico() {
    }

    public Clientehistorico(Integer idclienteHistorico) {
        this.idclienteHistorico = idclienteHistorico;
    }

    

    public Integer getIdclienteHistorico() {
        return idclienteHistorico;
    }

    public void setIdclienteHistorico(Integer idclienteHistorico) {
        this.idclienteHistorico = idclienteHistorico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(int usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclienteHistorico != null ? idclienteHistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientehistorico)) {
            return false;
        }
        Clientehistorico other = (Clientehistorico) object;
        if ((this.idclienteHistorico == null && other.idclienteHistorico != null) || (this.idclienteHistorico != null && !this.idclienteHistorico.equals(other.idclienteHistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clientehistorico[ idclienteHistorico=" + idclienteHistorico + " ]";
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

 
    
}
