/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Contasreceberpagamento;

/**
 *
 * @author Wolverine
 */
public class PagamentoTableModel extends AbstractTableModel{
    
    List<Contasreceberpagamento> listaPagamento;
    private String[] colunas ={"Data Pagamento", "Valor Juros", "Valor Desconto", "Valor Recebido"};

    public PagamentoTableModel(List<Contasreceberpagamento> listaPagamento) {
        this.listaPagamento = listaPagamento;
    }

    public int getRowCount() {
        return listaPagamento.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaPagamento.get(rowIndex).getDataPagamento();
        }else if(columnIndex==1){
            return Formatacao.foramtarDoubleString(listaPagamento.get(rowIndex).getJuros());
        }else if(columnIndex==2){
            return Formatacao.foramtarDoubleString(listaPagamento.get(rowIndex).getDesconto());
        }else return Formatacao.foramtarDoubleString(listaPagamento.get(rowIndex).getValorRecebido());
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
             return  String.class;
         }else if (columnIndex==2){
             return String.class;
         }else return String.class;
    }
    
}
