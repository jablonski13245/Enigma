package Ciphers.Impl;

import Ciphers.Cipher;

public class CesarCipher implements Cipher {
    @Override
    public String encode(String textToEncode) {
        char[] lettersInMamaWord = textToEncode.toCharArray();
        StringBuilder stringBuilder= new StringBuilder();
        for (char letter : lettersInMamaWord){
            boolean isupperCase = Character.isUpperCase(letter);
            char codedLetter = Character.toUpperCase(letter);
            if(Character.isAlphabetic(letter)){
                if(codedLetter == 88){
                    codedLetter = 'A';
                }
                else if(codedLetter== 89){
                    codedLetter = 'B';
                }
                else if (codedLetter == 90){
                    codedLetter = 'C';
                }
                else {
                    codedLetter = (char)(codedLetter + 3);
                }
                if (!isupperCase){
                    codedLetter = Character.toLowerCase(codedLetter);
                }
                stringBuilder.append(codedLetter);
            } else{
                stringBuilder.append(letter);
            }
        }

        return stringBuilder.toString();
    }

    @Override
    public String decode(String textToDecode) {
        char[] lettersInMamaWord = textToDecode.toCharArray();
        StringBuilder stringBuilder= new StringBuilder();
        for (char letter : lettersInMamaWord){
            boolean isupperCase = Character.isUpperCase(letter);
            char codedLetter = Character.toUpperCase(letter);
            if(Character.isAlphabetic(letter)){
                if(codedLetter == 65){
                    codedLetter = 'X';
                }
                else if(codedLetter== 66){
                    codedLetter = 'Y';
                }
                else if (codedLetter == 67){
                    codedLetter = 'Z';
                }
                else {
                    codedLetter = (char)(codedLetter - 3);
                }
                if (!isupperCase){
                    codedLetter = Character.toLowerCase(codedLetter);
                }
                stringBuilder.append(codedLetter);
            } else{
                stringBuilder.append(letter);
            }
        }

        return stringBuilder.toString();
    }
}
