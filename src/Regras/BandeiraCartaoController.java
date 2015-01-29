/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import dao.BandeiraCartaoDao;
import facade.BandeiraCartaoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.BandeirasCartao;
import org.springframework.core.env.JOptCommandLinePropertySource;

/**
 *
 * @author wolverine
 */
public class BandeiraCartaoController {
    
    BandeiraCartaoFacade bandeiraCartaoFacade;
    
    public BandeirasCartao salvar(BandeirasCartao bandeirasCartao) {
        bandeiraCartaoFacade = new BandeiraCartaoFacade();
        try {
            return bandeiraCartaoFacade.salvar(bandeirasCartao);
        } catch (SQLException ex) {
            Logger.getLogger(BandeiraCartaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Bandeira " + ex);
            return null;
        }
    }
    
    public List<BandeirasCartao> listar() {
        bandeiraCartaoFacade = new BandeiraCartaoFacade();
        try {
            return bandeiraCartaoFacade.listar();
        } catch (Exception ex) {
            Logger.getLogger(BandeiraCartaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Listar Bandeira " + ex);
            return null;
        }
    }
    
    public BandeirasCartao pesquisarid(int idBandeira) {
        bandeiraCartaoFacade = new BandeiraCartaoFacade();
        try {
            return bandeiraCartaoFacade.pesquisarid(idBandeira);
        } catch (Exception ex) {
            Logger.getLogger(BandeiraCartaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Pesquiar Id Bandeira " + ex);
            return null;
        }
    }
    
    
}
