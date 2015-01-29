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
@Table(name = "faturasreceber")
public class Faturasreceber implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFaturasReceber")
    private Integer idFaturasReceber;
    @Column(name = "numeroFatura")
    private String numeroFatura;
    @Column(name = "dataLancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "numeroParcelas")
    private Integer numeroParcelas;
    @Column(name = "numeroNotaFiscal")
    private String numeroNotaFiscal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorFatura")
    private Double valorFatura;
    @Column(name = "instrucoes")
    private String instrucoes;
    @Column(name = "dataParcela01")
    @Temporal(TemporalType.DATE)
    private Date dataParcela01;
    @Column(name = "valorParcela01")
    private double valorParcela01;
    @Column(name = "dataParcela02")
    @Temporal(TemporalType.DATE)
    private Date dataParcela02;
    @Column(name = "valorParcela02")
    private double valorParcela02;
    @Column(name = "dataParcela03")
    @Temporal(TemporalType.DATE)
    private Date dataParcela03;
    @Column(name = "valorParcela03")
    private double valorParcela03;
    @Column(name = "dataParcela04")
    @Temporal(TemporalType.DATE)
    private Date dataParcela04;
    @Column(name = "valorParcela04")
    private double valorParcela04;
    @Column(name = "dataDesconto")
    @Temporal(TemporalType.DATE)
    private Date dataDesconto;
    @Column(name = "valorDesconto")
    private double valorDesconto;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "contasreceberpagamento_idcontasReceberPagamento")
    private int contasreceberpagamento;
    @Column(name = "cliente_idcliente")
    private int cliente;
    @Column(name = "bancoPagamento")
    private int bancoPagamento;

    public int getBancoPagamento() {
        return bancoPagamento;
    }

    public void setBancoPagamento(int bancoPagamento) {
        this.bancoPagamento = bancoPagamento;
    }

    public Faturasreceber() {
    }

    public Faturasreceber(Integer idFaturasReceber) {
        this.idFaturasReceber = idFaturasReceber;
    }

    public Integer getIdFaturasReceber() {
        return idFaturasReceber;
    }

    public void setIdFaturasReceber(Integer idFaturasReceber) {
        this.idFaturasReceber = idFaturasReceber;
    }

    public String getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(String numeroFatura) {
        this.numeroFatura = numeroFatura;
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

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public String getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public Date getDataDesconto() {
        return dataDesconto;
    }

    public void setDataDesconto(Date dataDesconto) {
        this.dataDesconto = dataDesconto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public void setNumeroNotaFiscal(String numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public Double getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(Double valorFatura) {
        this.valorFatura = valorFatura;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getContasreceberpagamento() {
        return contasreceberpagamento;
    }

    public void setContasreceberpagamento(int contasreceberpagamento) {
        this.contasreceberpagamento = contasreceberpagamento;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public Date getDataParcela01() {
        return dataParcela01;
    }

    public void setDataParcela01(Date dataParcela01) {
        this.dataParcela01 = dataParcela01;
    }

    public Date getDataParcela02() {
        return dataParcela02;
    }

    public void setDataParcela02(Date dataParcela02) {
        this.dataParcela02 = dataParcela02;
    }

    public Date getDataParcela03() {
        return dataParcela03;
    }

    public void setDataParcela03(Date dataParcela03) {
        this.dataParcela03 = dataParcela03;
    }

    public Date getDataParcela04() {
        return dataParcela04;
    }

    public void setDataParcela04(Date dataParcela04) {
        this.dataParcela04 = dataParcela04;
    }

    public double getValorParcela01() {
        return valorParcela01;
    }

    public void setValorParcela01(double valorParcela01) {
        this.valorParcela01 = valorParcela01;
    }

    public double getValorParcela02() {
        return valorParcela02;
    }

    public void setValorParcela02(double valorParcela02) {
        this.valorParcela02 = valorParcela02;
    }

    public double getValorParcela03() {
        return valorParcela03;
    }

    public void setValorParcela03(double valorParcela03) {
        this.valorParcela03 = valorParcela03;
    }

    public double getValorParcela04() {
        return valorParcela04;
    }

    public void setValorParcela04(double valorParcela04) {
        this.valorParcela04 = valorParcela04;
    }

 


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFaturasReceber != null ? idFaturasReceber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faturasreceber)) {
            return false;
        }
        Faturasreceber other = (Faturasreceber) object;
        if ((this.idFaturasReceber == null && other.idFaturasReceber != null) || (this.idFaturasReceber != null && !this.idFaturasReceber.equals(other.idFaturasReceber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Faturasreceber[ idFaturasReceber=" + idFaturasReceber + " ]";
    }
    
}
