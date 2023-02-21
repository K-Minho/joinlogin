package shop.mtcoding.loginjoin.util;

import org.junit.jupiter.api.Test;

public class ShaTest {

      @Test
      public void sha256_Test() throws Exception {
            String password1 = "1234";
            String password2 = "12345";
            Sha sha = new Sha();

            String hash1 = sha.sha256(password1);
            String hash2 = sha.sha256(password2);

            System.out.println(hash1);
            System.out.println(hash2);
      }
}
