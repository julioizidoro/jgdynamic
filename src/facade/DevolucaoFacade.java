/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.DevolucaoDao;
import java.sql.SQLException;
import java.util.List;
import model.Devolucao;
import model.Devolucaoproduto;
import model.Enviodevolucaodefeito;
import model.Enviodevolucaodefeitoproduto;
import model.Fechacaixa;
import view.Viewdevolucaodefeitoenviadas;
import view.Viewdevolucaodefeitoproduto;
import view.Viewrelatoriodevolucao;

/**
 *
 * @author Wolverine
 */
public class DevolucaoFacade {

    DevolucaoDao devolucaoDao;

    public void gravarDevolucao(Devolucao devolucao) throws Exception{
        devolucaoDao = new DevolucaoDao();
        devolucaoDao.gravarDevolucao(devolucao);
    }

    public void gravarDevolucaoProduto(Devolucaoproduto devolucaoProduto) throws Exception{
        devolucaoDao = new DevolucaoDao();
        devolucaoDao.gravarDevolucaoProduto(devolucaoProduto);
    }

    public Devolucao ultimaDevolucaoGravada() throws Exception {
        devolucaoDao = new DevolucaoDao();
        int iddevolucao = devolucaoDao.ultimaDevolucaoGravada();
        return devolucaoDao.getDevolucao(iddevolucao);
    }
    
    public List<Devolucao> getDevolucao(Fechacaixa fechaCaixa) throws Exception{
        devolucaoDao = new DevolucaoDao();
        return devolucaoDao.getDevolucao(fechaCaixa, "A VISTA");
    }
    
    public List<Devolucao> getDevolucaoPrazo(Fechacaixa fechaCaixa) throws Exception{
        devolucaoDao = new DevolucaoDao();
        return devolucaoDao.getDevolucao(fechaCaixa, "A PRAZO");
    }
    
    public List<Viewrelatoriodevolucao> relatorioDevolucao(String dataInicial, String dataFinal, int idProduto, String condicao) throws SQLException{
        devolucaoDao = new DevolucaoDao();
        return devolucaoDao.relatorioDevolucao(dataInicial, dataFinal, idProduto, condicao);
    }

    public List<Devolucao> valorDevolucaoPeriodo(String dataInicial, String dataFinal) throws Exception{
        devolucaoDao = new DevolucaoDao();
        return devolucaoDao.valorDevolucaoPeriodo(dataInicial, dataFinal);
    }
    
    public List<Viewdevolucaodefeitoproduto> listarDevolucaoDefeitoProduto(String sql) throws SQLException{
        devolucaoDao = new DevolucaoDao();
        return devolucaoDao.listarDevolucaoDefeitoProduto(sql);
    }
    
    public List<Viewdevolucaodefeitoenviadas> listarDevolucaoDefeitoEnviadas() throws SQLException{
        devolucaoDao = new DevolucaoDao();
        return devolucaoDao.listarDevolucaoDefeitoEnviadas();
    }
    
    public Enviodevolucaodefeito salvarEnvioDevolucao(Enviodevolucaodefeito enviodevolucaodefeito) throws SQLException{
        devolucaoDao = new DevolucaoDao();
        return devolucaoDao.salvarEnvioDevolucao(enviodevolucaodefeito);
    }
    
    public void salvarDevolucaoDefetio(int idDevolucaoDefeito, int idEnvio) throws SQLException{
        devolucaoDao = new DevolucaoDao();
        devolucaoDao.salvarDevolucaoDefetio(idDevolucaoDefeito, idEnvio);
    }
    
    public void salvarDevolucaoDefeitoProduto(Enviodevolucaodefeitoproduto enviodevolucaodefeitoproduto) throws SQLException{
        devolucaoDao = new DevolucaoDao();
        devolucaoDao.salvarDevolucaoDefeitoProduto(enviodevolucaodefeitoproduto);
    }
    
    public List<Enviodevolucaodefeito> listarEnvioDevolucaoDefeito(int idEmpresa) throws SQLException{
        devolucaoDao = new DevolucaoDao();
        return devolucaoDao.listarEnvioDevolucaoDefeito(idEmpresa);
    }
    
    public Enviodevolucaodefeito consultarEnvioDevolucaoDefeito(int idEnvio) throws SQLException{
        devolucaoDao= new DevolucaoDao();
        return devolucaoDao.consultarEnvioDevolucaoDefeito(idEnvio);
    }
}