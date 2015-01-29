/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber.Fechamento;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import view.ViewClienteFechamento;

/**
 *
 * @author wolverine
 */
public class FechamentoMesTableModel extends AbstractTableModel{
    
    List<ViewClienteFechamento> listaFechamento;
    private String[] colunas ={"Nome do Cliente", "Fone Fixo", "Fone Celular", "Valor da Conta", "Data Vencimento", "Valor Credito", "Valor Pagar",
                               "Dias Atraso", "Situação", "Tipo Fechamento", "Dia Pagamento", "Forma Pagto"};

    public FechamentoMesTableModel(List<ViewClienteFechamento> listaFechamento) {
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
            return listaFechamento.get(rowIndex).getNome();
        }else if (columnIndex==1){
            return listaFechamento.get(rowIndex).getFonefixo();
        }else if (columnIndex==2){
            return listaFechamento.get(rowIndex).getFoneCelular();
        }else if (columnIndex==3){
            return Formatacao.foramtarDoubleString(listaFechamento.get(rowIndex).getValorConta());
        }else if (columnIndex==4){
            return Formatacao.ConvercaoDataPadrao(listaFechamento.get(rowIndex).getDatavencimento());
        }else if (columnIndex==5){
            return Formatacao.foramtarDoubleString(listaFechamento.get(rowIndex).getValorCredito());
        }else if (columnIndex==6){
            return Formatacao.foramtarDoubleString(listaFechamento.get(rowIndex).getValorPagar());
        }else if (columnIndex==7){
            return listaFechamento.get(rowIndex).getDiasAtraso();
        }else if (columnIndex==8){
            return listaFechamento.get(rowIndex).getSituacao();
        }else if (columnIndex==9){
            return listaFechamento.get(rowIndex).getTipoFechamento();
        }if (columnIndex==10){
            return listaFechamento.get(rowIndex).getDiaPagamento();
        }else return listaFechamento.get(rowIndex).getFormaPagamento();
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
            return Integer.class;
        }else if (columnIndex==8){
            return String.class;
        }else if (columnIndex==9){
            return String.class;
        }if (columnIndex==10){
            return String.class;
        }else return String.class;
    }
}
