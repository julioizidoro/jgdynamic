/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.VendasPrazo;


import java.util.Date;
import java.util.List;
import java.util.Timer;
import javax.swing.table.AbstractTableModel;
import model.Venda;

/**
 *
 * @author Wolverine
 */
public class VendaFechamentoTableModel extends AbstractTableModel {

    private List<Venda> listaVenda;
    private String[] colunas = {"Data Venda", "Hora", "Nº Item", "Valor Venda", "Valor Desconto", "Fechamento"};

    public VendaFechamentoTableModel(List<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }
    
    public int getRowCount() {
        return listaVenda.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaVenda.get(rowIndex).getDataVenda();
        }else if (columnIndex==1){
            return this.listaVenda.get(rowIndex).getHora();
        }else if (columnIndex==2){
            return this.listaVenda.get(rowIndex).getNumeroItem();
        }else if (columnIndex==3){
            return this.listaVenda.get(rowIndex).getValorVenda();
        }else if (columnIndex==4){
            return this.listaVenda.get(rowIndex).getValorDesconto();
        }else return  this.listaVenda.get(rowIndex).getFechacaixa();
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
            return Date.class;
        }else if (columnIndex==1){
             return Timer.class;
         }else if (columnIndex==2){
             return  Integer.class;
         }else if (columnIndex==3){
             return Float.class;
         }else if (columnIndex==4){
             return Float.class;
         }else  return Integer.class;
    }

    
}
