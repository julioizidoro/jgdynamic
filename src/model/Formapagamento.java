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
@Table(name = "formapagamento")
public class Formapagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformaPagamento")
    private Integer idformaPagamento;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "localRegistro")
    private String localRegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "comissaoVista")
    private Double comissaoVista;
    @Column(name = "comissaoParcelado")
    private Double comissaoParcelado;
    @Column(name = "valor")
    private Float valor;
    @Column(name = "prazo")
    private Integer prazo;
    @Column(name = "numeroParcelas")
    private Integer numeroParcelas;
    @Column(name = "bandeirasCartao_idbandeirasCartao")
    private int bandeiraCartao;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "banco_idbanco")
    private int banco;
    @Column(name = "tipoControle")
    private String tipoControle;
    

    public Formapagamento() {
    }

    public Formapagamento(Integer idformaPagamento) {
        this.idformaPagamento = idformaPagamento;
    }

    public Integer getIdformaPagamento() {
        return idformaPagamento;
    }

    public void setIdformaPagamento(Integer idformaPagamento) {
        this.idformaPagamento = idformaPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoControle() {
        return tipoControle;
    }

    public void setTipoControle(String tipoControle) {
        this.tipoControle = tipoControle;
    }

    public String getLocalRegistro() {
        return localRegistro;
    }

    public void setLocalRegistro(String localRegistro) {
        this.localRegistro = localRegistro;
    }

    public Double getComissaoVista() {
        return comissaoVista;
    }

    public void setComissaoVista(Double comissaoVista) {
        this.comissaoVista = comissaoVista;
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

    public Double getComissaoParcelado() {
        return comissaoParcelado;
    }

    public void setComissaoParcelado(Double comissaoParcelado) {
        this.comissaoParcelado = comissaoParcelado;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public int getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(int bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformaPagamento != null ? idformaPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formapagamento)) {
            return false;
        }
        Formapagamento other = (Formapagamento) object;
        if ((this.idformaPagamento == null && other.idformaPagamento != null) || (this.idformaPagamento != null && !this.idformaPagamento.equals(other.idformaPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getIdformaPagamento() + " - " + getDescricao();
    }

}
