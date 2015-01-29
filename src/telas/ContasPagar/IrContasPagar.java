/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasPagar;

import model.Fornecedor;
import model.Planoconta;

/**
 *
 * @author Wolverine
 */
public interface IrContasPagar {
    
    public void cosultarPlanoContas(Planoconta planoContas);
    public void consultarFornecedor(Fornecedor fornecedor);
    public void exportarExcel(String caminho, String nomeArquivo); 
    
}
