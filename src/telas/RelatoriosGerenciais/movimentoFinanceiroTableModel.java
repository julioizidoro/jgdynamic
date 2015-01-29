/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.RelatoriosGerenciais;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class movimentoFinanceiroTableModel extends AbstractTableModel {

    private List<movimentoFinanceiro> listaMovimentoFinaceiro;
    private String[] colunas = {"Data", "Venda Vista", "Venda Prazo", "Cartão Crédito", "Cheque Pré", "Total Vendas", "Recebimento", "Credito", "Desconto", "Total Geral"};

    public movimentoFinanceiroTableModel(List<movimentoFinanceiro> listaMovimentoFinaceiro) {
        this.listaMovimentoFinaceiro = listaMovimentoFinaceiro;
    }

    public int getRowCount() {
        return listaMovimentoFinaceiro.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
                return Formatacao.ConvercaoDataPadrao(listaMovimentoFinaceiro.get(rowIndex).getData());
        }else if (columnIndex==1){
            return Formatacao.foramtarDoubleString(listaMovimentoFinaceiro.get(rowIndex).getVendaVista());
        }else if (columnIndex==2){
            return Formatacao.foramtarDoubleString(listaMovimentoFinaceiro.get(rowIndex).getVendaPrazo());
        }else if (columnIndex==3){
            return Formatacao.foramtarDoubleString(listaMovimentoFinaceiro.get(rowIndex).getCartaoCredito());
        }else if (columnIndex==4){
            return Formatacao.foramtarDoubleString(listaMovimentoFinaceiro.get(rowIndex).getChequePre());
        }else if (columnIndex==5){
            return Formatacao.foramtarDoubleString(listaMovimentoFinaceiro.get(rowIndex).getTotalVendas());
        }else if (columnIndex==6){
            return Formatacao.foramtarDoubleString(listaMovimentoFinaceiro.get(rowIndex).getRecebimentos());
        }else if (columnIndex==7){
            return Formatacao.foramtarDoubleString(listaMovimentoFinaceiro.get(rowIndex).getCredito());
        }else if (columnIndex==8){
            return Formatacao.foramtarDoubleString(listaMovimentoFinaceiro.get(rowIndex).getDesconto());
        }else return Formatacao.foramtarDoubleString(listaMovimentoFinaceiro.get(rowIndex).getTotalGeral());
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
         }else  if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return String.class;
         }else if (columnIndex==5){
             return String.class;
         }else if (columnIndex==6){
             return String.class;
         }else return String.class;
    }

    
}
