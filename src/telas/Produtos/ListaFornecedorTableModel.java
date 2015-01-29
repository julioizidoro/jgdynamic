/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Produtos;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class ListaFornecedorTableModel extends AbstractTableModel {

    private List<ListaFornecedorProduto> listaVinculos;
    private String[] colunas ={"Código", "Razão Social", "Código Fabricante", "Data Compra", "Valor Compra"};

    public ListaFornecedorTableModel(List<ListaFornecedorProduto> listaVinculos) {
        this.listaVinculos = listaVinculos;
    }

        
    public int getRowCount() {
        return listaVinculos.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaVinculos.get(rowIndex).getCodigo();
        }else if (columnIndex==1){
            return listaVinculos.get(rowIndex).getRazaoSocial();
        }else if (columnIndex==2){
            return listaVinculos.get(rowIndex).getCodigoFabricante();
        }else if (columnIndex==3){
            return listaVinculos.get(rowIndex).getDataCompra();
        }else return Formatacao.foramtarDoubleString(listaVinculos.get(rowIndex).getValorCompra());
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
             return Date.class;
         }else return String.class;
    }
}
