/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida;

import model.Produto;

/**NewClass
 *
 * @author wolverine
 */
public class NotaSaidaProdutoBean {
    
    private Produto produto;
    private String cfop;
    private double quantidade;
    private double valorUnitario;
    private double valortotal;
    private double  valorDesconto;
    private double percDesconto;
    private String cst;
    private double valorTributoFederal;
    private double percentualTributoFederal;
    private double valorTributoEstadual;
    private double percentualTributoEstadual;
    private String situacao;
    private double valoracessorios;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTributoFederal() {
        return valorTributoFederal;
    }

    public void setValorTributoFederal(double valorTributoFederal) {
        this.valorTributoFederal = valorTributoFederal;
    }

    public double getPercentualTributoFederal() {
        return percentualTributoFederal;
    }

    public void setPercentualTributoFederal(double percentualTributoFederal) {
        this.percentualTributoFederal = percentualTributoFederal;
    }

    public double getValorTributoEstadual() {
        return valorTributoEstadual;
    }

    public void setValorTributoEstadual(double valorTributoEstadual) {
        this.valorTributoEstadual = valorTributoEstadual;
    }

    public double getPercentualTributoEstadual() {
        return percentualTributoEstadual;
    }

    public void setPercentualTributoEstadual(double percentualTributoEstadual) {
        this.percentualTributoEstadual = percentualTributoEstadual;
    }

    

    public double getPercDesconto() {
        return percDesconto;
    }

    public void setPercDesconto(double percDesconto) {
        this.percDesconto = percDesconto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getValoracessorios() {
        return valoracessorios;
    }

    public void setValoracessorios(double valoracessorios) {
        this.valoracessorios = valoracessorios;
    }
    
    
    
    
    
}
