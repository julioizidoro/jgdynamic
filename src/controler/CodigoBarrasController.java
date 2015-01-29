/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.CodigoBarrasDao;
import facade.CodigoBarrasFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CodigoBarras;
import org.springframework.core.env.JOptCommandLinePropertySource;

/**
 *
 * @author wolverine
 */
public class CodigoBarrasController {
    
    CodigoBarrasFacade codigoBarrasFacade;
    
    public CodigoBarras salvar(CodigoBarras codigoBarras) {
        codigoBarrasFacade = new CodigoBarrasFacade();
        try {
            return codigoBarrasFacade.salvar(codigoBarras);
        } catch (SQLException ex) {
            Logger.getLogger(CodigoBarrasController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Salvar Codiog Barras "  + ex);
            return null;
        }
    }
    
    public CodigoBarras pesquisarCodigo(String barras) {
        codigoBarrasFacade = new CodigoBarrasFacade();
        try {
            return codigoBarrasFacade.pesquisarCodigo(barras);
        } catch (SQLException ex) {
            Logger.getLogger(CodigoBarrasController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Pesquisar Codiog Barras "  + ex);
            return null;
        }
    }
    
    public List<CodigoBarras> pesquisarProduto(int idProduto) {
        codigoBarrasFacade = new CodigoBarrasFacade();
        try {
            return codigoBarrasFacade.pesquisarProduto(idProduto);
        } catch (SQLException ex) {
            Logger.getLogger(CodigoBarrasController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Pesquisar Codiog Barras "  + ex);
            return null;
        }
    }
    
    public void excluirCodigoBarras(CodigoBarras codigoBarras) {
        codigoBarrasFacade = new CodigoBarrasFacade();
        try {
            codigoBarrasFacade.excluirCodigoBarras(codigoBarras);
        } catch (SQLException ex) {
            Logger.getLogger(CodigoBarrasController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Salvar Codiog Barras "  + ex);
        }
    }
    
}
