package org.knit.solutions.lab5.task514;
import org.knit.solutions.lab5.task514.FileSystemElement;

public class File implements FileSystemElement {
    private final String name;
    private final int size; // размер в байтах

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}