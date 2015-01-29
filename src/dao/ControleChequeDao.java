/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Regras.Formatacao;
import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ChequeFechaCaixa;
import model.ChequeMovBanco;
import model.ChequeMovCaixa;
import model.Contolechequefornecedor;
import model.Controlecheques;

/**
 *
 * @author Wolverine
 */
public class ControleChequeDao {
    
    private EntityManager manager;
    
    public void salvarCehque(Controlecheques cheque) throws Exception {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(cheque);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Controlecheques> listarCheques(String sql) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Controlecheques> listaCheques = null;
        Query q = manager.createQuery(sql);
        if (q.getResultList().size()>0){
            listaCheques = q.getResultList();
        }
        manager.close();
        return listaCheques;
    }
    
    public List<Contolechequefornecedor> consultarFornecedor(int idFornecedor) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        String data = "";
        try {
            data = Formatacao.SubtarirDatas(new Date(), 90, "yyyy/MM/dd");
        } catch (Exception ex) {
            Logger.getLogger(ControleChequeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Query q = manager.createQuery("Select c from Contolechequefornecedor c where c.fornecedor=" + idFornecedor +
                " and dataFornecedor>='" + data + "'");
        List<Contolechequefornecedor> lista = q.getResultList();
        manager.close();
        return lista;
    }
    
    public Contolechequefornecedor consultarFornecedorCheque(int idControleCheques) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from Contolechequefornecedor c where c.controlecheques=" + idControleCheques);
        Contolechequefornecedor controle = null;
        if (q.getResultList().size()>0){
            controle =   (Contolechequefornecedor) q.getSingleResult();
        }
        manager.close();
        return controle;
    }
    
    public void salvarFornecedor(Contolechequefornecedor fornecedor) throws Exception {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(fornecedor);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public Controlecheques consultarCheque(int idControleCheques) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Controlecheques controle = null;
        Query q = manager.createQuery("Select c from Controlecheques c where c.idControleCheques=" + idControleCheques);
        if (q.getResultList().size()>0){
            controle = (Controlecheques) q.getSingleResult();
        }
        manager.close();
        return controle;
    }
    
    public ChequeFechaCaixa salvarCehqueFechaCaixa(ChequeFechaCaixa chequeFechaCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        chequeFechaCaixa = manager.merge(chequeFechaCaixa);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return chequeFechaCaixa;
    }
    
    public ChequeMovBanco salvarChequeMovBanco(ChequeMovBanco chequeMovBanco) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        chequeMovBanco = manager.merge(chequeMovBanco);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return chequeMovBanco;
    }
    
    public ChequeMovCaixa salvarChequeMovCaixa(ChequeMovCaixa chequeMovCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        chequeMovCaixa = manager.merge(chequeMovCaixa);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return chequeMovCaixa;
    }
    
    public float calcularValorChequesCompensarDia(String data) throws SQLException{
        Double valor = 0.0;
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createNativeQuery("Select distinct sum(valorCheque) as valorCheque " +
                "From controlecheques where(dataCompensacao='" + data + "')  and situacao='Caixa'");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
        }
        manager.close();
        return valor.floatValue();
    }
    
    public List<ChequeFechaCaixa>  ListaChequesCaixa(int idFechaCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from ChequeFechaCaixa c where c.fechacaixa=" + idFechaCaixa);
        List<ChequeFechaCaixa> lista = null;
        if (q.getResultList().size()>0){
           lista = q.getResultList();
        }
        manager.close();
        return lista;
    }

    
    
   }
