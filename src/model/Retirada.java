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
 * @author Wolverine
 */
@Entity
@Table(name = "retirada")
public class Retirada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idretirada")
    private Integer idretirada;
    @Column(name = "historico")
    private String historico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorDinheiro")
    private Float valorDinheiro;
    @Column(name = "valorCheque")
    private Float valorCheque;
    @Column(name = "valorChequePre")
    private Float valorChequePre;
    @Column(name = "idMovimentoCaixa")
    private Integer idMovimentoCaixa;
    @Column(name = "planoconta_idplanoconta")
    private int planoconta;
    @Column(name = "fechacaixa_idfechaCaixa")
    private int fechacaixa;

    public Retirada() {
    }

    public Retirada(Integer idretirada) {
        this.idretirada = idretirada;
    }

    public Integer getIdretirada() {
        return idretirada;
    }

    public void setIdretirada(Integer idretirada) {
        this.idretirada = idretirada;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Float getValorDinheiro() {
        return valorDinheiro;
    }

    public void setValorDinheiro(Float valorDinheiro) {
        this.valorDinheiro = valorDinheiro;
    }

    public Float getValorCheque() {
        return valorCheque;
    }

    public void setValorCheque(Float valorCheque) {
        this.valorCheque = valorCheque;
    }

    public Float getValorChequePre() {
        return valorChequePre;
    }

    public void setValorChequePre(Float valorChequePre) {
        this.valorChequePre = valorChequePre;
    }


    public Integer getIdMovimentoCaixa() {
        return idMovimentoCaixa;
    }

    public void setIdMovimentoCaixa(Integer idMovimentoCaixa) {
        this.idMovimentoCaixa = idMovimentoCaixa;
    }

    public int getFechacaixa() {
        return fechacaixa;
    }

    public void setFechacaixa(int fechacaixa) {
        this.fechacaixa = fechacaixa;
    }

    public int getPlanoconta() {
        return planoconta;
    }

    public void setPlanoconta(int planoconta) {
        this.planoconta = planoconta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idretirada != null ? idretirada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retirada)) {
            return false;
        }
        Retirada other = (Retirada) object;
        if ((this.idretirada == null && other.idretirada != null) || (this.idretirada != null && !this.idretirada.equals(other.idretirada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Retirada[ idretirada=" + idretirada + " ]";
    }
    
}
