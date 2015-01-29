/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.AliquotaDao;
import java.sql.SQLException;
import java.util.List;
import model.Aliquota;

/**
 *
 * @author Wolverine
 */
public class AliquotaFacade {
    AliquotaDao aliquotaDao;
    
    public Aliquota buscarAliquotaValor(Double valor) throws SQLException{
        aliquotaDao = new AliquotaDao();
        return aliquotaDao.buscarAliquotaValor(valor);
    }
    
        
    public List<Aliquota> buscarAliquota() throws SQLException{
        aliquotaDao = new AliquotaDao();
        return aliquotaDao.buscarAliquota();
    }
    
    public Aliquota buscarAliquotaDescricao(String descricao) throws SQLException{
        aliquotaDao = new AliquotaDao();
        return aliquotaDao.buscarAliquotaDescricao(descricao);
    }
    
    public Aliquota buscarAliquotaid(int idAliquota) throws SQLException{
        aliquotaDao = new AliquotaDao();
        return aliquotaDao.buscarAliquotaid(idAliquota);
    }
    
}
