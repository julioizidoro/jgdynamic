/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Cliente;

import Regras.UsuariosController;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clientehistorico;

/**
 *
 * @author Wolverine
 */
public class ConsultaHistoricoTableModel extends AbstractTableModel{
    
    private List<Clientehistorico> listaHistorico;
    private String[] colunas ={"Data", "Histórico", "Usuário"};

    public ConsultaHistoricoTableModel(List<Clientehistorico> listaHistorico) {
        this.listaHistorico = listaHistorico;
    }

    public int getRowCount() {
        return this.listaHistorico.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaHistorico.get(rowIndex).getData();
        }else if (columnIndex==1){
            return listaHistorico.get(rowIndex).getDescricao();
        }else return getNomeUusario(listaHistorico.get(rowIndex).getUsuarios());
    }
    
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return Date.class;
         }else if (columnIndex==1){
             return  String.class;
         }else return String.class;
    }
    
    public String getNomeUusario(int idUsuario){
        UsuariosController usuariosController = new UsuariosController();
        return usuariosController.consultarUsuario(idUsuario).getNome();
    }
    
}
