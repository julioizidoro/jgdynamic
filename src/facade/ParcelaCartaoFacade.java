/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ParcelaCartaoDao;
import java.sql.SQLException;
import java.util.List;
import model.Parcelacartao;

/**
 *
 * @author wolverine
 */
public class ParcelaCartaoFacade {
    
    ParcelaCartaoDao parcelaCartaoDao;
    
    public List<Parcelacartao> consultarParcelaCartao(String data, int idBanco) throws SQLException{
        parcelaCartaoDao= new ParcelaCartaoDao();
        return parcelaCartaoDao.consultarParcelaCartao(data, idBanco);
    }
    
    public float calcularValorCArtaoBancoDia(String sql) throws SQLException{
        parcelaCartaoDao = new ParcelaCartaoDao();
        return parcelaCartaoDao.calcularValorCArtaoBancoDia(sql);
    }
    
}
