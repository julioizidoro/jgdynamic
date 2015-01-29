/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Entrada.nova;

import telas.Entrada.*;
import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.View.Viewentradaproduto;

/**
 *
 * @author wolverine
 */
public class EntradaProdutoTableModel extends AbstractTableModel{

    private List<Viewentradaproduto> listaEntrada;
    private String[] colunas ={"Código", "Descrição", "Unidade", "Quantidade", "Valor Unitário",
                                "Valor ICMS", "Valor ST", "Valor IPI", "Valor Custo", "Valor Total", "Preço"};

    public EntradaProdutoTableModel(List<Viewentradaproduto> listaEntrada) {
        this.listaEntrada = listaEntrada;
    }

    public int getRowCount() {
        return  listaEntrada.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
     if (columnIndex==0){
            return this.listaEntrada.get(rowIndex).getReferencia();
        }else if (columnIndex==1){
            return this.listaEntrada.get(rowIndex).getDescricao();
        }else if (columnIndex==2){
            return this.listaEntrada.get(rowIndex).getUnidade();
        }else if (columnIndex==3){
            return Formatacao.foramtarQuantidade(this.listaEntrada.get(rowIndex).getQuantidade());
        }else if (columnIndex==4){
            return Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getValorUnitario());
        }else if (columnIndex==5){
            return Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getValorICMS());
        }else if (columnIndex==6){
            return Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getValorST());
        }else if (columnIndex==7){
            return Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getValorIPI());
        }else if (columnIndex==8){
            return Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getValorCusto());
        }else if (columnIndex==9){
            return  Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getValorTotal());
        }else return this.listaEntrada.get(rowIndex).getPreco();
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
             return Double.class;
         }else if (columnIndex==4){
             return String.class;
         }else if (columnIndex==5){
             return String.class;
        }else if (columnIndex==6){
             return String.class;
        }else if (columnIndex==7){
             return String.class;
        }else if (columnIndex==8){
             return String.class;
        }else if (columnIndex==9){
             return String.class;
        }else return String.class;

}
}
