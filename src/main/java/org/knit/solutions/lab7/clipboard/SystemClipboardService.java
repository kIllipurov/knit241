package org.knit.solutions.lab7.clipboard;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class SystemClipboardService implements ClipboardService {
    @Override
    public void copyToClipboard(String text) {
        try { Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null); }
        catch (HeadlessException ignored) {}
    }

    @Override
    public void clearClipboard() {
        try { Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(""), null); }
        catch (HeadlessException ignored) {}
    }
}