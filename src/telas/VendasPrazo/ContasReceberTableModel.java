/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.VendasPrazo;

import Regras.ClienteController;
import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;
import model.Contasreceber;

/**
 *
 * @author Wolverine
 */
public class ContasReceberTableModel extends AbstractTableModel{
    
    private List<Contasreceber> listaContas;
    private String[] colunas = {"Nº Documento", "Nome do Cliente", "Valor da Conta", "Fatura"};

    public ContasReceberTableModel(List<Contasreceber> listaContas) {
        this.listaContas = listaContas;
    }

    public int getRowCount() {
        return listaContas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaContas.get(rowIndex).getNumeroDocumento();
        }else if (columnIndex==1){
            return listaContas.get(rowIndex).getCliente().getNome();
        }else if (columnIndex==2){
            return Formatacao.foramtarDoubleString(listaContas.get(rowIndex).getValorConta());
        }else return listaContas.get(rowIndex).getNumeroFaturaGerada();
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
             return String.class;
         }else if (columnIndex==2){
             return  String.class;
         }else return String.class;
    }
}
