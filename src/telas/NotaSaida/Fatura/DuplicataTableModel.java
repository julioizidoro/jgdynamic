/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida.Fatura;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class DuplicataTableModel extends AbstractTableModel{
    
    private List<DuplicataBean> listaDuplicatas;
    private String[] colunas = {"Nº Duplicata", "Data Vencimento", "Valor Duplicata"};

    public DuplicataTableModel(List<DuplicataBean> listaDuplicatas) {
        this.listaDuplicatas = listaDuplicatas;
    }

    public int getRowCount() {
        return listaDuplicatas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaDuplicatas.get(rowIndex).getNumero();
        }else if (columnIndex==1){
            return listaDuplicatas.get(rowIndex).getDataVencimento();
        }else return Formatacao.foramtarFloatString(listaDuplicatas.get(rowIndex).getValor());
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        } else if (columnIndex==1){
            return Date.class;
        }else return String.class;
    }
    
    
    
    
    
}
