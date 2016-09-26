/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@Table(name = "ibpt")
public class Ibpt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idibpt")
    private Integer idibpt;
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "ex")
    private String ex;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tipo")
    private Double tipo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "nacionalfederal")
    private Double nacionalfederal;
    @Column(name = "importadosfederal")
    private Double importadosfederal;
    @Column(name = "estadual")
    private Double estadual;
    @Column(name = "municipal")
    private Double municipal;
    @Column(name = "vigenciainicio")
    @Temporal(TemporalType.DATE)
    private Date vigenciainicio;
    @Column(name = "vigenciafim")
    @Temporal(TemporalType.DATE)
    private Date vigenciafim;
    @Column(name = "chave")
    private String chave;
    @Column(name = "versao")
    private String versao;
    @Column(name = "fonte")
    private String fonte;

    public Ibpt() {
    }

    public Ibpt(Integer idibpt) {
        this.idibpt = idibpt;
    }

    public Integer getIdibpt() {
        return idibpt;
    }

    public void setIdibpt(Integer idibpt) {
        this.idibpt = idibpt;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public Double getTipo() {
        return tipo;
    }

    public void setTipo(Double tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getNacionalfederal() {
        return nacionalfederal;
    }

    public void setNacionalfederal(Double nacionalfederal) {
        this.nacionalfederal = nacionalfederal;
    }

    public Double getImportadosfederal() {
        return importadosfederal;
    }

    public void setImportadosfederal(Double importadosfederal) {
        this.importadosfederal = importadosfederal;
    }

    public Double getEstadual() {
        return estadual;
    }

    public void setEstadual(Double estadual) {
        this.estadual = estadual;
    }

    public Double getMunicipal() {
        return municipal;
    }

    public void setMunicipal(Double municipal) {
        this.municipal = municipal;
    }

    public Date getVigenciainicio() {
        return vigenciainicio;
    }

    public void setVigenciainicio(Date vigenciainicio) {
        this.vigenciainicio = vigenciainicio;
    }

    public Date getVigenciafim() {
        return vigenciafim;
    }

    public void setVigenciafim(Date vigenciafim) {
        this.vigenciafim = vigenciafim;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idibpt != null ? idibpt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ibpt)) {
            return false;
        }
        Ibpt other = (Ibpt) object;
        if ((this.idibpt == null && other.idibpt != null) || (this.idibpt != null && !this.idibpt.equals(other.idibpt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ibpt[ idibpt=" + idibpt + " ]";
    }
    
}
