/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package daoRemoto;

import Singleton.ConexaoSingletonRemota;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Fornecedor;

/**
 *
 * @author Wolverine
 */
public class FornecedorRemotoDao {

    private EntityManager manager;

    public List<Fornecedor> consultarFornecedor() throws SQLException{
        manager = ConexaoSingletonRemota.getConexao();
        List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
        Query q = manager.createQuery("SELECT f FROM Fornecedor f");
        listaFornecedor = q.getResultList();
        return listaFornecedor;
    }

    public Fornecedor consultarFornecedor(int idFornecedor) throws SQLException{
        manager = ConexaoSingletonRemota.getConexao();
        Fornecedor fornecedor = new Fornecedor();
        Query q = manager.createQuery("SELECT f FROM Fornecedor f where f.idfornecedor=" + idFornecedor);
        if (q.getResultList().size()>0){
            fornecedor = (Fornecedor) q.getSingleResult();
        }
        return fornecedor;
    }

    
    
    public List<Fornecedor> consultarFornecedorRazaoSocial(String razaoSocial, String nomeFantasia) throws SQLException{
         manager = ConexaoSingletonRemota.getConexao();
        List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
        Query q = manager.createQuery("SELECT f FROM Fornecedor f WHERE f.razaoSocial Like '%" + razaoSocial + "%' or f.nomeFantasia Like '%" + nomeFantasia  + "%' order by f.razaoSocial"  );
        listaFornecedor = q.getResultList();
        return listaFornecedor;
    }

    public Fornecedor consultarCNPJ(String cnpj){
        try {
            manager = ConexaoSingletonRemota.getConexao();
        } catch (Exception ex) {
            Logger.getLogger(FornecedorRemotoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         Fornecedor fornecedor = new Fornecedor();
         Query q = manager.createQuery("SELECT f FROM Fornecedor f WHERE f.cnpj='" + cnpj + "'");
         if (q.getResultList().size()>0){
             fornecedor = (Fornecedor) q.getSingleResult();
             return fornecedor;
         }else {
            return null;
         }
        
    }

    public void salvarFronecedor(Fornecedor fornecedor) throws Exception{
         manager = ConexaoSingletonRemota.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(fornecedor);
        //fechando uma transação
        manager.getTransaction().commit();
    }

    public void excluir(Fornecedor fornecedor) throws Exception{
         manager = ConexaoSingletonRemota.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        fornecedor = manager.find(Fornecedor.class, fornecedor.getIdfornecedor());
        manager.remove(fornecedor);
        //fechando uma transação
        manager.getTransaction().commit();
    }

    public int getIdFornecedor() throws Exception {
        manager = ConexaoSingletonRemota.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idfornecedor) From Fornecedor");
        int idFornecedor =(Integer) q.getSingleResult();
        return idFornecedor;
    }
}
