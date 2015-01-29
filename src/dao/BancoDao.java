/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Singleton.ConexaoSingleton;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Banco;

/**
 *
 * @author Wolverine
 */
public class BancoDao {

    private EntityManager manager;

    public void salvar(Banco banco) throws Exception {
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(banco);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
    }

    public List<Banco> listar() throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Banco> listaBanco = new ArrayList<Banco>();
        Query q = manager.createQuery("select b from Banco b order by b.nomeAgencia");
        if (q.getResultList().size()>0){
            listaBanco= q.getResultList();
        }
        manager.close();
        return listaBanco;
    }

    public List<Banco> listar(String nomeAgencia) throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Banco> listaBanco = new ArrayList<Banco>();
        Query q = manager.createQuery("select b from Banco b where b.nomeAgencia Like '%" + nomeAgencia + "%' order by b.NomeAgencia");
        if (q.getResultList().size()>0){
            listaBanco= q.getResultList();
        }
        manager.close();
        return listaBanco;
    }

}
