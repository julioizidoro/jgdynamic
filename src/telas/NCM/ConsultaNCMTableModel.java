/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NCM;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Ibpt;

/**
 *
 * @author Wolverine
 */
public class ConsultaNCMTableModel extends AbstractTableModel{
    
    private List<Ibpt> listaNCM;
    private String[] colunas ={"NCM", "Descrição", "Imposto"};

    public ConsultaNCMTableModel(List<Ibpt> listaNCM) {
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
            return listaNCM.get(rowIndex).getNcm();
        }else if (columnIndex==1){
            return listaNCM.get(rowIndex).getDescricao();
        }else return Formatacao.foramtarDoubleString(listaNCM.get(rowIndex).getAliquotaImposto());
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
