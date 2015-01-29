/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Cliente;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clientedocumentos;

/**
 *
 * @author wolverine
 */
public class ConsultaDocumentoClienteTableModel  extends AbstractTableModel{
    
    private List<Clientedocumentos> listaDocumentos;
    private String[] colunas = {"Arquivo"};

    public ConsultaDocumentoClienteTableModel(List<Clientedocumentos> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public int getRowCount() {
        return listaDocumentos.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaDocumentos.get(rowIndex).getNomeDocumento();
        }else return "";
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
