/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.MunicipiosDao;
import java.sql.SQLException;
import java.util.List;
import model.Municipios;

/**
 *
 * @author wolverine
 */
public class MunicipiosFacade {
    
    MunicipiosDao municipiosDao;
    
    public List<Municipios> listarMunicipios() throws SQLException {
        municipiosDao = new MunicipiosDao();
        return municipiosDao.listarMunicipios();
    }
    
    public List<Municipios> listarMunicipios(String nomeMunicipio) throws SQLException  {
        municipiosDao = new MunicipiosDao();
        return municipiosDao.listarMunicipios(nomeMunicipio);
    }
    
    public Municipios getMunicipio(int idMunicipio) throws SQLException{
        municipiosDao = new MunicipiosDao();
        return (Municipios) municipiosDao.getMunicipio(idMunicipio);
    }
    
}
