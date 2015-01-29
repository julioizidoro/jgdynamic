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
@Table(name = "produto")
public class Produto implements Serializable {
    @Column(name =     "dataPedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @Column(name = "codigoNovo")
    private Integer codigoNovo;
    @Column(name = "precoFixo")
    private Integer precoFixo;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Integer idProduto;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "unidade")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ipi")
    private Double ipi;
    @Column(name = "mva")
    private Double mva;
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "referencia")
    private Integer referencia;
    @Column(name = "codigoBarras")
    private String codigoBarras;
    @Column(name = "sincronizado")
    private int sincronizado;
    @Column(name = "percentualComissao")
    private double percentualComissao;
    @Column(name = "aliquota_idaliquota")
    private int aliquota;
    @Column(name = "subgrupoproduto_idsubGrupoProduto")
    private int subgrupoproduto;


    public Produto() {
        setSincronizado(0);
    }
    
    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setpercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getIpi() {
        return ipi;
    }

    public void setIpi(Double ipi) {
        this.ipi = ipi;
    }

    public Double getMva() {
        return mva;
    }

    public int getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(int sincronizado) {
        this.sincronizado = sincronizado;
    }

    public void setMva(Double mva) {
        this.mva = mva;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getAliquota() {
        return aliquota;
    }

    public void setAliquota(int aliquota) {
        this.aliquota = aliquota;
    }

    public int getSubgrupoproduto() {
        return subgrupoproduto;
    }

    public void setSubgrupoproduto(int subgrupoproduto) {
        this.subgrupoproduto = subgrupoproduto;
    }


    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ idProduto=" + idProduto + " ]";
    }

    public Integer getCodigoNovo() {
        return codigoNovo;
    }

    public void setCodigoNovo(Integer codigoNovo) {
        this.codigoNovo = codigoNovo;
    }

    public Integer getPrecoFixo() {
        return precoFixo;
    }

    public void setPrecoFixo(Integer precoFixo) {
        this.precoFixo = precoFixo;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }


}
