/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facadeRemoto;

import facade.*;
import daoRemoto.ProdutoRemotoDao;
import java.sql.SQLException;
import java.util.List;
import model.Produto;


/**
 *
 * @author Woverine
 */
public class ProdutoRemotoFacade {
    
    private ProdutoRemotoDao produtoDao;

    public List<Produto> consultarProduto() throws Exception{
        produtoDao = new ProdutoRemotoDao();
        return produtoDao.consultarProduto();
    }
    
    public List<Produto> listarProdutoImportacao() throws Exception{
        produtoDao = new ProdutoRemotoDao();
        return produtoDao.listarProdutoImportacao();
    }

    public Produto consultarProdutoid(int idProduto) throws Exception {
        produtoDao = new ProdutoRemotoDao();
        return produtoDao.consultarProdutoid(idProduto);
    }

    public List<Produto> consultarProduto(String descricao) throws Exception {
        produtoDao = new ProdutoRemotoDao();
        return produtoDao.consultarProduto(descricao);
    }

    public void salvarProduto(Produto produto) throws Exception {
        produtoDao = new ProdutoRemotoDao();
        produtoDao.salvarProduto(produto);
    }

     public int getIdProduto() throws Exception{
         produtoDao = new ProdutoRemotoDao();
         return produtoDao.getIdProduto();
     }

     public void excluir(Produto produto) throws Exception{
         produtoDao = new ProdutoRemotoDao();
         produtoDao.excluir(produto);
     }

      public Produto consultarProdutoReferencia(int referencia) throws Exception {
          produtoDao = new ProdutoRemotoDao();
          return produtoDao.consultarProdutoReferencia(referencia);
      }

      public Produto pesquisarCodigoFabricante(String codigoFabricante) throws SQLException, Exception{
          produtoDao = new ProdutoRemotoDao();
          return produtoDao.pesquisarCodigoFabricante(codigoFabricante);
      }

}
