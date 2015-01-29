/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.GrupoContaDao;
import java.util.List;
import model.Grupoconta;


/**
 *
 * @author Wolverine
 */
public class GrupoContaFacade {

    private GrupoContaDao grupoContaDao;

    public List<Grupoconta> consultarGrupoconta(String descricao) throws Exception{
        grupoContaDao = new GrupoContaDao();
        return grupoContaDao.consultarGrupoconta(descricao);

    }

    public List<Grupoconta> consultarGrupoconta() throws Exception{
         grupoContaDao = new GrupoContaDao();
         return grupoContaDao.consultarGrupoconta();

    }

    public Grupoconta consultarGrupoconta(int idgrupoConta) throws Exception{
         grupoContaDao = new GrupoContaDao();
         return grupoContaDao.consultarGrupoconta(idgrupoConta);
    }

    public void excluirGrupoconta(Grupoconta grupoConta) throws  Exception{
         grupoContaDao = new GrupoContaDao();
         grupoContaDao.excluirGrupoconta(grupoConta);
    }

    public void salvarGrupoconta(Grupoconta grupoConta) throws Exception {
        grupoContaDao = new GrupoContaDao();
        grupoContaDao.salvarGrupoconta(grupoConta);
    }

}
