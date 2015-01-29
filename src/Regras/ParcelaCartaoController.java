/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.ParcelaCartaoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Parcelacartao;

/**
 *
 * @author wolverine
 */
public class ParcelaCartaoController {
    ParcelaCartaoFacade parcelaCartaoFacade;
    
    public List<Parcelacartao> consultarParcelaCartao(String data, int idBanco) {
        parcelaCartaoFacade = new ParcelaCartaoFacade();
        try {
            return parcelaCartaoFacade.consultarParcelaCartao(data, idBanco);
        } catch (SQLException ex) {
            Logger.getLogger(ParcelaCartaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Listar parcela cartão " + ex);
            return null;
        }
    }
    
    public float calcularValorCArtaoBancoDia(String sql) {
        parcelaCartaoFacade = new ParcelaCartaoFacade();
        try {
            return parcelaCartaoFacade.calcularValorCArtaoBancoDia(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ParcelaCartaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Calcular Valor Cartão " + ex);
            return 0.0f;
        }
    }
}