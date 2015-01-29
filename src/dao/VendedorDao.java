/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Vendedor;

/**
 *
 * @author Wolverine
 */
public class VendedorDao {
    
    private EntityManager manager;
    
    public Vendedor salvar(Vendedor vendedor) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        vendedor = manager.merge(vendedor);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return vendedor;
    }
    
    public Vendedor consultarVendedorId(int idVendedor) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select v From Vendedor v where v.idvendedor=" + idVendedor);
        Vendedor vendedor = null;
        if(q.getResultList().size()>0){
            vendedor =  (Vendedor) q.getSingleResult();
        }
        manager.close();
        return vendedor;
    }
    
    public List<Vendedor> consultarVendedor(String nome, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select v From Vendedor v where v.nomeCompleto like '" + nome + "%' and v.empresa=" + idEmpresa + " order by v.nomeCompleto");
        List<Vendedor> lista = null;
        if(q.getResultList().size()>0){
            lista =  q.getResultList();
        }
        manager.close();
        return lista;
    }
    
}
