/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasPagar;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class FormaPagamentoTableModel1 extends AbstractTableModel{
    
    private List<FormaPagamento> listaFormaPagamento;
    private String[] colunas ={"Forma Pagamento" , "Valor Pago"};

    public FormaPagamentoTableModel1(List<FormaPagamento> listaFormaPagamentos) {
        this.listaFormaPagamento = listaFormaPagamentos;
    }

    public int getRowCount() {
        return this.listaFormaPagamento.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaFormaPagamento.get(rowIndex).getDescricao();
        } else {
            return Formatacao.foramtarDoubleString(listaFormaPagamento.get(rowIndex).getValor());
        }
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
