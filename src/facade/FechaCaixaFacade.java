/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.FechaCaixaDao;
import java.sql.SQLException;
import java.util.List;
import model.Fechacaixa;

/**
 *
 * @author Wolverine
 */
public class FechaCaixaFacade {

    private FechaCaixaDao fechaCaixaDao;

    public Fechacaixa salvar(Fechacaixa fechaCaixa) throws  Exception{
        fechaCaixaDao = new FechaCaixaDao();
        return fechaCaixaDao.salvar(fechaCaixa);
    }

    public Fechacaixa getFechaCaixa(String caixa, String operador) throws SQLException{
        fechaCaixaDao = new FechaCaixaDao();
        return fechaCaixaDao.getFechaCaixa(caixa, operador);
    }
    
    public List<Fechacaixa> pesquisarFechamento(String dataInicio, String dataFim, int idEmpresa) throws SQLException{
        fechaCaixaDao = new FechaCaixaDao();
        return fechaCaixaDao.pesquisarFechamento(dataInicio, dataFim, idEmpresa);
    }
    
    public List<Fechacaixa> pesquisarFechamento(String data, int idEmpresa) throws SQLException{
        fechaCaixaDao = new FechaCaixaDao();
        return fechaCaixaDao.pesquisarFechamento(data, idEmpresa);
    }
    
    public Fechacaixa consultar(Fechacaixa fechaCaixa) throws  Exception{
        fechaCaixaDao = new FechaCaixaDao();
        return fechaCaixaDao.consultar(fechaCaixa);
    }

}