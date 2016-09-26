/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "encerramento")
public class Encerramento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idencerramento")
    private Integer idencerramento;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "periodo")
    private String periodo;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    private String hora;
    @Column(name = "usuario")
    private String usuario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "contasreceber180")
    private Float contasreceber180;
    @Column(name = "contasrecebervencidas")
    private Float contasrecebervencidas;
    @Column(name = "contasrecebervencendo")
    private Float contasrecebervencendo;
    @Column(name = "contasreceberavencer")
    private Float contasreceberavencer;
    @Column(name = "contaspagarvencidas")
    private Float contaspagarvencidas;
    @Column(name = "contaspagarvencendo")
    private Float contaspagarvencendo;
    @Column(name = "contaspagarvencer")
    private Float contaspagarvencer;
    @Column(name = "saldocaixa")
    private Float saldocaixa;
    @Column(name = "totalestoque")
    private Float totalestoque;
    @Column(name = "creditos")
    private Float creditos;
    @Column(name = "bb")
    private Float bb;
    @Column(name = "cef")
    private Float cef;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encerramento")
    private List<Inventario> inventarioList;

    public Encerramento() {
    }

    public Encerramento(Integer idencerramento) {
        this.idencerramento = idencerramento;
    }

    public Integer getIdencerramento() {
        return idencerramento;
    }

    public void setIdencerramento(Integer idencerramento) {
        this.idencerramento = idencerramento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Float getContasreceber180() {
        return contasreceber180;
    }

    public void setContasreceber180(Float contasreceber180) {
        this.contasreceber180 = contasreceber180;
    }

    public Float getContasrecebervencidas() {
        return contasrecebervencidas;
    }

    public void setContasrecebervencidas(Float contasrecebervencidas) {
        this.contasrecebervencidas = contasrecebervencidas;
    }

    public Float getContasrecebervencendo() {
        return contasrecebervencendo;
    }

    public void setContasrecebervencendo(Float contasrecebervencendo) {
        this.contasrecebervencendo = contasrecebervencendo;
    }

    public Float getContasreceberavencer() {
        return contasreceberavencer;
    }

    public void setContasreceberavencer(Float contasreceberavencer) {
        this.contasreceberavencer = contasreceberavencer;
    }

    public Float getContaspagarvencidas() {
        return contaspagarvencidas;
    }

    public void setContaspagarvencidas(Float contaspagarvencidas) {
        this.contaspagarvencidas = contaspagarvencidas;
    }

    public Float getContaspagarvencendo() {
        return contaspagarvencendo;
    }

    public void setContaspagarvencendo(Float contaspagarvencendo) {
        this.contaspagarvencendo = contaspagarvencendo;
    }

    public Float getContaspagarvencer() {
        return contaspagarvencer;
    }

    public void setContaspagarvencer(Float contaspagarvencer) {
        this.contaspagarvencer = contaspagarvencer;
    }

    public Float getSaldocaixa() {
        return saldocaixa;
    }

    public void setSaldocaixa(Float saldocaixa) {
        this.saldocaixa = saldocaixa;
    }

    public Float getTotalestoque() {
        return totalestoque;
    }

    public void setTotalestoque(Float totalestoque) {
        this.totalestoque = totalestoque;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    public Float getCreditos() {
        return creditos;
    }

    public void setCreditos(Float creditos) {
        this.creditos = creditos;
    }

    public Float getBb() {
        return bb;
    }

    public void setBb(Float bb) {
        this.bb = bb;
    }

    public Float getCef() {
        return cef;
    }

    public void setCef(Float cef) {
        this.cef = cef;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idencerramento != null ? idencerramento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encerramento)) {
            return false;
        }
        Encerramento other = (Encerramento) object;
        if ((this.idencerramento == null && other.idencerramento != null) || (this.idencerramento != null && !this.idencerramento.equals(other.idencerramento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Encerramento[ idencerramento=" + idencerramento + " ]";
    }
    
}
