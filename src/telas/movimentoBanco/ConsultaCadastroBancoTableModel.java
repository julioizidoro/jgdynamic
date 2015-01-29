/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.movimentoBanco;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Banco;

/**
 *
 * @author Acer
 */
public class ConsultaCadastroBancoTableModel extends AbstractTableModel{

   private List<Banco> listaBanco;
   private String[] colunas ={"Nº Banco", "Agencia", "Nome Agencia", "Nº Conta", "Telefone"};

    public ConsultaCadastroBancoTableModel(List<Banco> listaBanco) {
        this.listaBanco = listaBanco;
    }

    public int getRowCount() {
        return listaBanco.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
         Banco banco = listaBanco.get(rowIndex);
         if (columnIndex==0){
             return banco.getCodigoBanco();
         }else if (columnIndex==1){
             return  banco.getNumeroAgencia();
         }else if (columnIndex==2){
             return banco.getNomeAgencia();
         }else if (columnIndex==3){
             return banco.getNuneroConta();
         }else return banco.getTelefoneAgencia();
    }

    public  void adiciona(Banco banco){
        listaBanco.add(banco);
    }

    public void adiciona(Collection<Banco> banco){
        listaBanco.addAll(banco);
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
             return String.class;
         }else if (columnIndex==3){
             return String.class;
         }else return String.class;
    }

    public Banco getBanco(int linha){
        return  listaBanco.get(linha);
    }

}
