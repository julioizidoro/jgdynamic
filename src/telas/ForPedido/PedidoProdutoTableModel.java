/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ForPedido;

import Regras.ForPedidoController;
import Regras.Formatacao;
import Regras.ProdutoController;
import Regras.VinculoController;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Forpedido;
import model.Forpedproduto;
import model.Produto;
import model.Vinculo;

/**
 *
 * @author Wolverine
 */
public class PedidoProdutoTableModel extends AbstractTableModel {

    private List<Forpedproduto> listaPedidoProduto;
    private int idFornecedor;
    private String[] colunas = {"Código", "Descrição", "Unidade", "Quantidade", "Cod. Fabricante"};
    private int idEmpresa;

    public PedidoProdutoTableModel(List<Forpedproduto> listaPedidoProduto, int idEmpresa, int idFornecedor) {
        this.listaPedidoProduto = listaPedidoProduto;
        this.idEmpresa = idEmpresa;
        this.idFornecedor = idFornecedor;
    }
    
    public int getRowCount() {
        return this.listaPedidoProduto.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = localizarProduto(listaPedidoProduto.get(rowIndex).getProduto());
        if (columnIndex==0){
            return produto.getReferencia();
        }else if (columnIndex==1){
            return produto.getDescricao();
        }else if (columnIndex==2){
            return produto.getUnidade();
        }else if (columnIndex==3){
            return Formatacao.foramtarQuantidade(this.listaPedidoProduto.get(rowIndex).getQuantidade());
        }else {
            Vinculo vinculo = localizarVinculo(produto.getIdProduto(), idEmpresa, idFornecedor);
            if (vinculo!=null){
                return vinculo.getCodigoFabricante();
            }else return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return Integer.class;
         }else if (columnIndex==1){
             return  String.class;
         }else if (columnIndex==2){
             return String.class;
         }else if (columnIndex==3){
             return String.class;
         }else return String.class;
    }
    
    public Produto localizarProduto(int idProduto){
        ProdutoController produtoController = new ProdutoController();
        return produtoController.consultarProdutoid(idProduto);
    }
    
    public Vinculo localizarVinculo(int idProduto, int idEmpresa, int idFornecedor){
        VinculoController vinculoController = new VinculoController();
        return vinculoController.consultarVinculo(idProduto, idEmpresa, idFornecedor);
    }
    
     public Forpedido consultaPedido(int idPedido){
        ForPedidoController forPedidoController = new ForPedidoController();
        return forPedidoController.consultarForPedido(idPedido, idEmpresa);
    }
}
