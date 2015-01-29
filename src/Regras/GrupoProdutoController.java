/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.GrupoProdutoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Grupoproduto;
import model.Subgrupoproduto;

/**
 *
 * @author Wolverine
 */
public class GrupoProdutoController {
    
    public Subgrupoproduto consultarSubGrupoProduto(int idSubGrupo) {
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            return grupoProdutoFacade.consultarSubGrupoProduto(idSubGrupo);
        } catch (SQLException ex) {
            Logger.getLogger(GrupoProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Subgrupo de Produto " + ex);
            return null;
        }
    }
    
    public Grupoproduto consultarGrupoProduto(int idGrupo) {
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            return grupoProdutoFacade.consultarGrupoProduto(idGrupo);
        } catch (SQLException ex) {
            Logger.getLogger(GrupoProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Consultar Subgrupo Produto " + ex);
            return null;
        }
    }
    
    public List<Grupoproduto> listarGrupoProduto() {
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            return grupoProdutoFacade.listarGrupoProduto();
         } catch (Exception ex) {
            Logger.getLogger(GrupoProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Listar Grupo Produto " + ex);
            return null;
        }
    }
    
    public List<Subgrupoproduto> listSubGrupoProduto(int idGrupo) {
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            return grupoProdutoFacade.listarSubGrupoProduto(idGrupo);
         } catch (Exception ex) {
            Logger.getLogger(GrupoProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Listar SubGrupo Produto " + ex);
            return null;
        }
    }
    
    public void salvarGrupoProduto(Grupoproduto grupoProduto)  {
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            grupoProdutoFacade.salvarGrupoProduto(grupoProduto);
         } catch (Exception ex) {
            Logger.getLogger(GrupoProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Salvar Grupo Produto " + ex);
        }
    }
    
    public void salvarSubGrupoProduto(Subgrupoproduto subGrupoProduto)  {
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            grupoProdutoFacade.salvarSubGrupoProduto(subGrupoProduto);
         } catch (Exception ex) {
            Logger.getLogger(GrupoProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Salvar SubGrupo Produto " + ex);
        }
    }
    
}
