/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasPagar;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class ContaMesTableModel extends AbstractTableModel{
    
    private List<ContaMes> listaMes;
    private String[] colunas ={"Mês/Ano" , "Valor Pagar"};

    public ContaMesTableModel(List<ContaMes> listaMes) {
        this.listaMes = listaMes;
    }

    public int getRowCount() {
        return this.listaMes.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaMes.get(rowIndex).getMes();
        } else {
            return Formatacao.foramtarDoubleString(listaMes.get(rowIndex).getValor());
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return String.class;
         }else return String.class;
    }
    
}
