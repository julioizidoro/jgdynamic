/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Cliente;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clienteautorizados;

/**
 *
 * @author Wolverine
 */
public class ConsultaAutorizadoTableModel extends AbstractTableModel{
    
    private List<Clienteautorizados> listaAutorizados;
    private String[] colunas ={"Nome", "Nº RG", "Fone Celular"};

    public ConsultaAutorizadoTableModel(List<Clienteautorizados> listaAutorizados) {
        this.listaAutorizados = listaAutorizados;
    }

    public int getRowCount() {
        return listaAutorizados.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaAutorizados.get(rowIndex).getNome();
        }else if (columnIndex==1){
            return listaAutorizados.get(rowIndex).getRg();
        }else return listaAutorizados.get(rowIndex).getFoneCelular();
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
             return  String.class;
         }else return String.class;
    }
}
