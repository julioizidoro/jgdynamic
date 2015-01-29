/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Devolucao.Defeito;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import view.Viewdevolucaodefeitoproduto;

/**
 *
 * @author Wolverine
 */
public class EnviadasDevolucaoDefeitoTableModel extends AbstractTableModel{
    
    private List<Viewdevolucaodefeitoproduto> listaEnvio;
    private String[] colunas ={"No. Devolução", "Código Produto", "Descrição", "Valor R$"};

    public EnviadasDevolucaoDefeitoTableModel(List<Viewdevolucaodefeitoproduto> listaEnvio) {
        this.listaEnvio = listaEnvio;
    }

    public int getRowCount() {
        return listaEnvio.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaEnvio.get(rowIndex).getIddevolucaodefeito();
        }else if (columnIndex==1){
            return listaEnvio.get(rowIndex).getReferencia();
        }else if (columnIndex==2){
            return listaEnvio.get(rowIndex).getDescricao();
        }else return Formatacao.foramtarFloatString(listaEnvio.get(rowIndex).getValorProduto());
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
        }else return String.class;
    }
    
    
    
    
}
