/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Fechamento;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Wolverine
 */
public class FechamentoTableModel extends AbstractTableModel {
    
    private List<SituacaoFechamento> listaFechamento;
    private String[] colunas = {"Descrição", "Valor R$"};

    public FechamentoTableModel(List<SituacaoFechamento> listaFechamento) {
        this.listaFechamento = listaFechamento;
    }

    public int getRowCount() {
        return listaFechamento.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaFechamento.get(rowIndex).getDescricao();
        }else return Formatacao.foramtarFloatString(listaFechamento.get(rowIndex).getValor());
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
