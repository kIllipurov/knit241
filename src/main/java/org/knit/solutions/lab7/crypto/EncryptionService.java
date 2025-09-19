package org.knit.solutions.lab7.crypto;

public interface EncryptionService {
    String encrypt(byte[] plaintext, char[] masterPassword) throws Exception;
    byte[] decrypt(String encryptedBlob, char[] masterPassword) throws Exception;
}