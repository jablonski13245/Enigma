package factoryTest;

import Ciphers.Cipher;
import Ciphers.Impl.CesarCipher1;
import Ciphers.Impl.Root_13Cipher;
import exceptions.CipherNotFoundException;
import factories.Factory;
import factories.impl.CipherFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CipherFactoryTest {
    private CipherFactory factory = new CipherFactory();
    private static final String MESSAGE = "Type of cipher is not recognized: ";

    @Test
    protected void ifCesarCipherInstanceReturnWithCesarTypeTest (){
        Cipher cipher = factory.create(CipherFactory.CESAR);
        Assertions.assertTrue(cipher instanceof CesarCipher1);
    }
    @Test
    protected void testRoot13 (){
        Cipher cipher = factory.create(CipherFactory.ROOT13);
        Assertions.assertTrue(cipher instanceof Root_13Cipher);
    }
//    @file.utils.Test
//    protected void testExceptions (){
//        Cipher cipher = factory.create("qwe");
//        Assertions.assertTrue(cipher instanceof Root_13Cipher);
//    }
    @Test
    protected void testExceptions2 (){
        String unkown = "unkown";
        Assertions.assertThrows(CipherNotFoundException.class, () ->factory.create(unkown),
             MESSAGE + unkown);
    }
}
