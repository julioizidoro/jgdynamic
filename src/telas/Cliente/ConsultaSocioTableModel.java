/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Cliente;

import model.Clientesocios;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class ConsultaSocioTableModel extends AbstractTableModel{
    
    private List<Clientesocios> listaClienteSocios;
    private String[] colunas ={"Nome", "Nº CPF", "Tipo Sócio"};

    public ConsultaSocioTableModel(List<Clientesocios> listaClienteSocios) {
        this.listaClienteSocios = listaClienteSocios;
    }

    public int getRowCount() {
        return listaClienteSocios.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaClienteSocios.get(rowIndex).getNome();
        }else if (columnIndex==1){
            return listaClienteSocios.get(rowIndex).getCpf();
        }else return listaClienteSocios.get(rowIndex).getTipoSocio();
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
