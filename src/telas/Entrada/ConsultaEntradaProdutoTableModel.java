/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Entrada;

import Regras.Formatacao;
import Regras.ProdutoController;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Entradaproduto;
import model.Produto;


/**
 *
 * @author wolverine
 */
public class ConsultaEntradaProdutoTableModel extends AbstractTableModel {

    private List<Entradaproduto> listaProduto;
    private String[] colunas ={"Código", "Novo", "Descrição", "Unidade", "Qtd Compra", "Valor Custo"};

    public ConsultaEntradaProdutoTableModel(List<Entradaproduto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public int getRowCount() {
        return listaProduto.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = localizarProduto(listaProduto.get(rowIndex).getProduto());
        if (columnIndex==0){
            return produto.getReferencia();
        }else if (columnIndex==1){
            return produto.getCodigoNovo();
        }else if (columnIndex==2){
            return produto.getDescricao();
        }else if (columnIndex==3){
            return produto.getUnidade();
        }else if (columnIndex==4){
            return Formatacao.foramtarQuantidade(listaProduto.get(rowIndex).getQuantidade());
        }else return Formatacao.foramtarFloatString(listaProduto.get(rowIndex).getValorTotalCusto());

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
             return Integer.class;
         }else if (columnIndex==2){
             return  String.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return String.class;
         }else return String.class;
    }
    
    public Produto localizarProduto(int idProduto){
        ProdutoController produtoController = new ProdutoController();
        return produtoController.consultarProdutoid(idProduto);
    }

}
