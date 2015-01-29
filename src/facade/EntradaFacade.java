/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.EntradaDao;
import java.sql.SQLException;
import java.util.List;
import model.Docentrada;
import model.Entradaproduto;
import model.Nfentrada;
import model.View.Viewentradaproduto;
import model.Vinculo;

/**
 *
 * @author Wolverine
 */
public class EntradaFacade {
    
     private EntradaDao entradaDao;

    public Docentrada salvarEntradaDoc(Docentrada docEntrada) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.salvarEntradaDoc(docEntrada);
    }

    public void salvarEntradaProduto(Entradaproduto entradaProduto) throws SQLException{
        entradaDao = new EntradaDao();
        entradaDao.salvarEntradaProduto(entradaProduto);
    }

    public Nfentrada salvarEntradaNF(Nfentrada nfEntrada) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.salvarEntradaNF(nfEntrada);
    }

    public Docentrada consultarEntrada(int idDocEntrada) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.consultarEntrada(idDocEntrada);
    }

    public void excluirEntradaProduto(Entradaproduto entradaProduto) throws SQLException{
        entradaDao = new EntradaDao();
        entradaDao.excluirEntradaProduto(entradaProduto);
    }
    
    public void excluirEntradaProduto(int idProdutoEntrada) throws SQLException{
        entradaDao = new EntradaDao();
        entradaDao.excluirEntradaProduto(idProdutoEntrada);
    }

    public void excluirDocEntrada(Docentrada docEntrada) throws SQLException{
        entradaDao = new EntradaDao();
        entradaDao.excluirDocEntrada(docEntrada);
    }

    public void excluirNotaEntrada(Nfentrada nfEntrada) throws SQLException{
        entradaDao = new EntradaDao();
        entradaDao.excluirNotaEntrada(nfEntrada);
    }

    public Vinculo pesquisarCodigoFabricante(int fornecedor, String codigoFabricante) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.pesquisarCodigoFabricante(fornecedor, codigoFabricante);
    }

    public int getIdEntrada() throws Exception {
        entradaDao = new EntradaDao();
        return entradaDao.getIdEntrada();
    }

    public List<Docentrada> pesquisarEntradaPeriodo(String dataInicio, String dataFim, int idEmpresa) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.pesquisarEntradaPeriodo(dataInicio, dataFim, idEmpresa);
    }
    
    public List<Docentrada> pesquisarEntradaPeriodoFornecedor(String dataInicio, String dataFim, int idFornecedor, int idEmpresa) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.pesquisarEntradaPeriodoFornecedor(dataInicio, dataFim, idFornecedor, idEmpresa);
    }
    
    public Vinculo pesquisarProduto(int idProduto, int idEmpresa, int idFornecedor) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.pesquisarProduto(idProduto, idEmpresa, idFornecedor);
    }
    
    public List<Docentrada> pesquisarEntradaSituacao(String situacao, int idEmpresa) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.pesquisarEntradaSituacao(situacao, idEmpresa);
    }
    
    public List<Entradaproduto> listarEntradaProduto(Docentrada docEntrada) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.listarEntradaProduto(docEntrada);
    }
    
    public Nfentrada consultarNotaFiscalEntrada(int idDocEntrada) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.consultarNotaFiscalEntrada(idDocEntrada);
    }
    
    public Nfentrada consultarNotaEntrada(int idNfEntrada) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.consultarNotaEntrada(idNfEntrada);
    }
    
    public List<Viewentradaproduto> viewListarEntradaProduto(Docentrada docEntrada) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.viewListarEntradaProduto(docEntrada);
    }
    
    public Entradaproduto getEntradaProduto(int idEntradaProduto) throws SQLException{
        entradaDao = new EntradaDao();
        return entradaDao.getEntradaProduto(idEntradaProduto);
    }
}
