/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EmpresaDao;
import java.sql.SQLException;
import java.util.List;
import model.Empresa;

/**
 *
 * @author Wolverine
 */
public class EmpresaFacade {
    
    EmpresaDao empresaDao;
    
    public Empresa buscarEmpresa(int idEmpresa) throws SQLException{
        empresaDao= new EmpresaDao();
        return empresaDao.buscarEmpresa(idEmpresa);
    }
    
    public List<Empresa> buscarEmpresa() throws SQLException{
        empresaDao = new EmpresaDao();
        return empresaDao.buscarEmpresa();
    }
    
    public Empresa salvar(Empresa empresa) throws SQLException{
        empresaDao = new EmpresaDao();
        return empresaDao.salvar(empresa);
    }
    
}
