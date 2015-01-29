/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.PrevisaoFinanceira;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wolverine
 */
public class PosicaoFinanceiraTableModel extends AbstractTableModel{
    
    public List<PosicaoFinanceira> listaPosicaoFinanceira;
    private String[] colunas = {"Data", "Contas a Pagar", "Cheques Pré" , "CEF Cartão", "CEF Cheques", "CEF Boletos", "BB Cartão", "BB Cheques", "BB Boletos"};

    public PosicaoFinanceiraTableModel(List<PosicaoFinanceira> listaPosicaoFinanceira) {
        this.listaPosicaoFinanceira = listaPosicaoFinanceira;
    }

    public int getRowCount() {
        return listaPosicaoFinanceira.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaPosicaoFinanceira.get(rowIndex).getData();
        }else if (columnIndex==1){
            return Formatacao.foramtarFloatString(listaPosicaoFinanceira.get(rowIndex).getContasPagar());
        }else if (columnIndex==2){
            return Formatacao.foramtarFloatString(listaPosicaoFinanceira.get(rowIndex).getChequePre());
        }else if (columnIndex==3){
            return Formatacao.foramtarFloatString(listaPosicaoFinanceira.get(rowIndex).getCaixaCartao());
        }else if (columnIndex==4){
            return Formatacao.foramtarFloatString(listaPosicaoFinanceira.get(rowIndex).getCaixaMoviemnto());
        }else if(columnIndex==5){
            return Formatacao.foramtarFloatString(listaPosicaoFinanceira.get(rowIndex).getCaixaContasReceber());
        }else if (columnIndex==6){
            return Formatacao.foramtarFloatString(listaPosicaoFinanceira.get(rowIndex).getBbCartao());
        }else if (columnIndex==7){
            return Formatacao.foramtarFloatString(listaPosicaoFinanceira.get(rowIndex).getBbMoviemnto());
        }else return Formatacao.foramtarFloatString(listaPosicaoFinanceira.get(rowIndex).getBbContasReceber());
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Date.class;
        } else if (columnIndex==1){
            return String.class;
        }else if (columnIndex==2){
            return String.class;
        }else if (columnIndex==3){
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
