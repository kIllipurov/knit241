package org.knit.solutions.lab7.repository;
import org.knit.solutions.lab7.model.PasswordEntry; // изменить
import java.util.Collection;
import java.util.Optional;

public interface PasswordRepository {
    void save(PasswordEntry entry);
    Optional<PasswordEntry> findBySite(String site);
    void deleteBySite(String site);
    Collection<PasswordEntry> findAll();
    void loadFromBytes(byte[] data) throws Exception;
    byte[] dumpToBytes() throws Exception;
}
