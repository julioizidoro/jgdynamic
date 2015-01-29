/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package table;

import beanController.NfDuplicatas;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author wolverine
 */
public class DuplicataTableModel extends AbstractTableModel{

    private List<NfDuplicatas> listaDuplicata;
    private String[] colunas ={"Número", "Data Vencimento", "Valor R$"};

    public DuplicataTableModel(List<NfDuplicatas> listaDuplicata) {
        this.listaDuplicata = listaDuplicata;
    }

    public int getRowCount() {
        return this.listaDuplicata.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return this.listaDuplicata.get(rowIndex).getNumero();
        }else if (columnIndex==1){
            return this.listaDuplicata.get(rowIndex).getDataVencimento();
        }else return listaDuplicata.get(rowIndex).getValor();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return String.class;
         }else if (columnIndex==1){
             return  Date.class;
         }else return Double.class;
    }



}
