/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida.Fatura;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class FaturaTableModel extends AbstractTableModel{
    
    private List<FaturaBean> listaFatura;
    private String[] colunas = {"Nº Fatura", "Valor Original", "Valor Desconto", "Valor Líquido"};

    public FaturaTableModel(List<FaturaBean> listaFatura) {
        this.listaFatura = listaFatura;
    }

    public int getRowCount() {
        return listaFatura.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaFatura.get(rowIndex).getNumero();
        }else if (columnIndex==1){
            return Formatacao.foramtarFloatString(listaFatura.get(rowIndex).getValorOrigianl());
        }else if (columnIndex==2){
            return Formatacao.foramtarFloatString(listaFatura.get(rowIndex).getValorDesconto());
        }else return Formatacao.foramtarFloatString(listaFatura.get(rowIndex).getValorLiquido());
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        } else if (columnIndex==1){
            return Date.class;
        }else if (columnIndex==2){
            return String.class ;
        }else return String.class;
    }
    
}
