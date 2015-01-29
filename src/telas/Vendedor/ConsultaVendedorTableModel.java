/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Vendedor;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Vendedor;

/**
 *
 * @author Wolverine
 */
public class ConsultaVendedorTableModel extends AbstractTableModel{
    
    private List<Vendedor> listaVendedor;
    private String[] colunas = {"Nome Completo", "Situação"};

    public ConsultaVendedorTableModel(List<Vendedor> listaVendedor) {
        this.listaVendedor = listaVendedor;
    }

    public int getRowCount() {
        return listaVendedor.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaVendedor.get(rowIndex).getNomeCompleto();
        }else return listaVendedor.get(rowIndex).getSituacao();
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