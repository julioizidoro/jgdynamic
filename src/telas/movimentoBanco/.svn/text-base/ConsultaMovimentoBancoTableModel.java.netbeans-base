/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.movimentoBanco;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Movimentobanco;

/**
 *
 * @author Acer
 */
public class ConsultaMovimentoBancoTableModel extends AbstractTableModel{

   private List<Movimentobanco> listaMovimentoBanco;
   private String[] colunas ={"Nº Lançamento", "Data", "Histórico", "Valor Entrada", "Valor Saída"};

    public ConsultaMovimentoBancoTableModel(List<Movimentobanco> listaMovimentoBanco) {
        this.listaMovimentoBanco = listaMovimentoBanco;
    }

    public int getRowCount() {
        return listaMovimentoBanco.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
         Movimentobanco movimentoBanco = listaMovimentoBanco.get(rowIndex);
         if (columnIndex==0){
             return movimentoBanco.getIdmovimentoBanco();
         }else if (columnIndex==1){
             return  movimentoBanco.getDataMovimento();
         }else if (columnIndex==2){
             return movimentoBanco.getDescricao();
         }else if (columnIndex==3){
             return movimentoBanco.getValorEntrada();
         }else return movimentoBanco.getValorSaida();
    }

    public  void adiciona(Movimentobanco movimentoBanco){
        listaMovimentoBanco.add(movimentoBanco);
    }

    public void adiciona(Collection<Movimentobanco> movimentoBanco){
        listaMovimentoBanco.addAll(movimentoBanco);
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

    public Movimentobanco getMovimentobanco(int linha){
        return  listaMovimentoBanco.get(linha);
    }

}
