/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.PlanoContaFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Planoconta;

/**
 *
 * @author Wolverine
 */
public class PlanoContaController {
    
    PlanoContaFacade planoContaFacade;
    
    public List<Planoconta> consultarPlanoconta(String descricao){
        planoContaFacade = new PlanoContaFacade();
        try {
            return planoContaFacade.consultarPlanoconta(descricao);
        } catch (Exception ex) {
            Logger.getLogger(PlanoContaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Plano de Contas "  + ex);
            return null;
        }
      
    }

    public List<Planoconta> consultarPlanoconta() throws Exception{
      planoContaFacade = new PlanoContaFacade();
        try {
            return planoContaFacade.consultarPlanoconta();
        } catch (Exception ex) {
            Logger.getLogger(PlanoContaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Plano de Contas "  + ex);
            return null;
        }
      
    }
    
    public Planoconta consultarPlanoconta(int idPlanoContas) {
         planoContaFacade = new PlanoContaFacade();
        try {
            return planoContaFacade.consultarPlanoconta(idPlanoContas);
        } catch (Exception ex) {
            Logger.getLogger(PlanoContaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Plano de Contas "  + ex);
            return null;
        }
    }
    
    public Planoconta consultarPlanocontaNuemroConta(String numeroConta){
         planoContaFacade = new PlanoContaFacade();
        try {
            return planoContaFacade.consultarPlanocontaNuemroConta(numeroConta);
        } catch (Exception ex) {
            Logger.getLogger(PlanoContaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Plano de Contas "  + ex);
            return null;
        }
    }



    public void excluirPlanoconta(Planoconta planoConta) {
         planoContaFacade = new PlanoContaFacade();
        try {
            planoContaFacade.excluirPlanoconta(planoConta);
        } catch (Exception ex) {
            Logger.getLogger(PlanoContaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Plano de Contas "  + ex);
        }
    }

    public void salvarPlanoconta(Planoconta Planoconta)  {
         planoContaFacade = new PlanoContaFacade();
        try {
            planoContaFacade.salvarPlanoconta(Planoconta);
        } catch (Exception ex) {
            Logger.getLogger(PlanoContaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Plano de Contas "  + ex);
        }
    }

    
}
