import Ciphers.Impl.Root_13Cipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Root13CipherTest {

    protected final String mixedText = "123abc//♥ł";
    protected final String expectedTextForMixedText = "123nop//♥ł";
    protected final String Text = "nOp";
    protected final String expectedText = "aBc";

    protected Root_13Cipher root_13Cipher = new Root_13Cipher();

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testWithTextForMixedText(){
        String decode = root_13Cipher.decode(mixedText);
        Assertions.assertEquals(expectedTextForMixedText, decode);
    }
    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncode(){
        String encode = root_13Cipher.encode(Text);
        Assertions.assertEquals(expectedText, encode );
    }

}
