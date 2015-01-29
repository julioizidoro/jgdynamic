/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Fornecedor;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Fornecedor;







/**
 *
 * @author wolverine
 */
public class ConsultaFornecedorTableModel extends AbstractTableModel {

    private List<Fornecedor> listaFornecedor;
    private String[] colunas ={"Código", "Razão Social", "Nome Fantasia", "Fone Comercial", "Fone Fax", "Fone Celular"};

    public ConsultaFornecedorTableModel(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public int getRowCount() {
        return listaFornecedor.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaFornecedor.get(rowIndex).getIdfornecedor();
        }else if (columnIndex==1){
            return listaFornecedor.get(rowIndex).getRazaoSocial();
        }else if (columnIndex==2){
            return listaFornecedor.get(rowIndex).getNomeFantasia();
        }else if (columnIndex==3){
            return listaFornecedor.get(rowIndex).getTelefone();
        }else if (columnIndex==4){
            return listaFornecedor.get(rowIndex).getFax();
        }else return listaFornecedor.get(rowIndex).getCelular();

    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return Integer.class;
         }else if (columnIndex==1){
             return  String.class;
         }else if (columnIndex==2){
             return String.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return String.class;
         }else return String.class;
    }

}
