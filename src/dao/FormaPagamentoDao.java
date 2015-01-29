/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Formapagamento;

/**
 *
 * @author Woverine
 */
public class FormaPagamentoDao {
    
    private EntityManager manager;

    public List<Formapagamento> ListaFormaPagamento(int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Formapagamento> listaFormaPagamento = new ArrayList<Formapagamento>();
        Query q = manager.createQuery("Select f from Formapagamento f where empresa=" + idEmpresa + " order by f.idformaPagamento");
        listaFormaPagamento = q.getResultList();
        manager.close();
        return listaFormaPagamento;

    }
    
    public Formapagamento getFormaPagamento(int idFormaPagamento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Formapagamento formaPagamento = new Formapagamento();
        Query q = manager.createQuery("Select f from Formapagamento f where f.idformaPagamento=" + idFormaPagamento);
        formaPagamento = (Formapagamento) q.getSingleResult();
        manager.close();
        return formaPagamento;

    }
    
    public Formapagamento salvar(Formapagamento formaPagamento) throws Exception {
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        formaPagamento = manager.merge(formaPagamento);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return formaPagamento;
    }
    
    public void excluir(Formapagamento formaPagamento) throws Exception {
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        formaPagamento = manager.find(Formapagamento.class, formaPagamento.getIdformaPagamento());
        manager.remove(formaPagamento);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    
    
    public List<Formapagamento> getFormaPagamentoBandeiraCartao(int idBandeiraCartao) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Formapagamento> listaFormaPagamento = new ArrayList<Formapagamento>();
        Query q = manager.createQuery("Select f from Formapagamento f where f.bandeiraCartao=" + idBandeiraCartao + " order by f.idformaPagamento");
        listaFormaPagamento = q.getResultList();
        manager.close();
        return listaFormaPagamento;
    }
    
    public List<Formapagamento> listarFormaPagamentoValor() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Formapagamento> listaFormaPagamento = new ArrayList<Formapagamento>();
        Query q = manager.createQuery("Select f from Formapagamento f where f.valor>0 order by f.idformaPagamento");
        listaFormaPagamento = q.getResultList();
        manager.close();
        return listaFormaPagamento;

    }
    
    public List<Formapagamento> getFormaPagamento() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Formapagamento> listaFormaPagamento = new ArrayList<Formapagamento>();
        Query q = manager.createQuery("Select f from Formapagamento f where f.bandeiraCartao=3 order by f.idformaPagamento");
        listaFormaPagamento = q.getResultList();
        manager.close();
        return listaFormaPagamento;
    }
    
    public List<Formapagamento> getFormaPagamentoCartao() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Formapagamento> listaFormaPagamento = new ArrayList<Formapagamento>();
        Query q = manager.createQuery("Select f from Formapagamento f where f.bandeiraCartao<>3 order by f.idformaPagamento");
        listaFormaPagamento = q.getResultList();
        manager.close();
        return listaFormaPagamento;
    }
    
    
}
