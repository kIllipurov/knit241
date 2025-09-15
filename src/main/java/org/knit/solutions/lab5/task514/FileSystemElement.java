package org.knit.solutions.lab5.task514;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}