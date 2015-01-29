/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ConfiguracaoDao;
import java.sql.SQLException;
import model.Configuracao;

/**
 *
 * @author wolverine
 */
public class ConfiguracaoFacade {
    
    ConfiguracaoDao configuracaoDao;
    
    public Configuracao salvarConfiguracao(Configuracao configuracao) throws SQLException{
        configuracaoDao = new ConfiguracaoDao();
        return configuracaoDao.salvarConfiguracao(configuracao);
    }
    
    public Configuracao getConfiguracao(int idEmpresa) throws SQLException{
        configuracaoDao = new ConfiguracaoDao();
        return configuracaoDao.getConfiguracao(idEmpresa);
    }
    
}
