package org.knit.solutions.lab7.config;

import org.springframework.context.annotation.*;
import  org.knit.solutions.lab7.repository.*;
import  org.knit.solutions.lab7.crypto.*;
import  org.knit.solutions.lab7.security.*;
import  org.knit.solutions.lab7.clipboard.*;
import  org.knit.solutions.lab7.service.PasswordService;

import java.nio.file.Paths;

@Configuration
public class AppConfig {
    @Bean public PasswordRepository passwordRepository() { return new InMemoryPasswordRepository(); }
    @Bean public EncryptionService encryptionService() { return new AesEncryptionService(); }
    @Bean public ClipboardService clipboardService() { return new SystemClipboardService(); }
    @Bean
    public PasswordService passwordService(PasswordRepository repo,
                                           EncryptionService crypto,
                                           MasterPasswordHolder holder,
                                           ClipboardService clipboard) {
        return new PasswordService(repo, crypto, holder, clipboard, Paths.get("passwords.db"));
    }
}