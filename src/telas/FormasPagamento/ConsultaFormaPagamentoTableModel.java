/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.FormasPagamento;

import Regras.BandeiraCartaoController;
import telas.Fornecedor.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.BandeirasCartao;
import model.Formapagamento;
import model.Fornecedor;







/**
 *
 * @author wolverine
 */
public class ConsultaFormaPagamentoTableModel extends AbstractTableModel {

    private List<Formapagamento> listaFormaPagamento;
    private String[] colunas ={"Código", "Descrição", "Local Registro", "Bandeira"};

    public ConsultaFormaPagamentoTableModel(List<Formapagamento> listaFormaPagamento) {
        this.listaFormaPagamento = listaFormaPagamento;
    }

    public int getRowCount() {
        return listaFormaPagamento.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaFormaPagamento.get(rowIndex).getIdformaPagamento();
        }else if (columnIndex==1){
            return listaFormaPagamento.get(rowIndex).getDescricao();
        }else if (columnIndex==2){
            return listaFormaPagamento.get(rowIndex).getLocalRegistro();
        }else return carregarBandeiraCartao(listaFormaPagamento.get(rowIndex).getBandeiraCartao());
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
             return  String.class;
         }else return String.class;
    }
    
    public String carregarBandeiraCartao(int idBandeira){
        BandeiraCartaoController bandeiraCartaoController = new BandeiraCartaoController();
        BandeirasCartao bandeira = bandeiraCartaoController.pesquisarid(idBandeira);
        if (bandeira!=null){
            return bandeira.getNome();
        }else return "";
    }

}
