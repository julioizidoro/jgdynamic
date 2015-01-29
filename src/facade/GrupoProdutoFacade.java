/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.GrupoProdutoDao;
import java.sql.SQLException;
import java.util.List;
import model.Grupoproduto;
import model.Subgrupoproduto;

/**
 *
 * @author wolverine
 */
public class GrupoProdutoFacade {

    GrupoProdutoDao grupoProdutoDao;

    public List<Grupoproduto> listarGrupoProduto() throws Exception{
        grupoProdutoDao = new GrupoProdutoDao();
        return grupoProdutoDao.listarGrupoProduto();
    }

    public List<Subgrupoproduto> listarSubGrupoProduto(int idGrupo) throws Exception{
        grupoProdutoDao = new GrupoProdutoDao();
        return grupoProdutoDao.listSubGrupoProduto(idGrupo);
    }
    
    public Subgrupoproduto consultarSubGrupoProduto(int idSubGrupo) throws SQLException{
        grupoProdutoDao = new GrupoProdutoDao();
        return grupoProdutoDao.consultarSubGrupoProduto(idSubGrupo);
    }
    
    public Grupoproduto consultarGrupoProduto(int idGrupo) throws SQLException{
        grupoProdutoDao = new GrupoProdutoDao();
        return grupoProdutoDao.consultarGrupoProduto(idGrupo);
    }
    
    public void salvarGrupoProduto(Grupoproduto grupoProduto) throws Exception {
        grupoProdutoDao = new GrupoProdutoDao();
        grupoProdutoDao.salvarGrupoProduto(grupoProduto);
    }
    
    public void salvarSubGrupoProduto(Subgrupoproduto subGrupoProduto) throws Exception {
        grupoProdutoDao = new GrupoProdutoDao();
        grupoProdutoDao.salvarSubGrupoProduto(subGrupoProduto);
    }
}
