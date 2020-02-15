import Ciphers.Impl.CesarCipher;

public class Test {
    public static void main(String[] args) {
        CesarCipher cs = new CesarCipher();
        System.out.println(cs.encode("ASDzcqwz"));
        System.out.println(cs.decode("ADQWEasd"));
    }
}
