package org.knit.solutions.lab5.task514;

public class SizeAnalyzer implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Folder folder) {
        for (FileSystemElement child : folder.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(Shortcut shortcut) {
        // ссылки не учитываются
    }

    public int getTotalSize() {
        return totalSize;
    }
}