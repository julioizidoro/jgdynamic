/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 *
 * classe abstrata que conterá o básico para efetuar uma criptografia,
 * contudo esta classe não será responsável por
 * determinal qual tipo de algoritmo será utilizado
 */
public abstract class CriptografiaGenerica {

    private MessageDigest messageDigest;
    private BASE64Encoder encoder;
    protected void useAlgorithm(String algorithm) throws NoSuchAlgorithmException {
        if (messageDigest == null || (! messageDigest.getAlgorithm().equals(algorithm))) {
            messageDigest = MessageDigest.getInstance(algorithm);
        }
        if (encoder == null) {
            encoder = new BASE64Encoder();
        }
    }

    protected String encryptByAlgorithm(String algorithm, String value)
        throws NoSuchAlgorithmException {
        if (value == null) {
            throw new IllegalArgumentException("O Valor é Nulo");
        }
        useAlgorithm(algorithm);
        byte[] hash = messageDigest.digest(value.getBytes());
        return encoder.encode(hash);
    }

}
