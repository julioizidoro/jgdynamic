/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "movimentobanco")
public class Movimentobanco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimentoBanco")
    private Integer idmovimentoBanco;
    @Column(name = "dataMovimento")
    @Temporal(TemporalType.DATE)
    private Date dataMovimento;
    @Column(name = "dataLancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorSaida")
    private Float valorSaida;
    @Column(name = "valorEntrada")
    private Float valorEntrada;
    @Column(name = "planoconta_idplanoconta")
    private int planoconta;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "banco_idbanco")
    private int banco;

    public Movimentobanco() {
    }

    public Movimentobanco(Integer idmovimentoBanco) {
        this.idmovimentoBanco = idmovimentoBanco;
    }

    public Integer getIdmovimentoBanco() {
        return idmovimentoBanco;
    }

    public void setIdmovimentoBanco(Integer idmovimentoBanco) {
        this.idmovimentoBanco = idmovimentoBanco;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(Float valorSaida) {
        this.valorSaida = valorSaida;
    }

    public Float getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Float valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
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
        hash += (idmovimentoBanco != null ? idmovimentoBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentobanco)) {
            return false;
        }
        Movimentobanco other = (Movimentobanco) object;
        if ((this.idmovimentoBanco == null && other.idmovimentoBanco != null) || (this.idmovimentoBanco != null && !this.idmovimentoBanco.equals(other.idmovimentoBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Movimentobanco[ idmovimentoBanco=" + idmovimentoBanco + " ]";
    }

}
