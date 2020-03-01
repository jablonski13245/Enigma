package factories.impl;

import Ciphers.Cipher;
import Ciphers.Impl.CesarCipher1;
import Ciphers.Impl.Root_13Cipher;
import Ciphers.Impl.VigenereCipher;
import exceptions.CipherNotFoundException;
import factories.Factory;

public class CipherFactory implements Factory {
    public static final String CESAR = "CESAR";
    public static final String ROOT13 = "ROOT13";
    public static final String VIGENERE = "VIGENERE";

    @Override
    public Cipher create(String type) {
        if (type.equals(CESAR)) {
            return new CesarCipher1();
        }
        if (type.equals(ROOT13)) {
            return new Root_13Cipher();
        }
        if(type.equals(VIGENERE)){
            return new VigenereCipher();
        }
    throw new CipherNotFoundException(type);
    }
}
