/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import java.util.ArrayList;
import java.util.List;
import model.Transferencia;

/**
 *
 * @author Wolverine
 */
public class TransferenciaEstoque {
    
    private Transferencia transferencia;
    private List<TransferenciaEstoqueProduto> listaTransferenciaProduto;

    public TransferenciaEstoque() {
        this.transferencia = new Transferencia();
        this.listaTransferenciaProduto = new ArrayList<TransferenciaEstoqueProduto>();
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public List<TransferenciaEstoqueProduto> getListaTransferenciaProduto() {
        return listaTransferenciaProduto;
    }

    public void setListaTransferenciaProduto(List<TransferenciaEstoqueProduto> listaTransferenciaProduto) {
        this.listaTransferenciaProduto = listaTransferenciaProduto;
    }
    
}
