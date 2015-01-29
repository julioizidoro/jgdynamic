/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Fechamento;

import Regras.Formatacao;
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
    private String[] colunas = {"Hora", "Nº Item", "Valor Venda", "Valor Desconto"};

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
            return this.listaVenda.get(rowIndex).getHora();
        }else if (columnIndex==1){
            return this.listaVenda.get(rowIndex).getNumeroItem();
        }else if (columnIndex==2){
            return Formatacao.foramtarFloatString(this.listaVenda.get(rowIndex).getValorVenda());
        }else return  Formatacao.foramtarFloatString(this.listaVenda.get(rowIndex).getValorDesconto());
    }
    
     @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return Timer.class;
         }else if (columnIndex==1){
             return  Integer.class;
         }else if (columnIndex==2){
             return String.class;
         }else  return String.class;
    }

    
}
