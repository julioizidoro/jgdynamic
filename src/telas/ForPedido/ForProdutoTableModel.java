/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ForPedido;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Forproduto;


/**
 *
 * @author Wolverine
 */
public class ForProdutoTableModel extends AbstractTableModel {

    private List<Forproduto> listaForProduto;
    private String[] colunas = {"Código", "Descrição", "Unidade", "Estoque", "Valor Venda" , "Ultima Venda",
                               "Valor Compra", "Ultima Compra", "Chegada", "Embalagem", "Fabricante", "Pedido"};

    public ForProdutoTableModel(List<Forproduto> listaForProduto) {
        this.listaForProduto = listaForProduto;
    }
    
    public int getRowCount() {
        return this.listaForProduto.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return this.listaForProduto.get(rowIndex).getReferencia();
        }else if (columnIndex==1){
            return this.listaForProduto.get(rowIndex).getDescricao();
        }else if (columnIndex==2){
            return this.listaForProduto.get(rowIndex).getUnidade();
        }else if (columnIndex==3){
            return Formatacao.foramtarQuantidade(listaForProduto.get(rowIndex).getQuantidadeEstoque());
        }else if (columnIndex==4){
            return Formatacao.foramtarDoubleString(listaForProduto.get(rowIndex).getValorVenda());
        }else if (columnIndex==5){
            return Formatacao.foramtarDoubleString(listaForProduto.get(rowIndex).getQuantidadeUltimaVenda());
        }else if (columnIndex==6){
            return Formatacao.foramtarDoubleString(listaForProduto.get(rowIndex).getValorCompra());
        }else if (columnIndex==7){
            return listaForProduto.get(rowIndex).getDataUltimaCompra();
        } else if (columnIndex==8){
            if (listaForProduto.get(rowIndex).getDataChegada()==null){
                return " ";
            }else if (listaForProduto.get(rowIndex).getDataChegada().after(new Date())){
                return Formatacao.ConvercaoDataPadrao(listaForProduto.get(rowIndex).getDataChegada());
            }else return " ";
        }else if (columnIndex==9){
            return Formatacao.foramtarDoubleString(listaForProduto.get(rowIndex).getEmbalagem());
        }else if (columnIndex==10){
            return this.listaForProduto.get(rowIndex).getCodigoFabricante();
        }else return this.listaForProduto.get(rowIndex).getPedido();
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
             return String.class;
         }else if (columnIndex==6){
             return String.class;
         }else if (columnIndex==7){
             return Date.class;
         }else if (columnIndex==8){
             return String.class;
         }else if (columnIndex==9){
             return String.class;
         }else if (columnIndex==10){
             return String.class;
         }else return String.class;
    }
}
