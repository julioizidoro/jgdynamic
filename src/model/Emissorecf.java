/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "emissorecf")
public class Emissorecf implements Serializable {
    @Basic(optional =     false)
    @Column(name = "dataReducaoZ")
    @Temporal(TemporalType.DATE)
    private Date dataReducaoZ;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmissorECF")
    private Integer idEmissorECF;
    @Basic(optional = false)
    @Column(name = "numeroSerie")
    private String numeroSerie;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Emissorecf() {
    }

    public Emissorecf(Integer idEmissorECF) {
        this.idEmissorECF = idEmissorECF;
    }

    public Emissorecf(Integer idEmissorECF, String numeroSerie, String modelo, Date dataReducaoZ) {
        this.idEmissorECF = idEmissorECF;
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.dataReducaoZ = dataReducaoZ;
    }

    public Integer getIdEmissorECF() {
        return idEmissorECF;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    

    public void setIdEmissorECF(Integer idEmissorECF) {
        this.idEmissorECF = idEmissorECF;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmissorECF != null ? idEmissorECF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emissorecf)) {
            return false;
        }
        Emissorecf other = (Emissorecf) object;
        if ((this.idEmissorECF == null && other.idEmissorECF != null) || (this.idEmissorECF != null && !this.idEmissorECF.equals(other.idEmissorECF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Emissorecf[ idEmissorECF=" + idEmissorECF + " ]";
    }

    public Date getDataReducaoZ() {
        return dataReducaoZ;
    }

    public void setDataReducaoZ(Date dataReducaoZ) {
        this.dataReducaoZ = dataReducaoZ;
    }

    
}
