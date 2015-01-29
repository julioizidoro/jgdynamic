/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.BandeiraCartaoDao;
import java.sql.SQLException;
import java.util.List;
import model.Banco;
import model.BandeirasCartao;

/**
 *
 * @author wolverine
 */
public class BandeiraCartaoFacade {
    
    BandeiraCartaoDao bandeiraCartaoDao;
    
    public BandeirasCartao salvar(BandeirasCartao bandeirasCartao) throws SQLException{
        bandeiraCartaoDao = new BandeiraCartaoDao();
        return bandeiraCartaoDao.salvar(bandeirasCartao);
    }
    
    public List<BandeirasCartao> listar() throws Exception{
        bandeiraCartaoDao = new BandeiraCartaoDao();
        return bandeiraCartaoDao.listar();
    }
    
    public BandeirasCartao pesquisarid(int idBandeira) throws Exception{
        bandeiraCartaoDao = new BandeiraCartaoDao();
        return bandeiraCartaoDao.pesquisarid(idBandeira);
    }
    
}
