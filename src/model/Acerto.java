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
@Table(name = "acerto")
public class Acerto implements Serializable {
    @Column(name =     "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacerto")
    private Integer idacerto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeAcerto")
    private Double quantidadeAcerto;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "quantidadeEstoque")
    private Double quantidadeEstoque;
    @Column(name = "produto_idProduto")
    private int produto;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Acerto() {
    }

    public Acerto(Integer idacerto) {
        this.idacerto = idacerto;
    }

    public Integer getIdacerto() {
        return idacerto;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public void setIdacerto(Integer idacerto) {
        this.idacerto = idacerto;
    }

    public Double getQuantidadeAcerto() {
        return quantidadeAcerto;
    }

    public void setQuantidadeAcerto(Double quantidadeAcerto) {
        this.quantidadeAcerto = quantidadeAcerto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
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
        hash += (idacerto != null ? idacerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acerto)) {
            return false;
        }
        Acerto other = (Acerto) object;
        if ((this.idacerto == null && other.idacerto != null) || (this.idacerto != null && !this.idacerto.equals(other.idacerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Acerto[ idacerto=" + idacerto + " ]";
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
