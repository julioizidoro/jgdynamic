/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber;

import Regras.ProdutoController;
import model.Creditoreceberprodutos;
import model.Produto;

/**
 *
 * @author Wolverine
 */
public class CreditosProdutosBean {
    
    Produto produto;
    Creditoreceberprodutos creditoProdutos;

    public CreditosProdutosBean(Creditoreceberprodutos creditoProdutos) {
        this.creditoProdutos = creditoProdutos;
        localizarProduto();
    }
    
    

    public Creditoreceberprodutos getCreditoProdutos() {
        return creditoProdutos;
    }

    public void setCreditoProdutos(Creditoreceberprodutos creditoProdutos) {
        this.creditoProdutos = creditoProdutos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void localizarProduto(){
        ProdutoController produtoController = new ProdutoController();
        setProduto(produtoController.consultarProdutoid(creditoProdutos.getProduto()));
    }
    
    
    
}
