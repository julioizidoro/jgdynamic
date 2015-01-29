/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ViewProdutoDao;
import java.sql.SQLException;
import java.util.List;
import telas.RelatoriosGerenciais.Relentradasaida;
import view.Viewprodutoentrada;
import view.Viewprodutosaida;

/**
 *
 * @author Wolverine
 */
public class ViewProdutoFacade {
    
    ViewProdutoDao viewProdutoDao;
    
    public List<Viewprodutoentrada> listarEntradas(String dataInicial, String dataFial) throws SQLException{
        viewProdutoDao = new ViewProdutoDao();
        return viewProdutoDao.listarEntradas(dataInicial, dataFial);
    }
    
    public List<Viewprodutosaida> listarSaidas(String dataInicial, String dataFial) throws SQLException{
        viewProdutoDao = new ViewProdutoDao();
        return viewProdutoDao.listarSaidas(dataInicial, dataFial);
    }
    
    public Relentradasaida consultaProduto(int idProduto) throws SQLException{
        viewProdutoDao = new ViewProdutoDao();
        return viewProdutoDao.consultaProduto(idProduto);
    }
    
    public void salvar(Relentradasaida produto) throws Exception{
        viewProdutoDao = new  ViewProdutoDao();
        viewProdutoDao.salvar(produto);
    }
    
     public void exluir(int idProduto) throws SQLException{
         viewProdutoDao = new ViewProdutoDao();
         viewProdutoDao.exluir(idProduto);
     }
     
     public List<Relentradasaida> listaRelEntradaSaida() throws SQLException{
         viewProdutoDao = new ViewProdutoDao();
         return viewProdutoDao.listaRelEntradaSaida();
     }
    
}
