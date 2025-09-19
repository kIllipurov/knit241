package org.knit.solutions.lab7.clipboard;

public interface ClipboardService {
    void copyToClipboard(String text);
    void clearClipboard();
}