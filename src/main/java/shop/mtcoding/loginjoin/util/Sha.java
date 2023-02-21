package shop.mtcoding.loginjoin.util;

import java.security.MessageDigest;

public class Sha {

      public static String sha256(String password) throws Exception {
            MessageDigest mdsha = MessageDigest.getInstance("SHA-256");

            mdsha.update(password.getBytes("UTF-8"));

            byte[] HashByte = mdsha.digest();

            StringBuffer hash = new StringBuffer();

            for (byte b : HashByte) {
                  String hexString = String.format("%02x", b);
                  hash.append(hexString);
            }
            String passwordHash = hash.toString();

            return passwordHash;
      }

}
