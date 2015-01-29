/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Fechamento;

import Regras.Formatacao;
import Regras.ProdutoController;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;
import model.Saida;


/**
 *
 * @author Wolverine
 */
public class SaidaFechamentoTableModel extends AbstractTableModel {

    private List<Saida> listaSaida;
    private String[] colunas = {"Código", "Descrição", "Quantidade", "Valor Venda"};

    
    public SaidaFechamentoTableModel(List<Saida> listaSaida) {
        this.listaSaida = listaSaida;
    }
    
    public int getRowCount() {
        return listaSaida.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = localizarProduto(listaSaida.get(rowIndex).getProduto());
        if (columnIndex==0){
            return produto.getReferencia();
        }else if (columnIndex==1){
            return produto.getDescricao();
        }else if (columnIndex==2){
            return Formatacao.foramtarDoubleString(this.listaSaida.get(rowIndex).getQuantidade());
        }else return  Formatacao.foramtarFloatString(this.listaSaida.get(rowIndex).getValorVenda());
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
         }else  return String.class;
    }
    
    public Produto localizarProduto(int idProduto){
        ProdutoController produtoController = new ProdutoController();
        return produtoController.consultarProdutoid(idProduto);
    }

    
}
