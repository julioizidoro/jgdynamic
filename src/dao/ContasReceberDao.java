/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.*;
import model.View.Viewrelatoriocreditotodas;
import model.View.Viewrelcontasrecebertodas;

/**
 *
 * @author Wolverine
 */
public class ContasReceberDao {
    
    private EntityManager manager;
    
    // operações Contas Receber
    
    public Contasreceber salvarContasReceber(Contasreceber contasReceber) throws SQLException{
        //editar
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        contasReceber = manager.merge(contasReceber);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return contasReceber;
    }
    
    public void excluirContasReceber(Contasreceber contasReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        contasReceber = manager.find(Contasreceber.class, contasReceber.getIdcontasReceber());
        manager.remove(contasReceber);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    // operações Fatura
    
    public Faturasreceber salvarFatura(Faturasreceber faturaReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        faturaReceber = manager.merge(faturaReceber);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return faturaReceber;
    }
    
    public void excluirFatura(Faturasreceber faturaReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        faturaReceber = manager.find(Faturasreceber.class, faturaReceber.getIdFaturasReceber());
        manager.remove(faturaReceber);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Contasreceber> listarContas(String sql) throws SQLException{
        List<Contasreceber> listaContasReceber = new ArrayList<Contasreceber>();
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        listaContasReceber = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return listaContasReceber;
    }
    
    public List<Faturasreceber> listarFaturas(String sql) throws SQLException{
        List<Faturasreceber> listaFaturasReceber = new ArrayList<Faturasreceber>();
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        listaFaturasReceber = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return listaFaturasReceber;
    }
    
    
    // operacoes Parcela Fatura
    
    
    
   
    public Contasreceberprodutos consultarContasReceberProduto(int idContasReceber) throws SQLException{
        Contasreceberprodutos contasReceberProdutos = new Contasreceberprodutos();
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select r from Contasreceberprodutos r where r.contasreceber=" + idContasReceber);
        if (q.getResultList().size()>0){
            contasReceberProdutos = (Contasreceberprodutos) q.getResultList().get(0);
            manager.getTransaction().commit(); 
            manager.close();
            return contasReceberProdutos;
        }
        manager.getTransaction().commit(); 
        manager.close();
        return null;
        
    }
    
    public Contasreceberprodutos consultarContasReceberProdutoVenda(int idVenda) throws SQLException{
        Contasreceberprodutos contasReceberProdutos = new Contasreceberprodutos();
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select r from Contasreceberprodutos r where r.venda=" + idVenda);
        if (q.getResultList().size()>0){
            contasReceberProdutos = (Contasreceberprodutos) q.getResultList().get(0);
            manager.getTransaction().commit(); 
            manager.close();
            return contasReceberProdutos;
        }
        manager.getTransaction().commit(); 
        manager.close();
        return null;
        
    }
    
    public List<Contasreceberpagamento> consultarContasReceberPagamento(int idFechaCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select c from Contasreceberpagamento c where c.fechaCaixa=" + idFechaCaixa);
        List<Contasreceberpagamento> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
    public List<Contasreceberforma> consultarFormaPagamento(int idContasReceberPagamento, String forma) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select c from Contasreceberforma c where c.contasreceberpagamento=" + idContasReceberPagamento + " and c.formaRecebimento='" +
                forma + "'");
        List<Contasreceberforma> lista = q.getResultList();
        manager.getTransaction().commit();
        manager.close();
        return lista;
    }
    
    public List<Contasreceberpagamento> listarPagamento(String dataInicial, String dataFinal) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select p from Contasreceberpagamento p where p.dataPagamento>='" + dataInicial 
                + "' and p.dataPagamento<='" + dataFinal + "'");
        List<Contasreceberpagamento> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
    public List<Contasreceberforma> listarFormaPagamento(int idPagamento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select f from Contasreceberforma f where f.contasreceberpagamento=" + idPagamento);
        List<Contasreceberforma> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
    public List<Contasreceber> listarFaturaReceberParcelas(int idFatura) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select c from Contasreceber c where c.numeroFatura=" + idFatura + " order by c.numeroParcelas");
        List<Contasreceber> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }    
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa, int idEmpresa ) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        String sql = "SELECT distinct sum(contasreceberforma.valorPago) as valorPago "
        + " FROM  contasreceberforma join contasreceberpagamento "
        + " on contasreceberforma.contasreceberpagamento_idcontasreceberpagamento = contasreceberpagamento.idcontasreceberpagamento" +
        " where  formapagamento_idformapagamento=" + idFormaPagamento + " and contasreceberpagamento.fechacaixa_idfechacaixa=" + idFechaCaixa + 
                " and contasreceberforma.empresa_idempresa=" + idEmpresa;
        Query q = manager.createNativeQuery(sql);
        Double valor = 0.0;
        valor = (Double) q.getResultList().get(0);
        if (valor==null){
            manager.getTransaction().commit(); 
            manager.close();
            return 0.0f;
        }
        manager.getTransaction().commit(); 
        manager.close();
        return valor.floatValue();
    }
    
    public float calcularValorParcelaFaturaBancoDia(String sql) throws SQLException{
        Double valor = 0.0;
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query query = manager.createNativeQuery(sql);
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
        }
        manager.getTransaction().commit(); 
        manager.close();
        return valor.floatValue();
    }
    
    public ResultSet listarContasReceberFormaPagamento(String data, int idEmpresa) throws SQLException {
    Connection conn = ConexaoSingleton.getConexaoJDBC();
    String sql = "call procedureContasReceberFormaPagamento('" + data + "'," + idEmpresa + ")";
    Statement stm = conn.createStatement();
    ResultSet rs = stm.executeQuery(sql);
    return rs;
  }
    
  public List<Contasreceberprodutos> listaContasReceberProdutos(int idContasReceber) throws SQLException{
        List<Contasreceberprodutos> listaContasReceberProdutos = new ArrayList<Contasreceberprodutos>();
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select c from Contasreceberprodutos c where c.contasreceber=" + idContasReceber);
        List<Contasreceberprodutos> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
  
  public void excluirContasReceberProduto(Contasreceberprodutos produto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        produto = manager.find(Contasreceberprodutos.class, produto.getIdcontasReceberProdutos());
        manager.remove(produto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        manager.close();
    }
  
    public Contasreceberprodutos salvarContasReceberProduto(Contasreceberprodutos contasReceberProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        contasReceberProduto = manager.merge(contasReceberProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return contasReceberProduto;
    }
    
    public Contasreceberpagamento consultarContaReceberPagamento(int idCotnasReceberPagamento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select p from Contasreceberpagamento p where p.idcontasReceberPagamento=" + idCotnasReceberPagamento);
        Contasreceberpagamento conta = (Contasreceberpagamento) q.getResultList().get(0);
        manager.getTransaction().commit(); 
        manager.close();
        return conta;
    }
    
    public List<Viewrelcontasrecebertodas> listarContasReceberTodas(int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select c from Viewrelcontasrecebertodas c where c.empresaIdempresa=" + idEmpresa + " order by c.nome");
        List<Viewrelcontasrecebertodas> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
    public Viewrelatoriocreditotodas listarCreditosReceberTodas(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select c from Viewrelatoriocreditotodas c where c.clienteIdcliente=" + idCliente);
        Viewrelatoriocreditotodas lista = null;
        if (q.getResultList().size()>0){
            lista = (Viewrelatoriocreditotodas) q.getResultList().get(0);
        }
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
}