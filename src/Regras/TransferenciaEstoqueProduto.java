/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import model.Estoque;
import model.Tranfereciaproduto;

/**
 *
 * @author Wolverine
 */
public class TransferenciaEstoqueProduto {
    
      private Tranfereciaproduto transferenciaProduto;
      private Estoque estoque;
      private boolean excluido;

    public TransferenciaEstoqueProduto() {
        this.transferenciaProduto = new Tranfereciaproduto();
        this.estoque = new Estoque();
        excluido = false;
    }
    
    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Tranfereciaproduto getTransferenciaProduto() {
        return transferenciaProduto;
    }

    public void setTransferenciaProduto(Tranfereciaproduto transferenciaProduto) {
        this.transferenciaProduto = transferenciaProduto;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    
      
    
}
