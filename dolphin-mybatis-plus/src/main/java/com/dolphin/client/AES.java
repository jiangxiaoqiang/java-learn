package com.dolphin.client;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class AES {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding"; // 加密方法
 public static byte[] encrypt(byte[] key, byte[] data) throws Exception {
     SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);
     Cipher cipher = Cipher.getInstance(TRANSFORMATION);
     cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec); return cipher.doFinal(data); }

public static byte[] decrypt(byte[] key, byte[] data) throws Exception {
     SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);
     Cipher cipher = Cipher.getInstance(TRANSFORMATION);
     cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
     return cipher.doFinal(data);
 } }
