/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.PlanoContaDao;
import java.util.List;
import javax.swing.plaf.metal.MetalBorders.PaletteBorder;
import model.Planoconta;

/**
 *
 * @author Wolverine
 */
public class PlanoContaFacade {
    
    private PlanoContaDao planoContaDao;

     public List<Planoconta> consultarPlanoconta(String descricao) throws Exception{
         planoContaDao = new PlanoContaDao();
         return planoContaDao.consultarPlanoconta(descricao);

    }

    public List<Planoconta> consultarPlanoconta() throws Exception{
         planoContaDao = new PlanoContaDao();
         return planoContaDao.consultarPlanoconta();
    }

    public Planoconta consultarPlanoconta(int idPlanoContas) throws Exception{
         planoContaDao = new PlanoContaDao();
         return planoContaDao.consultarPlanoconta(idPlanoContas);
    }

    public void excluirPlanoconta(Planoconta planoConta) throws  Exception{
         planoContaDao = new PlanoContaDao();
         planoContaDao.excluirPlanoconta(planoConta);
    }

    public void salvarPlanoconta(Planoconta Planoconta) throws Exception {
         planoContaDao = new PlanoContaDao();
         planoContaDao.salvarPlanoconta(Planoconta);
    }

    public Planoconta consultarPlanocontaNuemroConta(String numeroConta) throws Exception{
        planoContaDao = new PlanoContaDao();
        return planoContaDao.consultarPlanocontaNuemroConta(numeroConta);
    }

}
