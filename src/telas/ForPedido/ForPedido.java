/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ForPedido;

import java.util.ArrayList;
import java.util.List;
import model.Forpedido;
import model.Forpedproduto;

/**
 *
 * @author Wolverine
 */
public class ForPedido {
    
    private Forpedido forPedido;
    private List<Forpedproduto> listaPedidoProduto;
    private double totalPedido;

    public ForPedido() {
        forPedido = new Forpedido();
        forPedido.setRegistrado("NAO");
        listaPedidoProduto = new ArrayList<Forpedproduto>();
        totalPedido =0;
    }

    public Forpedido getForPedido() {
        return forPedido;
    }

    public void setForPedido(Forpedido forPedido) {
        this.forPedido = forPedido;
    }

    public List<Forpedproduto> getListaPedidoProduto() {
        return listaPedidoProduto;
    }

    public void setListaPedidoProduto(List<Forpedproduto> listaPedidoProduto) {
        this.listaPedidoProduto = listaPedidoProduto;
    }
    
    public void adicionarProduto(Forpedproduto forPedidoProduto){
        this.listaPedidoProduto.add(forPedidoProduto);
    }
    
    public void subtrairValorCusto(double valorCusto){
        this.totalPedido = this.totalPedido - valorCusto;
    }
    
    public void somarValorCusto(double valorCusto){
        this.totalPedido = this.totalPedido + valorCusto;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }
    
}
