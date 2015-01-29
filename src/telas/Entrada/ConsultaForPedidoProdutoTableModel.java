/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Entrada;

import Regras.ForPedidoController;
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
 * @author wolverine
 */
public class ConsultaForPedidoProdutoTableModel extends AbstractTableModel {

    private List<Forpedproduto> listaProduto;
    private String[] colunas ={"Código", "Descrição", "Unidade", "Quantidade", "Cód Fabricante", "Entrada"};
    private int idEmpresa;

    public ConsultaForPedidoProdutoTableModel(List<Forpedproduto> listaProduto, int idEmpresa) {
        this.listaProduto = listaProduto;
        this.idEmpresa = idEmpresa;
    }

    public int getRowCount() {
        return listaProduto.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = localizarProduto(listaProduto.get(rowIndex).getProduto());
        Vinculo vinculo = localizarVinculo(listaProduto.get(rowIndex).getForpedido(), produto.getIdProduto());
        if (columnIndex==0){
            return produto.getReferencia();
        }else if (columnIndex==1){
            return produto.getDescricao();
        }else if (columnIndex==2){
            return produto.getUnidade();
        }else  if (columnIndex==3){
            return listaProduto.get(rowIndex).getQuantidade();
        }else if (columnIndex==4){
            if(vinculo!=null){
                return vinculo.getCodigoFabricante();
            }else return "";
        }else return listaProduto.get(rowIndex).getEntrada();
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
         } else if (columnIndex==3){
             return Double.class;
         }else if (columnIndex==4){
             return String.class;
         }else return Integer.class;
    }
    
    
    public Vinculo localizarVinculo(int idForPedido, int idProduto){
        Forpedido forPedido = consultaPedido(idForPedido);
        VinculoController vinculoController = new VinculoController();
        return vinculoController.consultarVinculo(idProduto, forPedido.getEmpresa(), forPedido.getFornecedor());
    }
    
    public Produto localizarProduto(int idProduto){
        ProdutoController produtoController = new ProdutoController();
        return produtoController.consultarProdutoid(idProduto);
    }
    
    public Forpedido consultaPedido(int idPedido){
        ForPedidoController forPedidoController = new ForPedidoController();
        return forPedidoController.consultarForPedido(idPedido, idEmpresa);
    }


}
