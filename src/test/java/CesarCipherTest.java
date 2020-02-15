import Ciphers.Cipher;
import Ciphers.Impl.CesarCipher;
import Ciphers.Impl.CesarCipher1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CesarCipherTest {
    protected final String textWithAlphabeticLetter = "def";
    protected String expectedTextForAlphabeticLetters = "abc";
    protected final String textwithsomething1 = "abcdd{{";
    String textActual1= "xyz";
    protected final String mixedText = "123abc//";
    protected final String expectedTextForMixedText = "123def//";
    protected final String textWithLetters = "123123";
    protected Cipher cesarCipher1 = new CesarCipher1();

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncode() {
        String decode = cesarCipher1.decode(textWithAlphabeticLetter);
        Assertions.assertEquals(expectedTextForAlphabeticLetters, decode);
    }
//    @DisplayName("Testing correction of encoding text with no alphabetic letters")
//    @Test
//    public void test1() {
//        String encode = cesarCipher1.decode(expectedTextForAlphabeticLetters);
//        Assertions.assertEquals(textActual1, encode);
//    }
    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void test2() {
        String encode = cesarCipher1.decode(textWithLetters);
        Assertions.assertEquals(textWithLetters, encode);
    }
    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void test3() {
        String decode = cesarCipher1.encode(mixedText);
        Assertions.assertEquals(expectedTextForMixedText, decode);
    }

}
