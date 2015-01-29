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
 * @author wolverine
 */
@Entity
@Table(name = "controlecheques")
public class Controlecheques implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idControleCheques")
    private Integer idControleCheques;
    @Column(name = "banco")
    private String banco;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "contaCorrente")
    private String contaCorrente;
    @Column(name = "numeroCheque")
    private String numeroCheque;
    @Column(name = "dataEmissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "dataCompensacao")
    @Temporal(TemporalType.DATE)
    private Date dataCompensacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorCheque")
    private Double valorCheque;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "local")
    private String local;
    @Column(name = "chequeTroca")
    private String chequeTroca;
    @Column(name = "preDatado")
    private String preDatado;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "cliente_idcliente")
    private int cliente;

    public Controlecheques() {
    }

    public Controlecheques(Integer idControleCheques) {
        this.idControleCheques = idControleCheques;
    }

    public Integer getIdControleCheques() {
        return idControleCheques;
    }

    public void setIdControleCheques(Integer idControleCheques) {
        this.idControleCheques = idControleCheques;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataCompensacao() {
        return dataCompensacao;
    }

    public void setDataCompensacao(Date dataCompensacao) {
        this.dataCompensacao = dataCompensacao;
    }

    public Double getValorCheque() {
        return valorCheque;
    }

    public void setValorCheque(Double valorCheque) {
        this.valorCheque = valorCheque;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getChequeTroca() {
        return chequeTroca;
    }

    public void setChequeTroca(String chequeTroca) {
        this.chequeTroca = chequeTroca;
    }

    public String getPreDatado() {
        return preDatado;
    }

    public void setPreDatado(String preDatado) {
        this.preDatado = preDatado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControleCheques != null ? idControleCheques.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controlecheques)) {
            return false;
        }
        Controlecheques other = (Controlecheques) object;
        if ((this.idControleCheques == null && other.idControleCheques != null) || (this.idControleCheques != null && !this.idControleCheques.equals(other.idControleCheques))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Controlecheques[ idControleCheques=" + idControleCheques + " ]";
    }
}
