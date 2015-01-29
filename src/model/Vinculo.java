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
@Table(name = "vinculo")
public class Vinculo implements Serializable {
    @Column(name =     "dataCompra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Column(name = "pedido")
    private String pedido;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvinculo")
    private Integer idvinculo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorCompra")
    private Float valorCompra;
    @Column(name = "codigoFabricante")
    private String codigoFabricante;
    @Column(name = "embalagem")
    private Long embalagem;
    @Column(name = "produto_idProduto")
    private int produto;
    @Column(name = "fornecedor_idfornecedor")
    private int fornecedor;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Vinculo() {
    }

    public Vinculo(Integer idvinculo) {
        this.idvinculo = idvinculo;
    }

    public Integer getIdvinculo() {
        return idvinculo;
    }

    public void setIdvinculo(Integer idvinculo) {
        this.idvinculo = idvinculo;
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(String codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    public Long getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Long embalagem) {
        this.embalagem = embalagem;
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

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvinculo != null ? idvinculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vinculo)) {
            return false;
        }
        Vinculo other = (Vinculo) object;
        if ((this.idvinculo == null && other.idvinculo != null) || (this.idvinculo != null && !this.idvinculo.equals(other.idvinculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vinculo[ idvinculo=" + idvinculo + " ]";
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
    
}
