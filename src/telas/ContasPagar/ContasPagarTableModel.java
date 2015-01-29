/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasPagar;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Contaspagar;

/**
 *
 * @author Wolverine
 */
public class ContasPagarTableModel extends AbstractTableModel{
    
    private List<Contaspagar> listaContasPagar;
    private String[] colunas ={"Nº Documento", "Data Lançamento", "Credor", "Data Vencimento", "Valor Pagar", "Forma Pagto", "Entregue", "Pagto"};

    public ContasPagarTableModel(List<Contaspagar> listaContasPagar) {
        this.listaContasPagar = listaContasPagar;
    }

    public int getRowCount() {
        return this.listaContasPagar.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaContasPagar.get(rowIndex).getNumeroDocumento();
        }else if (columnIndex==1){
            return listaContasPagar.get(rowIndex).getDataLancamento();
        }else if (columnIndex==2){
            return listaContasPagar.get(rowIndex).getCredor();
        }else if (columnIndex==3){
            return listaContasPagar.get(rowIndex).getDataVencimento();
        }else if (columnIndex==4){
            return Formatacao.foramtarDoubleString(listaContasPagar.get(rowIndex).getValorConta());
        }else if (columnIndex==5){
            return listaContasPagar.get(rowIndex).getTipoPagamento();
        }else if (columnIndex==6){
            if (listaContasPagar.get(rowIndex).getBoletoEntregue()==0){
                return "NAO";
            }else return "SIM";
        }else {
            if (listaContasPagar.get(rowIndex).getPagamento()==null){
                return "";
            }else return listaContasPagar.get(rowIndex).getPagamento();
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
         }else if (columnIndex==1){
             return  Date.class;
         }else if (columnIndex==2){
             return String.class;
         }else if (columnIndex==3){
             return Date.class;
         }else if (columnIndex==4){
             return String.class;
         }else if (columnIndex==5){
             return String.class;
         }else if (columnIndex==6){
             return String.class;
         }else return String.class;
    }
    
    

    
}
