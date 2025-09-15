package org.knit.solutions.lab5.task514;

public class Shortcut implements FileSystemElement {
    private final String name;
    private final FileSystemElement target;

    public Shortcut(String name, FileSystemElement target) {
        this.name = name;
        this.target = target;
    }

    public FileSystemElement getTarget() {
        return target;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}