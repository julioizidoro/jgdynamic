/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Municipios;

/**
 *
 * @author wolverine
 */
public class MunicipiosDao {
    
    private EntityManager manager;
    
    public List<Municipios> listarMunicipios() throws SQLException {
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT m FROM Municipios m order by m.nomeMunicipio");
        List<Municipios> lista = q.getResultList();
        manager.close();
        return lista;
    }
    
    public List<Municipios> listarMunicipios(String nomeMunicipio) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT m FROM Municipios m where m.nomeMunicipio like '%" + nomeMunicipio + "%' order by m.nomeMunicipio");
        List<Municipios> lista = q.getResultList();
        manager.close();
        return lista;
    }
    
    public Municipios getMunicipio(int idMunicipio) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT m FROM Municipios m where m.idmunicipios=" + idMunicipio);
        Municipios municipios = null;
        if (q.getResultList().size()>0){
            municipios = (Municipios) q.getResultList().get(0);
        }
        manager.close();
        return municipios;
    }
    
}
