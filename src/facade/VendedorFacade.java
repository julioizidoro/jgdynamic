/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.VendedorDao;
import java.sql.SQLException;
import java.util.List;
import model.Vendedor;

/**
 *
 * @author Wolverine
 */
public class VendedorFacade {
    VendedorDao vendedorDao;
    
    public Vendedor salvar(Vendedor vendedor) throws Exception{
        vendedorDao = new  VendedorDao();
        return vendedorDao.salvar(vendedor);
    }
    
    public Vendedor consultarVendedorId(int idVendedor) throws SQLException{
        vendedorDao = new VendedorDao();
        return vendedorDao.consultarVendedorId(idVendedor);
    }
    
    public List<Vendedor> consultarVendedor(String nome, int idEmpresa) throws SQLException{
        vendedorDao = new VendedorDao();
        return vendedorDao.consultarVendedor(nome, idEmpresa);
    }
    
    
    
    
}
