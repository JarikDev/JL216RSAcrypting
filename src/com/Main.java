package com;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class Main {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String s = "Hello world inshalllalalala";
        Cipher cipher = Cipher.getInstance("RSA");
        KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
        SecureRandom random=new SecureRandom();
        pairgen.initialize(512,random);
        KeyPair keyPair = pairgen.generateKeyPair();
        Key publicKey = keyPair.getPublic();
        Key privateKey = keyPair.getPrivate();

        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] bytes = cipher.doFinal(s.getBytes());
        for (byte b : bytes) {
            System.out.print(b);
        }
        System.out.println("\n" + "############################");
        Cipher decriptCipher = Cipher.getInstance("RSA");
        decriptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = decriptCipher.doFinal(bytes);
        for (byte b : decryptedBytes) {
            System.out.print((char) b);

        }
    }
}














































