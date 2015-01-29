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
@Table(name = "contaspagar")
public class Contaspagar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontasPagar")
    private Integer idcontasPagar;
    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    @Column(name = "dataLancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "dataReal")
    @Temporal(TemporalType.DATE)
    private Date dataReal;
    @Column(name = "credor")
    private String credor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorConta")
    private Double valorConta;
    @Column(name = "valorParcial")
    private Double valorParcial;
    @Column(name = "tipoPagamento")
    private String tipoPagamento;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "idFornecedor")
    private Integer idFornecedor;
    @Column(name = "boletoEntregue")
    private Integer boletoEntregue;
    @Column(name = "mes")
    private String mes;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "pagamentoContasPagar_idpagamentoContasPagar")
    private int pagamentocontaspagar;
    @Column(name = "planoconta_idplanoconta")
    private int planoconta;
    @Column(name = "pagamento")
    private String pagamento;
    @Column(name = "futura")
    private String futura;

    public Contaspagar() {
    }

    public Contaspagar(Integer idcontasPagar) {
        this.idcontasPagar = idcontasPagar;
    }

    public Integer getIdcontasPagar() {
        return idcontasPagar;
    }

    public void setIdcontasPagar(Integer idcontasPagar) {
        this.idcontasPagar = idcontasPagar;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
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

    public Double getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(Double valorParcial) {
        this.valorParcial = valorParcial;
    }

    public Date getDataReal() {
        return dataReal;
    }

    public Integer getBoletoEntregue() {
        return boletoEntregue;
    }

    public void setBoletoEntregue(Integer boletoEntregue) {
        this.boletoEntregue = boletoEntregue;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setDataReal(Date dataReal) {
        this.dataReal = dataReal;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getPagamentocontaspagar() {
        return pagamentocontaspagar;
    }

    public void setPagamentocontaspagar(int pagamentocontaspagar) {
        this.pagamentocontaspagar = pagamentocontaspagar;
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
        hash += (idcontasPagar != null ? idcontasPagar.hashCode() : 0);
        return hash;
    }

    public String getFutura() {
        return futura;
    }

    public void setFutura(String futura) {
        this.futura = futura;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contaspagar)) {
            return false;
        }
        Contaspagar other = (Contaspagar) object;
        if ((this.idcontasPagar == null && other.idcontasPagar != null) || (this.idcontasPagar != null && !this.idcontasPagar.equals(other.idcontasPagar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contaspagar[ idcontasPagar=" + idcontasPagar + " ]";
    }
    
}
