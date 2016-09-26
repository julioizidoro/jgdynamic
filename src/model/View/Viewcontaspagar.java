/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.View;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "viewcontaspagar")
public class Viewcontaspagar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idcontasPagar")
    @Id
    private int idcontasPagar;
    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    @Column(name = "dataLancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "credor")
    private String credor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorConta")
    private Double valorConta;
    @Column(name = "tipoPagamento")
    private String tipoPagamento;
    @Column(name = "idFornecedor")
    private Integer idFornecedor;
    @Basic(optional = false)
    @Column(name = "planoconta_idplanoconta")
    private int planocontaIdplanoconta;
    @Basic(optional = false)
    @Column(name = "pagamentoContasPagar_idpagamentoContasPagar")
    private int pagamentoContasPagaridpagamentoContasPagar;
    @Basic(optional = false)
    @Column(name = "empresa_idempresa")
    private int empresaIdempresa;
    @Column(name = "dataPagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @Column(name = "descontos")
    private Double descontos;
    @Column(name = "juros")
    private Double juros;
    @Column(name = "valorPago")
    private Double valorPago;

    public Viewcontaspagar() {
    }

    public int getIdcontasPagar() {
        return idcontasPagar;
    }

    public void setIdcontasPagar(int idcontasPagar) {
        this.idcontasPagar = idcontasPagar;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public Double getValorConta() {
        return valorConta;
    }

    public void setValorConta(Double valorConta) {
        this.valorConta = valorConta;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getPlanocontaIdplanoconta() {
        return planocontaIdplanoconta;
    }

    public void setPlanocontaIdplanoconta(int planocontaIdplanoconta) {
        this.planocontaIdplanoconta = planocontaIdplanoconta;
    }

    public int getPagamentoContasPagaridpagamentoContasPagar() {
        return pagamentoContasPagaridpagamentoContasPagar;
    }

    public void setPagamentoContasPagaridpagamentoContasPagar(int pagamentoContasPagaridpagamentoContasPagar) {
        this.pagamentoContasPagaridpagamentoContasPagar = pagamentoContasPagaridpagamentoContasPagar;
    }

    public int getEmpresaIdempresa() {
        return empresaIdempresa;
    }

    public void setEmpresaIdempresa(int empresaIdempresa) {
        this.empresaIdempresa = empresaIdempresa;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getDescontos() {
        return descontos;
    }

    public void setDescontos(Double descontos) {
        this.descontos = descontos;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }
    
}
