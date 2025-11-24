package stable.JEP_510_KeyDerivationFunctionAPI;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class KeyDerivationExample {
    static void main() throws Exception {
        char[] password = "hunter2".toCharArray();
        byte[] salt = "somesalt".getBytes();
        PBEKeySpec spec = new PBEKeySpec(password, salt, 65536, 256);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKey key = factory.generateSecret(spec);

        System.out.println("Derived key format: " + key.getFormat());
    }
}
