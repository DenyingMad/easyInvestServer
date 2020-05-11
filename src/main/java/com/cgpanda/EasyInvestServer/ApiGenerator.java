package com.cgpanda.EasyInvestServer;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;

public class ApiGenerator {

    private String apiKey;

    private static String generateApi() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return DatatypeConverter.printHexBinary(encoded).toLowerCase();
    }

    public String getApiKey() {
        try {
            setApiKey(generateApi());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return apiKey;
    }

    private void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
