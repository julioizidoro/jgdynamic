/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.BancoDao;
import java.util.List;
import model.Banco;

/**
 *
 * @author Wolverine
 */
public class BancoFacade {

    private BancoDao bancoDao;

    public void salvar(Banco banco) throws Exception {
        bancoDao = new BancoDao();
        bancoDao.salvar(banco);
    }

    public List<Banco> listar() throws Exception{
        bancoDao = new BancoDao();
        return bancoDao.listar();
    }

    public List<Banco> listar(String nomeAgencia) throws Exception{
        bancoDao = new BancoDao();
        return bancoDao.listar(nomeAgencia);
    }

}
