/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.TransferenciaSaida;

import model.Produto;
import model.Saidatransferenciaproduto;

/**
 *
 * @author Wolverine
 */
public class TransferenciaProdutoProcesso {
    
    Saidatransferenciaproduto transferenciaProduto;
    Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Saidatransferenciaproduto getTransferenciaProduto() {
        return transferenciaProduto;
    }

    public void setTransferenciaProduto(Saidatransferenciaproduto transferenciaProduto) {
        this.transferenciaProduto = transferenciaProduto;
    }
            
}
