/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import telas.ContasReceber.FormaPagamento.CrFomaDiasBean;

/**
 *
 * @author Wolverine
 */
public class ContasReceberFormaPagamentoTableModel extends AbstractTableModel{
    
    private List<CrFomaDiasBean> listaForma;
    private String[] colunas ={"Data", "Dinheiro", "Cheque", "Cheque Pré", "Cartão Débito", "Cartão Crédito", "Sicob", "Créditos", "Total"};

    public ContasReceberFormaPagamentoTableModel(List<CrFomaDiasBean> listaForma) {
        this.listaForma = listaForma;
    }

    public int getRowCount() {
        return listaForma.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaForma.get(rowIndex).getData();
        }else if (columnIndex==1){
            return Formatacao.foramtarDoubleString(listaForma.get(rowIndex).getDineiro());
        }else if (columnIndex==2){
            return Formatacao.foramtarDoubleString(listaForma.get(rowIndex).getCheque());
        }else if (columnIndex==3){
            return Formatacao.foramtarDoubleString(listaForma.get(rowIndex).getChequePre());
        }else if (columnIndex==4){
            return Formatacao.foramtarDoubleString(listaForma.get(rowIndex).getCartaoDebito());
        }else if (columnIndex==5){
            return Formatacao.foramtarDoubleString(listaForma.get(rowIndex).getCartaoCredito());
        }else if (columnIndex==6){
            return Formatacao.foramtarDoubleString(listaForma.get(rowIndex).getSicob());
        }else if (columnIndex==7){
            return Formatacao.foramtarDoubleString(listaForma.get(rowIndex).getCreditoCliente());
        }else return Formatacao.foramtarDoubleString(listaForma.get(rowIndex).getTotal());
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
        }else if (columnIndex==2){
            return String.class;
        }else if (columnIndex==3) {
            return String.class;            
        }else if (columnIndex==4){ 
            return String.class;
        }else if (columnIndex==5){ 
            return String.class;
        }else if (columnIndex==6){ 
            return String.class;
        }else if (columnIndex==7){ 
            return String.class;
        }else return String.class;
    }
    
}
