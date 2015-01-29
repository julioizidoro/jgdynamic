/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Entrada;

import Regras.EntradaProdutoController;
import Regras.FornecedorController;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Docentrada;
import model.Fornecedor;
import model.Nfentrada;







/**
 *
 * @author wolverine
 */
public class SituacaoEntradaTableModel extends AbstractTableModel {

    private List<Docentrada> listaEntrada;
    private String[] colunas ={"Código","Fornecedor", "Nº Nota Fsical", "Data Registro", "Situação"};

    public SituacaoEntradaTableModel(List<Docentrada> listaEntrada) {
        this.listaEntrada = listaEntrada;
    }

    public int getRowCount() {
        return listaEntrada.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaEntrada.get(rowIndex).getFornecedor();
        }else if (columnIndex==1){
                return localizarFornecedor(listaEntrada.get(rowIndex).getFornecedor()).getRazaoSocial();
        }else if (columnIndex==2){
                    return localizarNotaFiscal(listaEntrada.get(rowIndex).getIdDocEntrada()).getNumero();     
        }else if (columnIndex==3){
            return listaEntrada.get(rowIndex).getDataEntrada();
        }else return listaEntrada.get(rowIndex).getSituacao();
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
             return Date.class;
         }else return String.class;
    }
    
     public Fornecedor localizarFornecedor(int idFornecedor){
        FornecedorController fornecedorController = new FornecedorController();
        return fornecedorController.consultarFornecedor(idFornecedor);
    }
    
    public Nfentrada localizarNotaFiscal(int idNfentrada){
        EntradaProdutoController entradaProdutoController = new EntradaProdutoController();
        return entradaProdutoController.consultarNotaFiscalEntrada(idNfentrada);
    }

}
