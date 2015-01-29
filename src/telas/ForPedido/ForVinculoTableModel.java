/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ForPedido;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Wolverine
 */
public class ForVinculoTableModel extends AbstractTableModel {

    private List<ForVinculo> listaForVinculo;
    private String[] colunas = {"Código", "Razão Social", "Valor Custo", "Valor Compra", "Valor Frete" , "Prazo Entrega",
                               "Data Compra", "Embalagem", "Frabricante", "Pedido"};

    public ForVinculoTableModel(List<ForVinculo> listaForVinculo) {
        this.listaForVinculo = listaForVinculo;
    }
    
    public int getRowCount() {
        return this.listaForVinculo.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return this.listaForVinculo.get(rowIndex).getIdFornecedor();
        }else if (columnIndex==1){
            return this.listaForVinculo.get(rowIndex).getRazaoSocial();
        }else if (columnIndex==2){
            return Formatacao.foramtarDoubleString(this.listaForVinculo.get(rowIndex).getValorCusto());
        }else if (columnIndex==3){
            return Formatacao.foramtarQuantidade(this.listaForVinculo.get(rowIndex).getValorCompra());
        }else if (columnIndex==4){
            return Formatacao.foramtarDoubleString(listaForVinculo.get(rowIndex).getValorFrete());
        }else if (columnIndex==5){
            return this.listaForVinculo.get(rowIndex).getPrazoEntrega();
        }else if (columnIndex==6){
            return this.listaForVinculo.get(rowIndex).getDataCompra();
        }else if (columnIndex==7){
            return Formatacao.foramtarDoubleString(listaForVinculo.get(rowIndex).getEmbalagem());
        }else if (columnIndex==8){
            return this.listaForVinculo.get(rowIndex).getCodigoFabricante();
        }else return this.listaForVinculo.get(rowIndex).getPedido();
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
         }else if (columnIndex==2){
             return String.class;
         }else if (columnIndex==3){
             return String.class;
         } else if (columnIndex==4){
             return String.class;
         }else if (columnIndex==5){
             return Integer.class;
         }else if (columnIndex==6){
             return Date.class;
         }else if (columnIndex==7){
             return String.class;
         }else if (columnIndex==8){
             return String.class;
         }else return String.class;
    }
}
