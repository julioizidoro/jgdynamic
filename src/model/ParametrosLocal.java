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
import javax.persistence.Table;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "parametroslocal")
public class ParametrosLocal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparametros")
    private Integer idparametros;
    @Column(name = "numeroReciboEntrada")
    private Integer numeroReciboEntrada;
    @Column(name = "numeroDias")
    private Integer numeroDias;
    @Column(name = "numeroFatura")
    private Integer numeroFatura;
    @Basic(optional = false)
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "clienteDesconto")
    private int clienteDesconto;
    @Column(name= "consultaProduto")
    private String consultaProduto;
    @Column(name= "cadastrarEstoqueBase")
    private int cadastrarEstoqueBase;
    @Column(name= "impostocst")
    private double impostocst;
    @Column(name= "impostosst")
    private double impostosst;
    @Column(name= "versaonfe")
    private String versaonfe;
    

    public ParametrosLocal() {
    }


    public Integer getIdparametros() {
        return idparametros;
    }

    public void setIdparametros(Integer idparametros) {
        this.idparametros = idparametros;
    }

    public int getCadastrarEstoqueBase() {
        return cadastrarEstoqueBase;
    }

    public void setCadastrarEstoqueBase(int cadastrarEstoqueBase) {
        this.cadastrarEstoqueBase = cadastrarEstoqueBase;
    }

    public Integer getNumeroReciboEntrada() {
        return numeroReciboEntrada;
    }

    public void setNumeroReciboEntrada(Integer numeroReciboEntrada) {
        this.numeroReciboEntrada = numeroReciboEntrada;
    }

    public Integer getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(Integer numeroDias) {
        this.numeroDias = numeroDias;
    }

    public Integer getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(Integer numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public String getConsultaProduto() {
        return consultaProduto;
    }

    public void setConsultaProduto(String consultaProduto) {
        this.consultaProduto = consultaProduto;
    }

    public int getClienteDesconto() {
        return clienteDesconto;
    }

    public void setClienteDesconto(int clienteDesconto) {
        this.clienteDesconto = clienteDesconto;
    }

    public double getImpostocst() {
        return impostocst;
    }

    public void setImpostocst(double impostocst) {
        this.impostocst = impostocst;
    }

    public double getImpostosst() {
        return impostosst;
    }

    public void setImpostosst(double impostosst) {
        this.impostosst = impostosst;
    }

    public String getVersaonfe() {
        return versaonfe;
    }

    public void setVersaonfe(String versaonfe) {
        this.versaonfe = versaonfe;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparametros != null ? idparametros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametrosLocal)) {
            return false;
        }
        ParametrosLocal other = (ParametrosLocal) object;
        if ((this.idparametros == null && other.idparametros != null) || (this.idparametros != null && !this.idparametros.equals(other.idparametros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ParametrosLocal[ idparametros=" + idparametros + " ]";
    }
    
}
