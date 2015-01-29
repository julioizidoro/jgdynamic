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
 * @author wolverine
 */
public class PagamentoTableModel extends AbstractTableModel{
    
    private List<Contaspagar> listaContasPagar;
    private String[] colunas ={"Nº Documento", "Credor", "Data Vencimento", "Valor Pagar"};

    public PagamentoTableModel(List<Contaspagar> listaContasPagar) {
        this.listaContasPagar = listaContasPagar;
    }

    public int getRowCount() {
        return listaContasPagar.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaContasPagar.get(rowIndex).getNumeroDocumento();
        }else if (columnIndex==1){
            return listaContasPagar.get(rowIndex).getCredor();
        }else if (columnIndex==2){
            return listaContasPagar.get(rowIndex).getDataVencimento();
        }else if (listaContasPagar.get(rowIndex).getValorParcial()>0){
                return Formatacao.foramtarDoubleString(listaContasPagar.get(rowIndex).getValorParcial());
              }else return Formatacao.foramtarDoubleString(listaContasPagar.get(rowIndex).getValorConta());
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
             return Date.class;
         }else return String.class;
    }
    
}
