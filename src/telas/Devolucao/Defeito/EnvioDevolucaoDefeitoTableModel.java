/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Devolucao.Defeito;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class EnvioDevolucaoDefeitoTableModel extends AbstractTableModel{
    
    private List<EnvioDevolucaoDefeitoBean> listaEnvio;
    private String[] colunas ={"No. Devolução", "Código Produto", "Descrição", "Valor R$"};

    public EnvioDevolucaoDefeitoTableModel(List<EnvioDevolucaoDefeitoBean> listaEnvio) {
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
            return listaEnvio.get(rowIndex).getIdDevolucaoDefeito();
        }else if (columnIndex==1){
            return listaEnvio.get(rowIndex).getReferencia();
        }else if (columnIndex==2){
            return listaEnvio.get(rowIndex).getDescricao();
        }else return Formatacao.foramtarFloatString(listaEnvio.get(rowIndex).getValor());
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
