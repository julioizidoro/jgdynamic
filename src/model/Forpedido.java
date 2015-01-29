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
@Table(name = "forpedido")
public class Forpedido implements Serializable {
    @Column(name =     "dataEmissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name =     "dataEntrega")
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idForPedido")
    private Integer idForPedido;
    @Column(name = "condicaoPagamento")
    private String condicaoPagamento;
    @Basic(optional = false)
    @Column(name = "entregue")
    private boolean entregue;
    @Column(name = "dataRegistro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataRegistro;
    @Column(name = "registrado")
    private String registrado;
    @Column(name = "fornecedor_idfornecedor1")
    private int fornecedor;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Forpedido() {
    }

    public Forpedido(Integer idForPedido) {
        this.idForPedido = idForPedido;
    }

    public Forpedido(Integer idForPedido, boolean entregue) {
        this.idForPedido = idForPedido;
        this.entregue = entregue;
    }

    public Integer getIdForPedido() {
        return idForPedido;
    }

    public void setIdForPedido(Integer idForPedido) {
        this.idForPedido = idForPedido;
    }

    public String getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(String condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getRegistrado() {
        return registrado;
    }

    public void setRegistrado(String registrado) {
        this.registrado = registrado;
    }

    public boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
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
        hash += (idForPedido != null ? idForPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forpedido)) {
            return false;
        }
        Forpedido other = (Forpedido) object;
        if ((this.idForPedido == null && other.idForPedido != null) || (this.idForPedido != null && !this.idForPedido.equals(other.idForPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Forpedido[ idForPedido=" + idForPedido + " ]";
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
}
