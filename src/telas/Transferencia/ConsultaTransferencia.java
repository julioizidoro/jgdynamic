/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Transferencia;

import model.Transferencia;
import java.util.ArrayList;
import model.Produto;
import java.util.List;


/**
 *
 * @author Wolverine
 */
public class ConsultaTransferencia {
    
    private Transferencia transferencia;
    private List<consultaTransferenciaProduto> listaTransferenciaProduto;

    public ConsultaTransferencia() {
        this.listaTransferenciaProduto = new ArrayList<consultaTransferenciaProduto>();
        transferencia = new Transferencia();
    }
    
    

    public List<consultaTransferenciaProduto> getListaTransferenciaProduto() {
        return listaTransferenciaProduto;
    }

    public void setListaTransferenciaProduto(List<consultaTransferenciaProduto> listaTransferenciaProduto) {
        this.listaTransferenciaProduto = listaTransferenciaProduto;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }
    
    
    
    
}
