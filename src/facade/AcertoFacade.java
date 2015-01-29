/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.AcertoDao;
import model.Acerto;

/**
 *
 * @author Wolverine
 */
public class AcertoFacade {
    
    AcertoDao acertoDao;
    
    public void salvar(Acerto acerto) throws  Exception{
        acertoDao = new AcertoDao();
        acertoDao.salvar(acerto);
    }
    
}
