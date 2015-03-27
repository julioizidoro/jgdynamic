/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.NotaSaidaFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Notasaida;

/**
 *
 * @author wolverine
 */
public class NotaSaidaController {
    
    NotaSaidaFacade notaSaidaFacade;
    
    public List<Notasaida> consultarNotaSaida(String data) {
        notaSaidaFacade = new NotaSaidaFacade();
        try {
            return notaSaidaFacade.consultarNotaSaida(data);
        } catch (Exception ex) {
            Logger.getLogger(NotaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Nota Fiscal de Saída " + ex);
            return null;
        }
    }
    
    public Notasaida salvarNotaSaida(Notasaida notaSaida) {
        notaSaidaFacade = new NotaSaidaFacade();
        try {
            return notaSaidaFacade.salvarNotaSaida(notaSaida);
        } catch (Exception ex) {
            Logger.getLogger(NotaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Nota Fiscal de Saída " + ex);
            return null;
        }
    }
    
    public int consultarUltimaNotaEmitida() {
        notaSaidaFacade = new NotaSaidaFacade();
        try {
            return notaSaidaFacade.consultarUltimaNotaEmitida();
        } catch (SQLException ex) {
            Logger.getLogger(NotaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Numero NF-e " + ex);
            return 0;
        }
    }
    
    public List<Notasaida> consultarNotaSaida(String dataInicial, String dataFinal) {
        notaSaidaFacade = new NotaSaidaFacade();
        try {
            return notaSaidaFacade.consultarNotaSaida(dataInicial, dataFinal);
        } catch (Exception ex) {
            Logger.getLogger(NotaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Nota Fiscal de Saída " + ex);
            return null;
        }
    }
    
    public List<Notasaida> filtrarNotaSaida(String sql) {
        notaSaidaFacade = new NotaSaidaFacade();
        try {
            return notaSaidaFacade.filtrarNotaSaida(sql);
        } catch (SQLException ex) {
            Logger.getLogger(NotaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Filtar Nota Saída " + ex);
            return null;
        }
    }
    
}
