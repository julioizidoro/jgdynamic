/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import beanController.NotaEletronica;
import beanController.NfProdutos;
import beanController.NfDuplicatas;
import java.io.File;
import java.util.List;
import model.Banco;
import model.Estoque;
import model.Fornecedor;
import model.Produto;

/**
 *
 * @author Gabi
 */
public interface ItelaConsulta {
    void setData(Object objeto);
    void setBanco(Banco banco);
    void setModelProduto(Produto produto, Estoque estoque);
    void setNFe(List<NfProdutos> listaProdutos, List<NfDuplicatas> listaDuplicatas, NotaEletronica nota, Fornecedor fornecedor);
    void setAlterarValorVenda(Estoque estoque);
    void setFornecedor(Object objeto);
    void setForPedido(Object objeto);
    void setPlanoContas(Object objeto);
    void setCliente(Object objeto);
    void setProdutoXML(Produto produto);
    void setArquivo(File arquivo);
}
