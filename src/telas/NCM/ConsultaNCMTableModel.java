/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NCM;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cest;

/**
 *
 * @author Wolverine
 */
public class ConsultaNCMTableModel extends AbstractTableModel{
    
    private List<Cest> listaNCM;
    private String[] colunas ={"CEST", "NCM", "Descrição"};

    public ConsultaNCMTableModel(List<Cest> listaNCM) {
        this.listaNCM = listaNCM;
    }

    public int getRowCount() {
        return listaNCM.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaNCM.get(rowIndex).getCest();
        }else if (columnIndex==1){
            return listaNCM.get(rowIndex).getNcm();
        }else return listaNCM.get(rowIndex).getDescricao();
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return String.class;
        } else if (columnIndex==1){
            return String.class;
         }else return String.class;
    }
    
}
