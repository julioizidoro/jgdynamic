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

import model.Subgrupo;



/**
 *
 * @author Wolverine
 */
public class SubGrupoContaDao {

    private EntityManager manager;

    

    public List<Subgrupo> consultarSubGrupoconta() throws Exception{
        manager = ConexaoSingleton.getConexao();
        Query q =  manager.createQuery("SELECT s FROM Subgrupo s order by s.numeroConta");
        List<Subgrupo> listaGrupocontas = new ArrayList<Subgrupo>();
        listaGrupocontas =  q.getResultList();
        manager.close();
        return listaGrupocontas;
    }

    public Subgrupo consultarSubGrupoconta(int idgrupoConta) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Subgrupo grupoConta = new Subgrupo();
        Query q = manager.createQuery("SELECT s FROM Grupoconta s where idSubgrupo=" + idgrupoConta);
        if (q.getResultList().size()>0){
            grupoConta = (Subgrupo) q.getSingleResult();
        }
        manager.close();
        return grupoConta;
    }

    public void excluirSubGrupoconta(Subgrupo grupoConta) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(grupoConta);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public void salvarSubGrupoconta(Subgrupo grupoConta) throws Exception {
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(grupoConta);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

}
