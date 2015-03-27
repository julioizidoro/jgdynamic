/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanController;

import java.text.ParseException;

/**
 *
 * @author Wolverine
 */
public interface ILerNFe {
    
     void lerNotaFiscal()throws ParseException;
     void lerFornecedor()throws Exception;
     void lerDuplicatas()throws ParseException;
     void lerProdutos();
     
    
}
