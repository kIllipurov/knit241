package org.knit.solutions.lab7.security;

public class MasterPasswordHolder {
    private char[] master;

    public MasterPasswordHolder(char[] master) { this.master = master; }

    public char[] get() { return master; }

    public void clear() {
        if (master != null) {
            java.util.Arrays.fill(master, '\0');
            master = null;
        }
    }
}