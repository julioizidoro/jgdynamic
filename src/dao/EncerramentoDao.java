/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Encerramento;
import model.Inventario;

/**
 *
 * @author Wolverine
 */
public class EncerramentoDao {
    
    private EntityManager manager;
    
    public Encerramento salvar(Encerramento encerramento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        encerramento = manager.merge(encerramento);
        manager.getTransaction().commit(); 
        manager.close();
        return encerramento;
    }
    
    public List<Encerramento> listar() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select e from Encerramento e order by ano");
        List<Encerramento> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
    public void salvar(Inventario inventario) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        manager.merge(inventario);
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Inventario> listar(int idEncerramento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select i from Inventario i where i.encerramento.idencerramento=" + idEncerramento + " order by i.produto.descricao");
        List<Inventario> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
}
