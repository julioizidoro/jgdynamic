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
@Table(name = "reducaoz")
public class Reducaoz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReducao")
    private Integer idReducao;
    @Column(name = "contador")
    private Integer contador;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "COO")
    private String coo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vendaBruta")
    private Double vendaBruta;
    @Column(name = "vendaLiquida")
    private Double vendaLiquida;
    @Column(name = "cancelamentos")
    private Double cancelamentos;
    @Column(name = "acrescimos")
    private Double acrescimos;
    @Column(name = "descontos")
    private Double descontos;
    @Column(name = "iss")
    private Double iss;
    @Column(name = "isencao")
    private Double isencao;
    @Column(name = "naoIncidente")
    private Double naoIncidente;
    @Column(name = "st")
    private Double st;
    @Column(name = "i7")
    private Double i7;
    @Column(name = "i12")
    private Double i12;
    @Column(name = "i17")
    private Double i17;
    @Column(name = "i25")
    private Double i25;

    public Reducaoz() {
    }

    public Reducaoz(Integer idReducao) {
        this.idReducao = idReducao;
    }

    public Integer getIdReducao() {
        return idReducao;
    }

    public void setIdReducao(Integer idReducao) {
        this.idReducao = idReducao;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCoo() {
        return coo;
    }

    public void setCoo(String coo) {
        this.coo = coo;
    }

    public Double getVendaBruta() {
        return vendaBruta;
    }

    public void setVendaBruta(Double vendaBruta) {
        this.vendaBruta = vendaBruta;
    }

    public Double getVendaLiquida() {
        return vendaLiquida;
    }

    public void setVendaLiquida(Double vendaLiquida) {
        this.vendaLiquida = vendaLiquida;
    }

    public Double getCancelamentos() {
        return cancelamentos;
    }

    public void setCancelamentos(Double cancelamentos) {
        this.cancelamentos = cancelamentos;
    }

    public Double getAcrescimos() {
        return acrescimos;
    }

    public void setAcrescimos(Double acrescimos) {
        this.acrescimos = acrescimos;
    }

    public Double getDescontos() {
        return descontos;
    }

    public void setDescontos(Double descontos) {
        this.descontos = descontos;
    }

    public Double getIss() {
        return iss;
    }

    public void setIss(Double iss) {
        this.iss = iss;
    }

    public Double getIsencao() {
        return isencao;
    }

    public void setIsencao(Double isencao) {
        this.isencao = isencao;
    }

    public Double getNaoIncidente() {
        return naoIncidente;
    }

    public void setNaoIncidente(Double naoIncidente) {
        this.naoIncidente = naoIncidente;
    }

    public Double getSt() {
        return st;
    }

    public void setSt(Double st) {
        this.st = st;
    }

    public Double getI7() {
        return i7;
    }

    public void setI7(Double i7) {
        this.i7 = i7;
    }

    public Double getI12() {
        return i12;
    }

    public void setI12(Double i12) {
        this.i12 = i12;
    }

    public Double getI17() {
        return i17;
    }

    public void setI17(Double i17) {
        this.i17 = i17;
    }

    public Double getI25() {
        return i25;
    }

    public void setI25(Double i25) {
        this.i25 = i25;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReducao != null ? idReducao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reducaoz)) {
            return false;
        }
        Reducaoz other = (Reducaoz) object;
        if ((this.idReducao == null && other.idReducao != null) || (this.idReducao != null && !this.idReducao.equals(other.idReducao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Reducaoz[ idReducao=" + idReducao + " ]";
    }
    
}
