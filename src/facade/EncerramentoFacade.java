/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EncerramentoDao;
import java.sql.SQLException;
import java.util.List;
import model.Encerramento;
import model.Inventario;

/**
 *
 * @author Wolverine
 */
public class EncerramentoFacade {
    
    private EncerramentoDao encerramentoDao;
    
    
    public Encerramento salvar(Encerramento encerramento) throws SQLException{
        encerramentoDao = new EncerramentoDao();
        return encerramentoDao.salvar(encerramento);
    }
    
    public List<Encerramento> listar() throws SQLException{
        encerramentoDao = new EncerramentoDao();
        return encerramentoDao.listar();
    }
    
    public void salvar(Inventario inventario) throws SQLException{
        encerramentoDao = new EncerramentoDao();
        encerramentoDao.salvar(inventario);
    }
    
    public List<Inventario> listar(int idEncerramento) throws SQLException{
        encerramentoDao = new EncerramentoDao();
        return encerramentoDao.listar(idEncerramento);
    }
    
    
}
