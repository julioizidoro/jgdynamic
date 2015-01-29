/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber.Relatorios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class RelatorioContasReceber {
    
   private static List<RelContasReceberTodas> listaTodas;

    public RelatorioContasReceber() {
        this.listaTodas = new ArrayList<RelContasReceberTodas>();
    }

    public static List<RelContasReceberTodas> getListaTodas() {
        return listaTodas;
    }

    public static void setListaTodas(List<RelContasReceberTodas> listaTodas) {
        RelatorioContasReceber.listaTodas = listaTodas;
    }

    
    
    public static List<RelContasReceberTodas>getLista(){
        return listaTodas;
    }
}
