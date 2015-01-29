/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ControleCheques;

import java.util.List;
import model.Cliente;
import model.Contaspagar;
import model.Fornecedor;
import model.Planoconta;

/**
 *
 * @author wolverine
 */
public interface ItelaControleCheque {
    
    void consultarPlanoContas(Planoconta planoConta);
    void conultarContasPagar(List<Contaspagar> listaPagamento);
    void consultarFornecedor(Fornecedor fornecedor);
    void consultarCliente(Cliente cliente);
    void carregarModelCheque();
    
}
