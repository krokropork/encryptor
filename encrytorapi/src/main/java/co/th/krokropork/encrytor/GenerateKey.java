package co.th.krokropork.encrytor;

import sun.security.util.Password;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;

/**
 * Created by user on 26/6/2560.
 */
public class GenerateKey {

    private static GenerateKey ourInstance = new GenerateKey();

    public static GenerateKey getInstance() {
        return ourInstance;
    }

    private GenerateKey() {
    }


    public SecretKeySpec generateKey(String key,String pass,int iterationCount,int length) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        char[] password = pass.toCharArray();
        byte[] salt =key.getBytes("UTF-8");
        KeySpec spec = new PBEKeySpec(password, salt, iterationCount, length);
        SecretKey tmp = factory.generateSecret(spec);
        byte[] encoded = tmp.getEncoded();
        return new SecretKeySpec(encoded, "AES");

    }
}
