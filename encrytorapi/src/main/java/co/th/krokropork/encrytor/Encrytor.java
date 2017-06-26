package co.th.krokropork.encrytor;

import com.sun.crypto.provider.SunJCE;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * Created by user on 26/6/2560.
 */
public class Encrytor {

    private static Encrytor encrypt;

    public static Encrytor getInstance() {
        if (encrypt == null) encrypt = new Encrytor();
        return encrypt;
    }

    private SecretKeySpec generateKey() throws Exception {
        //65536
        return   GenerateKey .getInstance().generateKey("a3Jva3JvcG9yaw==","Pass@word1",128,128);

    }

    private Cipher getCipher(int mode) throws Exception {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding", new SunJCE());
        //a random Init. Vector. just for testing
        byte[] iv = "e675f725e675f725".getBytes("UTF-8");

        c.init(mode, generateKey(), new IvParameterSpec(iv));
        return c;
    }

    public  String Encrypt(String raw) throws Exception {
        Cipher c = getCipher(Cipher.ENCRYPT_MODE);
        byte[] encryptedVal = c.doFinal(raw.getBytes("UTF-8"));
        return new BASE64Encoder().encode(encryptedVal);
    }

    public  String Decrypt(String encrypted) throws Exception {
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(encrypted);
        Cipher c = getCipher(Cipher.DECRYPT_MODE);
        byte[] decValue = c.doFinal(decodedValue);
        return new String(decValue);
    }




}
