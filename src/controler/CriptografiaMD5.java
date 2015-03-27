/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Acer
 * classes que especificam qual tipo de algoritmo irá ser utilizado.
Primeiro vou criar a classe para o algoritmo MD5.
 */
public class CriptografiaMD5 extends CriptografiaGenerica implements Criptografia1{

    public String encrypt(String value) throws NoSuchAlgorithmException {
        return encryptByAlgorithm("MD5", value);
    }


}
