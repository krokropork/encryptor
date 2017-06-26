package co.th.krokropork.encrytor;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 26/6/2560.
 */
public class EncrytorTest {

    @Test
    public void encrypt() throws Exception {
        Assert.assertTrue(Encrytor.getInstance()!=null);
        Assert.assertEquals("test",Encrytor.getInstance().Decrypt (Encrytor.getInstance().Encrypt("test")));
        System.out.println(Encrytor.getInstance().Encrypt("test"));
        System.out.println(Encrytor.getInstance().Decrypt (Encrytor.getInstance().Encrypt("test")));
    }



}