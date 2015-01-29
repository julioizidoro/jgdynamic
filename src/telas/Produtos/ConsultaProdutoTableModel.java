/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Produtos;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import view.Viewconsultaprodutoestoque;



/**
 *
 * @author wolverine
 */
public class ConsultaProdutoTableModel extends AbstractTableModel {

    private List<Viewconsultaprodutoestoque> listaProduto;
    private String[] colunas ={"Código", "Novo", "Descrição", "Unidade", "Qtd Minima", "Qtd Estoque", "Valor Venda", "Ultima Venda", "Ultima Compra"};

    public ConsultaProdutoTableModel(List<Viewconsultaprodutoestoque> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public int getRowCount() {
        return listaProduto.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if (columnIndex==0){
            return listaProduto.get(rowIndex).getReferencia();
        }else if (columnIndex==1){
            return listaProduto.get(rowIndex).getCodigonovo();
        }else if (columnIndex==2){
            return listaProduto.get(rowIndex).getDescricao();
        }else if (columnIndex==3){
            return listaProduto.get(rowIndex).getUnidade();
        }else if (columnIndex==4){
            return Formatacao.foramtarQuantidade(listaProduto.get(rowIndex).getQuantidadeMinima());
        }else if (columnIndex==5){
            return Formatacao.foramtarQuantidade(listaProduto.get(rowIndex).getQuantidadeEstoque());
        }else if (columnIndex==6){
            return Formatacao.foramtarFloatString(listaProduto.get(rowIndex).getValorVenda());
        }else if (columnIndex==7){
            if (listaProduto.get(rowIndex).getDataVenda()!=null){
                return Formatacao.ConvercaoDataPadrao(listaProduto.get(rowIndex).getDataVenda());
            }else return "";            
        }else {
            if (listaProduto.get(rowIndex).getDataCompra()!=null){
                return Formatacao.ConvercaoDataPadrao(listaProduto.get(rowIndex).getDataCompra());
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
        } else if (columnIndex==1){
            return Integer.class;
         }else if (columnIndex==2){
             return  String.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return Long.class;
         }else if (columnIndex==5){
             return Long.class;
         }else if (columnIndex==6){
             return Float.class;
         }else if (columnIndex==7){
             return String.class;
         }else return String.class;
    }

}
