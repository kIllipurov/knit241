package org.knit.solutions.lab7.model;

public class PasswordEntry {
    private String site;
    private String login;
    private String encryptedPassword;

    public PasswordEntry() {}

    public PasswordEntry(String site, String login, String encryptedPassword) {
        this.site = site;
        this.login = login;
        this.encryptedPassword = encryptedPassword;
    }

    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getEncryptedPassword() { return encryptedPassword; }
    public void setEncryptedPassword(String encryptedPassword) { this.encryptedPassword = encryptedPassword; }
}
