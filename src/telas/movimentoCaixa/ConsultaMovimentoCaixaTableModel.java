/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.movimentoCaixa;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Movimentocaixa;

/**
 *
 * @author Acer
 */
public class ConsultaMovimentoCaixaTableModel extends AbstractTableModel{

   private List<Movimentocaixa> listaMovimentocaixa;
   private String[] colunas ={"Nº Lançamento", "Data", "Histórico", "Valor Entrada", "Valor Saída"};

    public ConsultaMovimentoCaixaTableModel(List<Movimentocaixa> listaMovimentocaixa) {
        this.listaMovimentocaixa = listaMovimentocaixa;
    }

    public int getRowCount() {
        return listaMovimentocaixa.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
         Movimentocaixa movimentoCaixa = listaMovimentocaixa.get(rowIndex);
         if (columnIndex==0){
             return movimentoCaixa.getIdmovimentoCaixa();
         }else if (columnIndex==1){
             return  movimentoCaixa.getDataMovimento();
         }else if (columnIndex==2){
             return movimentoCaixa.getDescricao();
         }else if (columnIndex==3){
             return movimentoCaixa.getValorEntrada();
         }else return movimentoCaixa.getValorSaida();
    }

    public  void adiciona(Movimentocaixa movimentoCaixa){
        listaMovimentocaixa.add(movimentoCaixa);
    }

    public void adiciona(Collection<Movimentocaixa> movimentoCaixa){
        listaMovimentocaixa.addAll(movimentoCaixa);
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return Integer.class;
         }else if (columnIndex==1){
             return  Date.class;
         }else if (columnIndex==2){
             return String.class;
         }else if (columnIndex==3){
             return Double.class;
         }else return Double.class;
    }

    public Movimentocaixa getMovimentocaixa(int linha){
        return  listaMovimentocaixa.get(linha);
    }

}
