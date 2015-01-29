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
import model.Grupoconta;

/**
 *
 * @author Wolverine
 */
public class GrupoContaDao {

    private EntityManager manager;

    public List<Grupoconta> consultarGrupoconta(String descricao) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT g FROM Grupoconta g WHERE g.descricao Like '%" + descricao + "%' order by g.descricao");
        List<Grupoconta> listaGrupocontas = new ArrayList<Grupoconta>();
        listaGrupocontas =  q.getResultList();
        manager.close();
        return listaGrupocontas;
    }

    public List<Grupoconta> consultarGrupoconta() throws Exception{
        manager = ConexaoSingleton.getConexao();
        Grupoconta Grupoconta = new Grupoconta();
        Query q = manager.createQuery("SELECT g FROM Grupoconta g order by g.descricao");
        List<Grupoconta> listaGrupocontas = new ArrayList<Grupoconta>();
        listaGrupocontas =  q.getResultList();
        manager.close();
        return listaGrupocontas;
    }

    public Grupoconta consultarGrupoconta(int idgrupoConta) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Grupoconta grupoConta = new Grupoconta();
        Query q = manager.createQuery("SELECT g FROM Grupoconta g where idGrupoconta=" + idgrupoConta);
        if (q.getResultList().size()>0){
            grupoConta = (Grupoconta) q.getSingleResult();
        }
        manager.close();
        return grupoConta;
    }

    public void excluirGrupoconta(Grupoconta grupoConta) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(grupoConta);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public void salvarGrupoconta(Grupoconta grupoConta) throws Exception {
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(grupoConta);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

}
