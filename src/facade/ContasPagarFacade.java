/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ContasPagarDao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Contaspagar;
import model.Formacontaspagar;
import model.Pagamentocontaspagar;
import model.View.Viewcontaspagar;

/**
 *
 * @author Wolverine
 */
public class ContasPagarFacade {
    
    ContasPagarDao contasPagarDao;
    
    public Contaspagar salvar(Contaspagar contasPagar) throws SQLException{
        contasPagarDao = new ContasPagarDao();
        return contasPagarDao.salvar(contasPagar);
    }
    
    public void excluir(Contaspagar contasPagar) throws SQLException{
        contasPagarDao = new ContasPagarDao();
        contasPagarDao.excluir(contasPagar);
    }
    
    public List<Contaspagar> listarContas(String sql) throws SQLException{
        contasPagarDao = new ContasPagarDao();
        return contasPagarDao.listarContas(sql);
    }
    
    public Formacontaspagar salvarFormaContasPagar(Formacontaspagar formacontaspagar) throws SQLException{
        contasPagarDao = new ContasPagarDao();
        return contasPagarDao.salvarFormaContasPagar(formacontaspagar);
        
    }
    
    public Pagamentocontaspagar salvarPagamentoContasPagar(Pagamentocontaspagar pagamentocontaspagar) throws SQLException{
        contasPagarDao = new ContasPagarDao();
        return contasPagarDao.salvarPagamentoContasPagar(pagamentocontaspagar);
    }
    
    public Float calcularValorContaPagarDia(String data) throws SQLException{
        contasPagarDao = new ContasPagarDao();
        return contasPagarDao.calcularValorContaPagarDia(data);
    }
    
    public List<Viewcontaspagar> listarContasView(String sql) throws SQLException{
        contasPagarDao = new ContasPagarDao();
        return contasPagarDao.listarContasView(sql);
    }
    
    public ResultSet ExportarExcel(String nomeRelatorio, String local, String porta, String senha, String banco, String usuario, String caminhoSalvarExcel, String sql) throws IOException {
        contasPagarDao = new ContasPagarDao();
        return contasPagarDao.ExportarExcel(nomeRelatorio, local, porta, senha, banco, usuario, caminhoSalvarExcel, sql);
    }
}
