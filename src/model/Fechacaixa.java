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
@Table(name = "fechacaixa")
public class Fechacaixa implements Serializable {
    @Column(name =     "dataFechamento")
    @Temporal(TemporalType.DATE)
    private Date dataFechamento;
    @Column(name =     "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name =     "horaFechamento")
    @Temporal(TemporalType.TIME)
    private Date horaFechamento;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfechaCaixa")
    private Integer idfechaCaixa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorAbertura")
    private Float valorAbertura;
    @Column(name = "valorFechamento")
    private Float valorFechamento;
    @Column(name = "creditoDevolucao")
    private Double creditoDevolucao;
    @Column(name = "caixa")
    private String caixa;
    @Column(name = "operador")
    private String operador;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "usuarios_idusuarios")
    private int usuarios;

    public Fechacaixa() {
    }

    public Fechacaixa(Integer idfechaCaixa) {
        this.idfechaCaixa = idfechaCaixa;
    }

    public Integer getIdfechaCaixa() {
        return idfechaCaixa;
    }

    public Double getCreditoDevolucao() {
        return creditoDevolucao;
    }

    public int getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(int usuarios) {
        this.usuarios = usuarios;
    }

    public void setCreditoDevolucao(Double creditoDevolucao) {
        this.creditoDevolucao = creditoDevolucao;
    }

    public void setIdfechaCaixa(Integer idfechaCaixa) {
        this.idfechaCaixa = idfechaCaixa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Float getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(Float valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public Float getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(Float valorFechamento) {
        this.valorFechamento = valorFechamento;
    }


    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    
    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfechaCaixa != null ? idfechaCaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fechacaixa)) {
            return false;
        }
        Fechacaixa other = (Fechacaixa) object;
        if ((this.idfechaCaixa == null && other.idfechaCaixa != null) || (this.idfechaCaixa != null && !this.idfechaCaixa.equals(other.idfechaCaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fechacaixa[ idfechaCaixa=" + idfechaCaixa + " ]";
    }

   

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(Date horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

}
