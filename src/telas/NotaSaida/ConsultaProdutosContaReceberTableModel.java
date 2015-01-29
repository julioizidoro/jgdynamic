/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida;

import telas.ContasReceber.*;
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
public class ConsultaProdutosContaReceberTableModel extends AbstractTableModel{
    
    private List<Saida> listaProdutos;
    private String[] colunas ={"código", "Descrição", "Unidade", "Quantidade", "Valor Total", "Devolvido"};

    public ConsultaProdutosContaReceberTableModel(List<Saida> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public int getRowCount() {
        return this.listaProdutos.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = getProduto(listaProdutos.get(rowIndex).getProduto());
        if (columnIndex==0){
            return produto.getReferencia();
        }else if (columnIndex==1){
                return produto.getDescricao();
        }else if (columnIndex==2){
           return produto.getUnidade();
        }else if (columnIndex==3){
            return Formatacao.foramtarQuantidade(listaProdutos.get(rowIndex).getQuantidade());
        }else if (columnIndex==4){
            return Formatacao.foramtarFloatString(listaProdutos.get(rowIndex).getValorVenda());
        }else return listaProdutos.get(rowIndex).getDevolvido();
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
         }else if (columnIndex==4){
             return String.class;
         }else return String.class;
    }
    
    public Produto getProduto(int idProduto){
        ProdutoController produtoController = new ProdutoController();
        Produto produto = produtoController.consultarProdutoid(idProduto);
        return produto;
    }
    
}
