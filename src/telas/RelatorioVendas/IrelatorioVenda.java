/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.RelatorioVendas;

import model.Produto;

/**
 *
 * @author Wolverine
 */
public interface IrelatorioVenda {
    
    public void gerarRelatorioProduto(Produto produto);
    public void gerarRelatorioFornecedor(int idFornecedor);
    public void gerarRelatorioGrupo(int idGrupo);
    
}
