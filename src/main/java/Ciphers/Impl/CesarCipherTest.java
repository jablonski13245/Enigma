package Ciphers.Impl;

import Ciphers.Cipher;

public class CesarCipherTest {
    public static void main(String[] args) {
        Root_13Cipher r1 = new Root_13Cipher();
        System.out.println(r1.encode("abc"));
        System.out.println(r1.decode("nTm$"));

    }
}
