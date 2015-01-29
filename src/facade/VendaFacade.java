/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.VendaDao;
import java.sql.SQLException;
import java.util.List;
import model.Saida;
import model.Venda;

/**
 *
 * @author Wolverine
 */
public class VendaFacade {

    VendaDao vendaDao;

    public void gravarVendas(Venda venda) throws Exception{
        vendaDao = new VendaDao();
        vendaDao.gravarVendas(venda);
    }

    public void gravarSaida(Saida saida) throws Exception{
        vendaDao = new VendaDao();
        vendaDao.gravarSaida(saida);
    }

    public Venda ultimaVendaGravada() throws Exception {
        vendaDao = new VendaDao();
        int idVenda = vendaDao.ultimaVendaGravada();
        return vendaDao.getVenda(idVenda);
    }
    
    public List<Saida> listarSaidaVenda(int idVenda)throws Exception{
        vendaDao = new VendaDao();
        return vendaDao.listarSaidaVenda(idVenda);
    }
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa) throws SQLException{
        vendaDao = new VendaDao();
        return  vendaDao.valorFormaPagamento(idFormaPagamento, idFechaCaixa);
    }
    
    public List<Venda> ListarVenda(int idFechaCaixa) throws Exception{
        vendaDao = new VendaDao();
        return vendaDao.ListarVenda(idFechaCaixa);
    }
    
     public void excluirVendas(Venda venda) throws Exception{
         vendaDao = new VendaDao();
         vendaDao.excluirVendas(venda);
    }
     
     public List<Venda> listarVendaPrazo(String data, int idEmpresa) throws SQLException{
         vendaDao = new VendaDao();
         return vendaDao.listarVendaPrazo(data, idEmpresa);
     }
     
     public double quantidadeVendida(int idProduto, String dataInicial, String dataFinal) throws SQLException{
         vendaDao = new VendaDao();
         return vendaDao.quantidadeVendida(idProduto, dataInicial, dataFinal);
     }
     
     public List<Venda> listarVendaPeriodo(String dataInicial, String dataFinal) throws SQLException{
         vendaDao = new VendaDao();
         return vendaDao.listarVendaPeriodo(dataInicial, dataFinal);
     }
     
     public Venda getVenda(int idVenda) throws Exception{
         vendaDao = new VendaDao();
         return vendaDao.getVenda(idVenda);
     }
     
     public double ValorVenda(int idProduto, String dataInicial, String dataFinal) throws SQLException {
         vendaDao = new VendaDao();
         return vendaDao.ValorVenda(idProduto, dataInicial, dataFinal);
     }
     
     public List<Venda> getVenda(String sql) throws Exception{
         vendaDao = new VendaDao();
         return vendaDao.getVenda(sql);
     }
     
    


}