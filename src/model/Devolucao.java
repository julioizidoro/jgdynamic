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
@Table(name = "devolucao")
public class Devolucao implements Serializable {
    @Column(name =     "dataDevolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @Column(name =     "horaDevolucao")
    @Temporal(TemporalType.TIME)
    private Date horaDevolucao;
    @Column(name = "vendedor_idvendedor")
    private int vendedor;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddevolucao")
    private Integer iddevolucao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorDevolucao")
    private Float valorDevolucao;
    @Column(name = "valorCompra")
    private Float valorCompra;
    @Column(name = "numeroItens")
    private Integer numeroItens;
     @Column(name = "condicaoDevolucao")
    private String condicaoDevolucao;
    @Column(name = "fechacaixa_idfechaCaixa")
    private int fechacaixa;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Devolucao() {
    }

    public Devolucao(Integer iddevolucao) {
        this.iddevolucao = iddevolucao;
    }

    public Integer getIddevolucao() {
        return iddevolucao;
    }

    public void setIddevolucao(Integer iddevolucao) {
        this.iddevolucao = iddevolucao;
    }

    public String getCondicaoDevolucao() {
        return condicaoDevolucao;
    }

    public void setCondicaoDevolucao(String condicaoDevolucao) {
        this.condicaoDevolucao = condicaoDevolucao;
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getFechacaixa() {
        return fechacaixa;
    }

    public void setFechacaixa(int fechacaixa) {
        this.fechacaixa = fechacaixa;
    }

    public Float getValorDevolucao() {
        return valorDevolucao;
    }

    public void setValorDevolucao(Float valorDevolucao) {
        this.valorDevolucao = valorDevolucao;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public Integer getNumeroItens() {
        return numeroItens;
    }

    public void setNumeroItens(Integer numeroItens) {
        this.numeroItens = numeroItens;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddevolucao != null ? iddevolucao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucao)) {
            return false;
        }
        Devolucao other = (Devolucao) object;
        if ((this.iddevolucao == null && other.iddevolucao != null) || (this.iddevolucao != null && !this.iddevolucao.equals(other.iddevolucao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Devolucao[ iddevolucao=" + iddevolucao + " ]";
    }

    
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(Date horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }
    
}
