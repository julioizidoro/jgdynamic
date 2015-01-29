/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Transferencia;

import model.Estoque;
import model.Produto;
import model.Tranfereciaproduto;
import model.Transferencia;

/**
 *
 * @author Wolverine
 */
public class consultaTransferenciaProduto {
    
    private Tranfereciaproduto transTrasferenciaproduto;
    private Produto produto;
    private boolean excluir;
    private Estoque estoque;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Tranfereciaproduto getTransTrasferenciaproduto() {
        return transTrasferenciaproduto;
    }

    public void setTransTrasferenciaproduto(Tranfereciaproduto transTrasferenciaproduto) {
        this.transTrasferenciaproduto = transTrasferenciaproduto;
    }

    public boolean isExcluir() {
        return excluir;
    }

    public void setExcluir(boolean excluir) {
        this.excluir = excluir;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    
    
    
    
}
