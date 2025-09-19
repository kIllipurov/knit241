package org.knit.solutions.lab7.crypto;
import javax.security.auth.Destroyable;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.Base64;
import java.util.Map;
import com.google.gson.Gson;

public class AesEncryptionService implements EncryptionService {
    private static final String KDF_ALGO = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 65536;
    private static final int KEY_LEN = 256;
    private static final int SALT_LEN = 16;
    private static final int IV_LEN = 16;
    private final SecureRandom random = new SecureRandom();
    private final Gson gson = new Gson();

    @Override
    public String encrypt(byte[] plaintext, char[] masterPassword) throws Exception {
        byte[] salt = new byte[SALT_LEN]; random.nextBytes(salt);
        SecretKey key = deriveKey(masterPassword, salt);
        byte[] iv = new byte[IV_LEN]; random.nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] ciphertext = cipher.doFinal(plaintext);

        destroySecretKey(key);

        Map<String, String> map = Map.of(
                "salt", Base64.getEncoder().encodeToString(salt),
                "iv", Base64.getEncoder().encodeToString(iv),
                "ct", Base64.getEncoder().encodeToString(ciphertext)
        );
        return gson.toJson(map);
    }

    @Override
    public byte[] decrypt(String encryptedBlob, char[] masterPassword) throws Exception {
        Map map = gson.fromJson(encryptedBlob, Map.class);
        byte[] salt = Base64.getDecoder().decode((String) map.get("salt"));
        byte[] iv = Base64.getDecoder().decode((String) map.get("iv"));
        byte[] ct = Base64.getDecoder().decode((String) map.get("ct"));

        SecretKey key = deriveKey(masterPassword, salt);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] plain = cipher.doFinal(ct);

        destroySecretKey(key);
        return plain;
    }

    private SecretKey deriveKey(char[] password, byte[] salt) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LEN);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(KDF_ALGO);
        byte[] keyBytes = skf.generateSecret(spec).getEncoded();
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        java.util.Arrays.fill(keyBytes, (byte)0);
        spec.clearPassword();
        return key;
    }

    private void destroySecretKey(SecretKey key) {
        try { if (key instanceof Destroyable) ((Destroyable) key).destroy(); }
        catch (Exception ignored) {}
    }
}
