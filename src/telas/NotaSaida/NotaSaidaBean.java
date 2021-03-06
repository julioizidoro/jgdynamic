/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida;

import telas.NotaSaida.Fatura.FaturaBean;
import java.util.Date;
import java.util.List;

/**
 *
 * @author wolverine
 */
public class NotaSaidaBean {
    
    private String naturezaOperacao;
    private String modelo;
    private String serie1;
    private String codigo;
    private String nuemro;
    private String serie2;
    private Date dataEmissao;
    private Date dataSaida;
    private String horaSaida;
    private String tipo;
    private String formaPagamento;
    private String finalidade;
    private List<NotaSaidaProdutoBean> listaProdutos;
    private double totalBaseICMS;
    private double totalValorICMS;
    private double totalValoProdutos;
    private double valorNota;
    private double valorDesconto;
    private String infoCampo;
    private String infoTexto;
    private Date dataEmissaoCupomFiscal;
    private String numeroOrdemECF;
    private String numeroCOO;
    private double totalTributiosFederal;
    private double totalTributiosEstadual;
    private FaturaBean fatura;
    private double percentualDesconto;
    private String codigoMunicipio;
    private int codigoCliente;
    private int codigoFornecedor;
    private double despesasacessorias;
    private String numeroSerieECF;
    

    public NotaSaidaBean() {
        this.codigoCliente=0;
        this.codigoFornecedor=0;
        this.codigoMunicipio = "0";
        this.numeroCOO="0";
        this.numeroOrdemECF="001";
    }
   
    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public void setNaturezaOperacao(String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie1() {
        return serie1;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setSerie1(String serie1) {
        this.serie1 = serie1;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getTotalTributiosFederal() {
        return totalTributiosFederal;
    }

    public void setTotalTributiosFederal(double totalTributiosFederal) {
        this.totalTributiosFederal = totalTributiosFederal;
    }

    public double getTotalTributiosEstadual() {
        return totalTributiosEstadual;
    }

    public void setTotalTributiosEstadual(double totalTributiosEstadual) {
        this.totalTributiosEstadual = totalTributiosEstadual;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Date getDataEmissaoCupomFiscal() {
        return dataEmissaoCupomFiscal;
    }

    public void setDataEmissaoCupomFiscal(Date dataEmissaoCupomFiscal) {
        this.dataEmissaoCupomFiscal = dataEmissaoCupomFiscal;
    }

    public String getNumeroOrdemECF() {
        return numeroOrdemECF;
    }

    public void setNumeroOrdemECF(String numeroOrdemECF) {
        this.numeroOrdemECF = numeroOrdemECF;
    }

    public String getNumeroCOO() {
        return numeroCOO;
    }

    public void setNumeroCOO(String numeroCOO) {
        this.numeroCOO = numeroCOO;
    }

    public String getNuemro() {
        return nuemro;
    }

    public void setNuemro(String nuemro) {
        this.nuemro = nuemro;
    }

    public String getSerie2() {
        return serie2;
    }

    public void setSerie2(String serie2) {
        this.serie2 = serie2;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public FaturaBean getFatura() {
        return fatura;
    }

    public void setFatura(FaturaBean fatura) {
        this.fatura = fatura;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(int codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    
    public List<NotaSaidaProdutoBean> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<NotaSaidaProdutoBean> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public double getTotalBaseICMS() {
        return totalBaseICMS;
    }

    public void setTotalBaseICMS(double totalBaseICMS) {
        this.totalBaseICMS = totalBaseICMS;
    }

    public double getTotalValorICMS() {
        return totalValorICMS;
    }

    public void setTotalValorICMS(double totalValorICMS) {
        this.totalValorICMS = totalValorICMS;
    }

    public double getTotalValoProdutos() {
        return totalValoProdutos;
    }

    public void setTotalValoProdutos(double totalValoProdutos) {
        this.totalValoProdutos = totalValoProdutos;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }

    public String getInfoCampo() {
        return infoCampo;
    }

    public void setInfoCampo(String infoCampo) {
        this.infoCampo = infoCampo;
    }

    public String getInfoTexto() {
        return infoTexto;
    }

    public void setInfoTexto(String infoTexto) {
        this.infoTexto = infoTexto;
    }

    public double getDespesasacessorias() {
        return despesasacessorias;
    }

    public void setDespesasacessorias(double despesasacessorias) {
        this.despesasacessorias = despesasacessorias;
    }
    
    
    
}
