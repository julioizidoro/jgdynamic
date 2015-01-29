/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Regras;

import model.Produto;

/**
 *
 * @author Woverine
 */
public class ProdutoVenda {

    private int numeroItem;
    private Produto produto;
    private double quantidade;
    private float valorUnitario;
    private float valorTotal;

    public int getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(int numeroItem) {
        this.numeroItem = numeroItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
   
    
}
