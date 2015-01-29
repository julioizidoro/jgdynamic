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
import model.Empresa;

/**
 *
 * @author Wolverine
 */
public class EmpresaDao {
    
    private EntityManager manager;
    
    public Empresa buscarEmpresa(int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Empresa empresa = new Empresa();
        Query q = manager.createQuery("select e from Empresa e where e.idempresa=" + idEmpresa);
        if (q.getResultList().size()>0){
            empresa=  (Empresa) q.getSingleResult();
        }
        manager.close();
        return empresa;
    }
    
    public List<Empresa> buscarEmpresa() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Empresa empresa = new Empresa();
        Query q = manager.createQuery("select e from Empresa e");
        List<Empresa> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
    public Empresa salvar(Empresa empresa) throws SQLException{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        empresa = manager.merge(empresa);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return empresa;
    }
    
}
