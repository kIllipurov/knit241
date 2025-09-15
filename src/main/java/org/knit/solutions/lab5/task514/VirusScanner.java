package org.knit.solutions.lab5.task514;

public class VirusScanner implements FileSystemVisitor {

    @Override
    public void visit(File file) {
        try {
            System.out.println("Scanning file: " + file.getName() + " for viruses...");
            Thread.sleep(500); // имитация времени сканирования
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(file.getName() + " не заражен");
    }

    @Override
    public void visit(Folder folder) {
        System.out.println("Scanning folder: " + folder.getName());
        for (FileSystemElement child : folder.getChildren()) {
            child.accept(this); // рекурсивно сканируем всё содержимое
        }
        System.out.println("Finished scanning folder: " + folder.getName());
    }

    @Override
    public void visit(Shortcut shortcut) {
        System.out.println("Skipping shortcut: " + shortcut.getName());
    }
}