/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Devolucao.Defeito;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import view.Viewdevolucaodefeitoproduto;

/**
 *
 * @author Wolverine
 */
public class DevolucaoDefeitoTableModel extends AbstractTableModel{
    
    private List<Viewdevolucaodefeitoproduto> listaDevolucao;
    private String[] colunas ={"No. Devolução", "Código Produto", "Descrição", "Data Devolução", "Valor R$", "Vendedor"};

    public DevolucaoDefeitoTableModel(List<Viewdevolucaodefeitoproduto> listaDevolucao) {
        this.listaDevolucao = listaDevolucao;
    }

    public int getRowCount() {
        return listaDevolucao.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaDevolucao.get(rowIndex).getIddevolucaodefeito();
        }else if (columnIndex==1){
            return listaDevolucao.get(rowIndex).getReferencia();
        }else if (columnIndex==2){
            return listaDevolucao.get(rowIndex).getDescricao();
        }else if (columnIndex==3){
            return listaDevolucao.get(rowIndex).getDataDevolucao();
        }else if (columnIndex==4){
            return Formatacao.foramtarFloatString(listaDevolucao.get(rowIndex).getValorProduto());
        }else return listaDevolucao.get(rowIndex).getNome();
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
            return String.class;
        }else if (columnIndex==3){
            return Date.class;
        }else if (columnIndex==4){
            return String.class;
        }else return String.class;
    }
    
    
    
    
}
