/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.NotaSaida;

import Regras.FormaPagamentoController;
import Regras.VendedorController;
import facade.FormaPagamentoFacade;
import facade.VendedorFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Terminalcliente;

/**
 *
 * @author Woverine
 */
public class TerminalVendasTableModel extends AbstractTableModel{
        
    public List<Terminalcliente> listaCliente;
    private String[] colunas = {"Nome", "Forma Pagto", "Vendedor", "Valor Total"};

    public TerminalVendasTableModel() {
        this.listaCliente = new ArrayList<Terminalcliente>();
    }

    public TerminalVendasTableModel(List<Terminalcliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public int getRowCount() {
        return listaCliente.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Terminalcliente terminalCliente = listaCliente.get(rowIndex);
        if (columnIndex == 0) {
            return terminalCliente.getNome();
        } else if (columnIndex == 1) {
            return buscarFormaPagamento(terminalCliente.getFormapagamento());
        } else if (columnIndex == 2) {
            return buscarVendedor(terminalCliente.getVendedor());
        } else {
            return terminalCliente.getValorCompra();
        }
    }

    public  void adicionar(Terminalcliente terminalCliente){
        this.listaCliente.add(terminalCliente);
    }

    public void adicionar(List<Terminalcliente> listaClientes){
        this.listaCliente = listaClientes;
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
         }else return Float.class;
    }

    public Terminalcliente getProdutoVenda(int linha){
        return  listaCliente.get(linha);
    }
    
    public String buscarVendedor(int idVendedor){
        VendedorController vendedorController = new VendedorController();
        String nome = vendedorController.consultarVendedorId(idVendedor).getNome();
        return nome;        
    }
    
    public String buscarFormaPagamento(int idFormaPagamento){
        FormaPagamentoController formaPagamentoController = new FormaPagamentoController();
        String descricao = formaPagamentoController.getFormaPagamento(idFormaPagamento).getDescricao();
        return descricao;
    }

}
