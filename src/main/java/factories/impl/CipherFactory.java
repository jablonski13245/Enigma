package factories.impl;

import Ciphers.Cipher;
import Ciphers.Impl.CesarCipher1;
import Ciphers.Impl.Root_13Cipher;
import exceptions.CipherNotFoundException;
import factories.Factory;

public class CipherFactory implements Factory {
    public static final String CESAR = "cesar";
    public static final String ROOT13 = "root13";

    @Override
    public Cipher create(String type) {
        if (type.equals(CESAR)) {
            return new CesarCipher1();
        }
        if (type.equals(ROOT13)) {
            return new Root_13Cipher();
        }
    throw new CipherNotFoundException(type);
    }
}
