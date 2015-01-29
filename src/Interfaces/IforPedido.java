/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import model.Fornecedor;
import model.Produto;

/**
 *
 * @author Wolverine
 */
public interface IforPedido {
    
    public void fecharForProduto();
    public void vincularProduto(Produto produto);
    public void quantidadePedido(double quantidade, String fabricante, Double embalagem, int linha, double valorCusto);
    public void vincularNovoFornecedor(Fornecedor fornecedor);
    
}
