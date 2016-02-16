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
@Table(name = "venda")
public class Venda implements Serializable {
    @Column(name = "valorVenda2")
    private Float valorVenda2;
    @Column(name = "percentualDesconto")
    private Float percentualDesconto;
    @Column(name = "valorImpostofederal")
    private double valorImpostofederal;
    @Column(name = "aliquotaImpostofederal")
    private double aliquotaImpostofederal;
    @Column(name = "valorimpostoestadual")
    private double valorimpostoestadual;
    @Column(name = "aliquotaimpostoestadual")
    private double aliquotaimpostoestadual;
    @Column(name =     "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Column(name =     "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvenda")
    private Integer idvenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorVenda")
    private Float valorVenda;
    @Column(name = "numeroItem")
    private Integer numeroItem;
    @Column(name = "valorCompra")
    private Float valorCompra;
    @Column(name = "caixa")
    private String caixa;
    @Column(name = "CondicaoPagamento")
    private String CondicaoPagamento;
    @Column(name = "operador")
    private String operador;
    @Column(name = "valorDesconto")
    private Float valorDesconto;
    @Column(name = "valorAcrescimo")
    private Float valorAcrescimo;
    @Basic(optional = false)
    @Column(name = "numeroECF")
    private String numeroECF;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "EmissorECF_idEmissorECF")
    private int emissorecf;
    @Column(name = "vendedor_idvendedor")
    private int vendedor;
    @Column(name = "fechacaixa_idfechaCaixa")
    private int fechacaixa;

    public Venda() {
    }

    public Venda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public Venda(Integer idvenda, String numeroECF) {
        this.idvenda = idvenda;
        this.numeroECF = numeroECF;
    }

    public Integer getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public int getEmissorecf() {
        return emissorecf;
    }

    public void setEmissorecf(int emissorecf) {
        this.emissorecf = emissorecf;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getFechacaixa() {
        return fechacaixa;
    }

    public void setFechacaixa(int fechacaixa) {
        this.fechacaixa = fechacaixa;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public String getCondicaoPagamento() {
        return CondicaoPagamento;
    }

    public void setCondicaoPagamento(String CondicaoPagamento) {
        this.CondicaoPagamento = CondicaoPagamento;
    }

    public Float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        this.numeroItem = numeroItem;
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
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

    public Float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Float getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(Float valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public String getNumeroECF() {
        return numeroECF;
    }

    public void setNumeroECF(String numeroECF) {
        this.numeroECF = numeroECF;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvenda != null ? idvenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idvenda == null && other.idvenda != null) || (this.idvenda != null && !this.idvenda.equals(other.idvenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Venda[ idvenda=" + idvenda + " ]";
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Float getValorVenda2() {
        return valorVenda2;
    }

    public void setValorVenda2(Float valorVenda2) {
        this.valorVenda2 = valorVenda2;
    }

    public Float getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(Float percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public double getValorImpostofederal() {
        return valorImpostofederal;
    }

    public void setValorImpostofederal(double valorImpostofederal) {
        this.valorImpostofederal = valorImpostofederal;
    }

    public double getAliquotaImpostofederal() {
        return aliquotaImpostofederal;
    }

    public void setAliquotaImpostofederal(double aliquotaImpostofederal) {
        this.aliquotaImpostofederal = aliquotaImpostofederal;
    }

    public double getValorimpostoestadual() {
        return valorimpostoestadual;
    }

    public void setValorimpostoestadual(double valorimpostoestadual) {
        this.valorimpostoestadual = valorimpostoestadual;
    }

    public double getAliquotaimpostoestadual() {
        return aliquotaimpostoestadual;
    }

    public void setAliquotaimpostoestadual(double aliquotaimpostoestadual) {
        this.aliquotaimpostoestadual = aliquotaimpostoestadual;
    }



}
