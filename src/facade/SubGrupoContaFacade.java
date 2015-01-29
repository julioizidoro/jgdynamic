/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.SubGrupoContaDao;
import java.util.List;
import model.Subgrupo;



/**
 *
 * @author Wolverine
 */
public class SubGrupoContaFacade {
    
    SubGrupoContaDao subGrupoContaDao;

    
    public List<Subgrupo> consultarSubGrupoconta() throws Exception{
        subGrupoContaDao = new SubGrupoContaDao();
        return subGrupoContaDao.consultarSubGrupoconta();
    }

    public Subgrupo consultarSubGrupoconta(int idgrupoConta) throws Exception{
        subGrupoContaDao = new SubGrupoContaDao();
        return subGrupoContaDao.consultarSubGrupoconta(idgrupoConta);
    }

    public void excluirSubGrupoconta(Subgrupo grupoConta) throws  Exception{
        subGrupoContaDao = new SubGrupoContaDao();
        subGrupoContaDao.excluirSubGrupoconta(grupoConta);
    }

    public void salvarSubGrupoconta(Subgrupo grupoConta) throws Exception {
        subGrupoContaDao = new SubGrupoContaDao();
        subGrupoContaDao.salvarSubGrupoconta(grupoConta);
    }

}
