/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wolverine
 */
public class ListaProdutoSaidaBeanTableModel extends AbstractTableModel{
    
    private List<NotaSaidaProdutoBean> listaProdutoBean;
    private String[] colunas ={"Código", "Descrição", "Unidade", "NCM", "Quantidade", "Valor Unitário", "Valor Total"};

    public ListaProdutoSaidaBeanTableModel(List<NotaSaidaProdutoBean> listaProdutoBean) {
        this.listaProdutoBean = listaProdutoBean;
    }

    public int getRowCount() {
        return listaProdutoBean.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaProdutoBean.get(rowIndex).getProduto().getReferencia();
        }else if (columnIndex==1){
            return listaProdutoBean.get(rowIndex).getProduto().getDescricao();
        }else if (columnIndex==2){
            return listaProdutoBean.get(rowIndex).getProduto().getUnidade();
        }else if (columnIndex==3){
            return listaProdutoBean.get(rowIndex).getProduto().getNcm();
        }else if (columnIndex==4){
            return Formatacao.foramtarQuantidade(listaProdutoBean.get(rowIndex).getQuantidade());
        }else if (columnIndex==5){
            return Formatacao.foramtarDoubleString(listaProdutoBean.get(rowIndex).getValorUnitario());
        }else return Formatacao.foramtarDoubleString(listaProdutoBean.get(rowIndex).getValortotal());
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
            return String.class;
         }else if (columnIndex==2){
             return  String.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return String.class;
         }else if (columnIndex==5){
             return String.class;
         }else return String.class;
    }
    
    
    
}
