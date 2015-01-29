/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.VendasPrazo;

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
    
    private List<Contasreceberpagamento> listaPagamento;
    private String[] colunas = {"Data Pagto", "Valor Pago", "Fechamento"};

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
        }else if (columnIndex==1){
            return Formatacao.foramtarDoubleString(listaPagamento.get(rowIndex).getValorRecebido());
        }else return listaPagamento.get(rowIndex).getFechacaixa();
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
             return String.class;
         }else return Integer.class;
    }
    
    
    
}
