/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.EncerramentoFacade;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Encerramento;
import model.Inventario;

/**
 *
 * @author Wolverine
 */
public class EncerramentoController {
    
    private EncerramentoFacade encerramentoFacade;
    
    public Encerramento salvar(Encerramento encerramento) {
        encerramentoFacade = new EncerramentoFacade();
        try {
            return encerramentoFacade.salvar(encerramento);
        } catch (SQLException ex) {
            Logger.getLogger(EncerramentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Eror Salvar Encerramento " + ex);
            return null;
        }
    }
    
    public List<Encerramento> listar() {
        encerramentoFacade = new EncerramentoFacade();
        try {
            return encerramentoFacade.listar();
        } catch (SQLException ex) {
            Logger.getLogger(EncerramentoController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void salvar(Inventario inventario){
        encerramentoFacade = new EncerramentoFacade();
        try {
            encerramentoFacade.salvar(inventario);
        } catch (SQLException ex) {
            Logger.getLogger(EncerramentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Inventário " + ex);
        }
    }
    
    public List<Inventario> listar(int idEncerramento){
        encerramentoFacade = new EncerramentoFacade();
        try {
            return encerramentoFacade.listar(idEncerramento);
        } catch (SQLException ex) {
            Logger.getLogger(EncerramentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Inventário " + ex);
            return null;
        }
    }
    
    public ResultSet ExportarInventario(String nomeRelatorio, int idEncerramento)  {
        encerramentoFacade = new EncerramentoFacade();
        try {
            return encerramentoFacade.ExportarInventario(nomeRelatorio, idEncerramento);
        } catch (IOException ex) {
            Logger.getLogger(EncerramentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Exportar Inventário " + ex);
            return null;
        }
    }
    
    
    
}
