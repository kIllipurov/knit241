package org.knit.solutions.lab7.service;

import org.knit.solutions.lab7.repository.PasswordRepository;
import org.knit.solutions.lab7.model.PasswordEntry;
import org.knit.solutions.lab7.crypto.EncryptionService;
import org.knit.solutions.lab7.security.MasterPasswordHolder;
import org.knit.solutions.lab7.clipboard.ClipboardService;

import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class PasswordService {
    private final PasswordRepository repo;
    private final EncryptionService crypto;
    private final MasterPasswordHolder masterHolder;
    private final ClipboardService clipboard;
    private final Path storageFile;

    public PasswordService(PasswordRepository repo,
                           EncryptionService crypto,
                           MasterPasswordHolder masterHolder,
                           ClipboardService clipboard,
                           Path storageFile) {
        this.repo = repo;
        this.crypto = crypto;
        this.masterHolder = masterHolder;
        this.clipboard = clipboard;
        this.storageFile = storageFile;
    }

    public void load() throws Exception {
        if (!Files.exists(storageFile)) return;
        byte[] blob = Files.readAllBytes(storageFile);
        byte[] clear = crypto.decrypt(new String(blob), masterHolder.get());
        repo.loadFromBytes(clear);
        Arrays.fill(clear, (byte)0);
    }

    public void persist() throws Exception {
        byte[] plain = repo.dumpToBytes();
        String encrypted = crypto.encrypt(plain, masterHolder.get());
        Files.write(storageFile, encrypted.getBytes());
        Arrays.fill(plain, (byte)0);
    }

    public void add(String site, String login, String password) throws Exception {
        String enc = crypto.encrypt(password.getBytes(), masterHolder.get());
        PasswordEntry e = new PasswordEntry(site, login, enc);
        repo.save(e);
        persist();
    }

    public List<String> list() {
        return repo.findAll().stream()
                .map(e -> e.getSite() + " - " + e.getLogin())
                .collect(Collectors.toList());
    }

    public boolean delete(String site) throws Exception {
        Optional<PasswordEntry> opt = repo.findBySite(site);
        if (opt.isEmpty()) return false;
        repo.deleteBySite(site);
        persist();
        return true;
    }

    public boolean copyToClipboard(String site) throws Exception {
        Optional<PasswordEntry> opt = repo.findBySite(site);
        if (opt.isEmpty()) return false;
        PasswordEntry e = opt.get();
        byte[] plain = crypto.decrypt(e.getEncryptedPassword(), masterHolder.get());
        String password = new String(plain);
        Arrays.fill(plain, (byte)0);
        clipboard.copyToClipboard(password);
        return true;
    }
}