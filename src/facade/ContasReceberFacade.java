/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ContasReceberDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.*;
import model.View.Viewrelatoriocreditotodas;
import model.View.Viewrelcontasrecebertodas;

/**
 *
 * @author Wolverine
 */
public class ContasReceberFacade {
    
    ContasReceberDao contasReceberDao;
    
    // operações Contas Receber
    
    public Contasreceber salvarContasReceber(Contasreceber contasReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.salvarContasReceber(contasReceber);
    }
    
    public void excluirContasReceber(Contasreceber contasReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        contasReceberDao.excluirContasReceber(contasReceber);
    }
    
    public List<Contasreceber> listarContas(String sql) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarContas(sql);
    }
    
    // operações Fatura
    
    public Faturasreceber salvarFatura(Faturasreceber faturaReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.salvarFatura(faturaReceber);
    }
    
    public void excluirFatura(Faturasreceber faturaReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        contasReceberDao.excluirFatura(faturaReceber);
    }
    
       
    public List<Faturasreceber> listarFaturas(String sql) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarFaturas(sql);
    }
    
    
    // operacoes Parcela Fatura
    
    
    public float calcularValorParcelaFaturaBancoDia(String sql) throws SQLException{
        contasReceberDao =new ContasReceberDao();
        return contasReceberDao.calcularValorParcelaFaturaBancoDia(sql);
    }
    
    public Contasreceberprodutos consultarContasReceberProduto(int idContasReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.consultarContasReceberProduto(idContasReceber);
    }
    
    public List<Contasreceberpagamento> consultarContasReceberPagamento(int idFechaCaixa) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.consultarContasReceberPagamento(idFechaCaixa);
    }
    
    public List<Contasreceberforma> consultarFormaPagamento(int idContasReceberPagamento, String forma) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.consultarFormaPagamento(idContasReceberPagamento, forma);
    }
    
    public List<Contasreceberpagamento> listarPagamento(String dataInicial, String dataFinal) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarPagamento(dataInicial, dataFinal);
    }
    
    public List<Contasreceberforma> listarFormaPagamento(int idPagamento) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarFormaPagamento(idPagamento);
    }
    
    public List<Contasreceber> listarFaturaReceberParcelas(int idFatura) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarFaturaReceberParcelas(idFatura);
    }
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa, int idEmpresa) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.valorFormaPagamento(idFormaPagamento, idFechaCaixa, idEmpresa);
    }
    
    public ResultSet listarContasReceberFormaPagamento(String data, int idEmpresa) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarContasReceberFormaPagamento(data, idEmpresa);
    }
    
    public List<Contasreceberprodutos> listaContasReceberProdutos(int idContasReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listaContasReceberProdutos(idContasReceber);
    }
    
    public void excluirContasReceberProduto(Contasreceberprodutos produto) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        contasReceberDao.excluirContasReceberProduto(produto);
    }
    
    public Contasreceberprodutos salvarContasReceberProduto(Contasreceberprodutos contasReceberProduto) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.salvarContasReceberProduto(contasReceberProduto);
    }
    
    public Contasreceberprodutos consultarContasReceberProdutoVenda(int idVenda) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.consultarContasReceberProdutoVenda(idVenda);
    }
    
    public Contasreceberpagamento consultarContaReceberPagamento(int idCotnasReceberPagamento) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.consultarContaReceberPagamento(idCotnasReceberPagamento);
    }
    
    public List<Viewrelcontasrecebertodas> listarContasReceberTodas(int idEmpresa) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarContasReceberTodas(idEmpresa);
    }
    
    public Viewrelatoriocreditotodas listarCreditosReceberTodas(int idCliente) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarCreditosReceberTodas(idCliente);
    }
}
