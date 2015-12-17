/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Encerramento;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Encerramento;



/**
 *
 * @author wolverine
 */
public class ConsultaEncerramentoTableModel extends AbstractTableModel {

    private List<Encerramento> lista;
    private String[] colunas ={"Ano", "Data", "Hora", "Usuário"};

    public ConsultaEncerramentoTableModel(List<Encerramento> lista) {
        this.lista = lista;
    }

    public int getRowCount() {
        return lista.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if (columnIndex==0){
            return lista.get(rowIndex).getAno();
        }else if (columnIndex==1){
            return lista.get(rowIndex).getData();
        }else if (columnIndex==2){
            return lista.get(rowIndex).getHora();
        }else return lista.get(rowIndex).getUsuario();
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
            return Date.class;
         }else if (columnIndex==2){
             return  String.class;
         }else return String.class;
    }
}
