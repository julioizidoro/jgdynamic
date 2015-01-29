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
import model.Banco;
import model.Movimentobanco;

/**
 *
 * @author Wolverine
 */
public class MovimentoBancoDao {
    
    private EntityManager manager;

    public Movimentobanco consultarMovimentoBanco(int idMovimentoBanco) throws Exception {
        Query query = manager.createQuery("Select b From Movimentobanco b where idMovimentoBanco=" + idMovimentoBanco);
        Movimentobanco movimentobanco = (Movimentobanco) query.getResultList();
        manager.close();
        return  movimentobanco;
    }

    public Movimentobanco salvarBanco(Movimentobanco banco) throws Exception {
        manager = ConexaoSingleton.getConexao();
        try{
            manager.getTransaction().begin();
            banco = manager.merge(banco);
            manager.getTransaction().commit(); 
            manager.close();
            return banco;
          }catch(Exception ex){
              if (manager.getTransaction().isActive()){
                  manager.getTransaction().rollback();
                  return null;
              }
              throw new Exception("Erro ao Salvar no Banco de Dados", ex);
          }
    }


    public List<Movimentobanco> conusltarMovimentoBanco(String descricao, Banco banco) throws Exception {
        manager = ConexaoSingleton.getConexao();
        try{
            Query q = manager.createQuery("SELECT b FROM Movimentobanco b WHERE b.banco.idbanco=" +  banco.getIdbanco() + " and b.descricao Like '%" + descricao + "%' order by b.descricao");
            List<Movimentobanco> lista = q.getResultList();
            manager.close();
            return lista;
        }catch(Exception ex){
            throw new Exception("Erro de consulta", ex);
        }


    }

    public List<Movimentobanco> consultarMovimentoBanco(String inicio, String fim, Banco banco) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery("Select b  From Movimentobanco b where  b.banco.idbanco=" +  banco.getIdbanco());
                //manager.createQuery("Select c from Movimentocaixa c where (c.data>='" + inicio +
             //   "')  and (c.data<='" + fim + "') order by c.data" );
        List<Movimentobanco> listaCaixa = new ArrayList<Movimentobanco>();
        listaCaixa = query.getResultList();
        manager.close();
        return listaCaixa;
    }

    public List<Movimentobanco> consultarMovimentoBanco(String inicio, String fim, int planoContas, Banco banco) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery("Select b From Movimentobanco b Where b.banco.idbanco=" +  banco.getIdbanco() + " and (b.data>='" + inicio +
                "')  and (b.data<='" + fim + "')  and (b.conta=" + planoContas + ")  order by b.data");
        List<Movimentobanco> lista = query.getResultList();
        manager.close();
        return lista;
    }

    public List<Double> calculaSaldos(String dataBanco, Banco banco) throws SQLException {
        double valor= 0;
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From movimentobanco where banco_idbanco=" +  banco.getIdbanco() + " and (dataMovimento='" + dataBanco + "')");
        List<Double> saldo = new ArrayList<Double>();
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);


        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From movimentobanco where banco_idbanco=" +  banco.getIdbanco() + " and (dataMovimento='" + dataBanco + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From movimentobanco where  banco_idbanco=" +  banco.getIdbanco() + " and (dataMovimento<'" + dataBanco + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From Movimentobanco where banco_idbanco=" +  banco.getIdbanco() + " and (dataMovimento<'" + dataBanco + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);
        manager.close();
        return saldo;
    }

    public Movimentobanco consultaMovimentoBanco(String sql) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery(sql);
        Movimentobanco movimentobanco = (Movimentobanco) query.getResultList().get(0);
        manager.close();
        return movimentobanco;
    }

    public double getSaldoAnterior(String dataBanco, Banco banco) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From movimentobanco where banco_idbanco=" +  banco.getIdbanco() + " and (data<'" + dataBanco + "')");
        double valor = 0;
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
        }
        manager.close();
        return valor;
    }

    public List<Double> calculaSaldos(String dataInicio, String dataFinal, Banco banco) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        double valor= 0;
        Query query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From movimentobanco where banco_idbanco=" +  banco.getIdbanco() + " and (data<'" + dataInicio + "')");

        List<Double> saldo = new ArrayList<Double>();
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);


        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From movimentobanco where banco_idbanco=" +  banco.getIdbanco() + " and (data<'" + dataInicio + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From movimentobanco where banco_idbanco=" +  banco.getIdbanco() + " and (data>='" + dataInicio + "') and  (data<='" + dataFinal + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorSaida) as entrada " +
                "From movimentobanco where banco_idbanco=" +  banco.getIdbanco() + " and (data>='" + dataInicio + "') and  (data<='" + dataFinal + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);
        manager.close();
        return saldo;
    }
    
    public List<Movimentobanco> consultarMovimentoBancoDia(String data, int idBanco) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery("Select b  From Movimentobanco b where  b.banco=" +  idBanco +
                " and b.dataMovimento='" + data + "'");
        List<Movimentobanco> listaMovimentoBanco = new ArrayList<Movimentobanco>();
        listaMovimentoBanco = query.getResultList();
        manager.close();
        return listaMovimentoBanco;
    }
    
    public float calcularValorChequesBancoDia(String sql) throws SQLException{
        Double valor = 0.0;
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createNativeQuery(sql);
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
        }
        manager.close();
        return valor.floatValue();
    }

}
