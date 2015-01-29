/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import dao.ConfiguracaoDao;
import facade.ConfiguracaoFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Configuracao;
import org.springframework.core.env.JOptCommandLinePropertySource;

/**
 *
 * @author wolverine
 */
public class ConfiguracaoController {
    
    ConfiguracaoFacade configuracaoFacade;
    
    public Configuracao salvarConfiguracao(Configuracao configuracao) {
        configuracaoFacade = new ConfiguracaoFacade();
        try {
            return configuracaoFacade.salvarConfiguracao(configuracao);
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Configuração " + ex);
            return null;
        }
    }
    
    public Configuracao getConfiguracao(int idEmpresa) {
        configuracaoFacade = new ConfiguracaoFacade();
        try {
            return configuracaoFacade.getConfiguracao(idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Consultar Configuração " +  ex);
            return null;
        }
    }
    
}
