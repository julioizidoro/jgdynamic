/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Devolucao.Defeito;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import view.Viewdevolucaodefeitoenviadas;

/**
 *
 * @author Wolverine
 */
public class EnvioDevolucaoDefeitoEnviadasTableModel extends AbstractTableModel{
    
    private List<Viewdevolucaodefeitoenviadas> listaEnvio;
    private String[] colunas ={"Cod Fonrecedor", "Nome Fantasia"};

    public EnvioDevolucaoDefeitoEnviadasTableModel(List<Viewdevolucaodefeitoenviadas> listaEnvio) {
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
            return listaEnvio.get(rowIndex).getIdfornecedor();
        }else return listaEnvio.get(rowIndex).getNomeFantasia();
    }
    
     @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       if (columnIndex==0){
            return Integer.class;
        }else return String.class;
    }
}
