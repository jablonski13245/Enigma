package factories;

import Ciphers.Cipher;

public interface Factory {
    Cipher create(String type);
}
