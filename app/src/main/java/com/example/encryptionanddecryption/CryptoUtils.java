package com.example.encryptionanddecryption;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtils {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS7Padding";
    private static final String SECRET_KEY = "0123456789abcdefghijklmn";
    private static final String IV = "InitializationVT";

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKey secretKey = getSecretKey();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(IV.getBytes()));

        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.encodeToString(encryptedBytes, Base64.DEFAULT);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKey secretKey = getSecretKey();
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(IV.getBytes()));

        byte[] encryptedBytes = Base64.decode(encryptedData, Base64.DEFAULT);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    private static SecretKey getSecretKey() throws Exception {
        byte[] keyBytes = SECRET_KEY.getBytes();
        return new SecretKeySpec(keyBytes, ALGORITHM);
    }
}
