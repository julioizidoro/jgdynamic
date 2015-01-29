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
    private String cst;
    private double valorTributo;
    private double percentualTributo;

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

    public double getValorTributo() {
        return valorTributo;
    }

    public void setValorTributo(double valorTributo) {
        this.valorTributo = valorTributo;
    }

    public double getPercentualTributo() {
        return percentualTributo;
    }

    public void setPercentualTributo(double percentualTributo) {
        this.percentualTributo = percentualTributo;
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
    
    
    
    
    
}
