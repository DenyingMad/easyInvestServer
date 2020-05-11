package com.cgpanda.EasyInvestServer;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;

public class ApiGenerator {

    private static String apiKey;

    private static String generateApi() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return DatatypeConverter.printHexBinary(encoded).toLowerCase();
    }

    public static String getApiKey() {
        try {
            setApiKey(generateApi());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return apiKey;
    }

    private static void setApiKey(String newApiKey) {
        apiKey = newApiKey;
    }
}
