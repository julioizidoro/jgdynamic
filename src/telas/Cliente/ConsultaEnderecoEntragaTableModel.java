/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Cliente;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clienteenderecoentrega;

/**
 *
 * @author Wolverine
 */
public class ConsultaEnderecoEntragaTableModel extends AbstractTableModel{
    
    private List<Clienteenderecoentrega> listaEntrega;
    private String[] colunas ={"Tipo logradouro", "Logradouro", "Número", "Complemento", "Bairro"};

    public ConsultaEnderecoEntragaTableModel(List<Clienteenderecoentrega> listaEntrega) {
        this.listaEntrega = listaEntrega;
    }

    public int getRowCount() {
        return listaEntrega.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaEntrega.get(rowIndex).getTipoLogradouro();
        }else if (columnIndex==1){
            return listaEntrega.get(rowIndex).getLogradouro();
        }else if (columnIndex==2){
            return listaEntrega.get(rowIndex).getNumero();
        }else if (columnIndex==3){
            return listaEntrega.get(rowIndex).getComplemento();
        }else return listaEntrega.get(rowIndex).getBairro();
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
         }else if (columnIndex==2){
             return String.class;
         }else if (columnIndex==3){
             return String.class;
         }else return String.class;
    }
    
}
