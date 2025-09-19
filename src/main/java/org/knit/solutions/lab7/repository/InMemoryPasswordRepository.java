package org.knit.solutions.lab7.repository;
import org.knit.solutions.lab7.model.PasswordEntry;
import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class InMemoryPasswordRepository implements PasswordRepository {
    private final Map<String, PasswordEntry> map = new HashMap<>();
    private final Gson gson = new Gson();

    @Override
    public void save(PasswordEntry entry) { map.put(entry.getSite(), entry); }

    @Override
    public Optional<PasswordEntry> findBySite(String site) { return Optional.ofNullable(map.get(site)); }

    @Override
    public void deleteBySite(String site) { map.remove(site); }

    @Override
    public Collection<PasswordEntry> findAll() { return Collections.unmodifiableCollection(map.values()); }

    @Override
    public void loadFromBytes(byte[] data) throws Exception {
        if (data == null || data.length == 0) return;
        PasswordEntry[] arr = gson.fromJson(new String(data, StandardCharsets.UTF_8), PasswordEntry[].class);
        map.clear();
        if (arr != null) for (PasswordEntry e : arr) map.put(e.getSite(), e);
    }

    @Override
    public byte[] dumpToBytes() throws Exception {
        PasswordEntry[] arr = map.values().toArray(new PasswordEntry[0]);
        return gson.toJson(arr).getBytes(StandardCharsets.UTF_8);
    }
}