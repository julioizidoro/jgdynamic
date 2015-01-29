/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.NotaSaidaDao;
import java.sql.SQLException;
import java.util.List;
import model.NotaSaida;

/**
 *
 * @author wolverine
 */
public class NotaSaidaFacade {
    
    NotaSaidaDao notaSaidaDao;
    
    public List<NotaSaida> consultarNotaSaida(String data) throws Exception{
        notaSaidaDao = new NotaSaidaDao();
        return notaSaidaDao.consultarNotaSaida(data);
    }
    
    public NotaSaida salvarNotaSaida(NotaSaida notaSaida) throws Exception{
        notaSaidaDao = new NotaSaidaDao();
        return notaSaidaDao.salvarNotaSaida(notaSaida);
    }
    
    public List<NotaSaida> consultarNotaSaida(String dataInicial, String dataFinal) throws Exception{
        notaSaidaDao = new NotaSaidaDao();
        return notaSaidaDao.consultarNotaSaida(dataInicial, dataFinal);
    }
    
    public int consultarUltimaNotaEmitida() throws SQLException{
        notaSaidaDao = new NotaSaidaDao();
        return notaSaidaDao.consultarUltimaNotaEmitida();
    }
    
    public List<NotaSaida> filtrarNotaSaida(String sql) throws SQLException{
        notaSaidaDao = new NotaSaidaDao();
        return notaSaidaDao.filtrarNotaSaida(sql);
    }
    
}
