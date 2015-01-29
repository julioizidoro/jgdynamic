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
@Table(name = "movimentocaixa")
public class Movimentocaixa implements Serializable {
    @Column(name =     "dataMovimento")
    @Temporal(TemporalType.DATE)
    private Date dataMovimento;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimentoCaixa")
    private Integer idmovimentoCaixa;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorEntrada")
    private Float valorEntrada;
    @Column(name = "valorSaida")
    private Float valorSaida;
    @Column(name = "usuarioLancamento")
    private String usuarioLancamento;
    @Column(name = "usuarioAlteracao")
    private String usuarioAlteracao;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "planoconta_idplanoconta")
    private int planoconta;

    public Movimentocaixa() {
    }

    public Movimentocaixa(Integer idmovimentoCaixa) {
        this.idmovimentoCaixa = idmovimentoCaixa;
    }

    public Integer getIdmovimentoCaixa() {
        return idmovimentoCaixa;
    }

    public void setIdmovimentoCaixa(Integer idmovimentoCaixa) {
        this.idmovimentoCaixa = idmovimentoCaixa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Float getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Float valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public Float getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(Float valorSaida) {
        this.valorSaida = valorSaida;
    }

    public String getUsuarioLancamento() {
        return usuarioLancamento;
    }

    public void setUsuarioLancamento(String usuarioLancamento) {
        this.usuarioLancamento = usuarioLancamento;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmovimentoCaixa != null ? idmovimentoCaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentocaixa)) {
            return false;
        }
        Movimentocaixa other = (Movimentocaixa) object;
        if ((this.idmovimentoCaixa == null && other.idmovimentoCaixa != null) || (this.idmovimentoCaixa != null && !this.idmovimentoCaixa.equals(other.idmovimentoCaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Movimentocaixa[ idmovimentoCaixa=" + idmovimentoCaixa + " ]";
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }   
    
}
