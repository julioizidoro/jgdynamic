/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.TransferenciaSaida;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author wolverine
 */
public class ConsultaTransferenciaSaidaProdutoTableModel extends AbstractTableModel {

    private List<TransferenciaProdutoProcesso> listaProduto;
    private String[] colunas ={"Código", "Descrição", "Unidade", "Quantidade", "Valor Unitario"};

    public ConsultaTransferenciaSaidaProdutoTableModel(List<TransferenciaProdutoProcesso> listaProduto) {
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
            return listaProduto.get(rowIndex).getProduto().getReferencia();
        }else if (columnIndex==1){
            return listaProduto.get(rowIndex).getProduto().getDescricao();
        }else if (columnIndex==2){
            return listaProduto.get(rowIndex).getProduto().getUnidade();
        }else if (columnIndex==3){
            return Formatacao.foramtarQuantidade(listaProduto.get(rowIndex).getTransferenciaProduto().getQuantidade());
        }else return Formatacao.foramtarDoubleString(listaProduto.get(rowIndex).getTransferenciaProduto().getValorTotal());

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

}
