package org.knit.solutions;
import org.knit.solutions.lab5.task514.*;
import org.knit.TaskDescription;

@TaskDescription(taskNumber = 514, taskDescription = "5.14 Антивирус (Visitor)")
public class Task514 implements Solution {
    @Override
    public void execute() {
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.txt", 200);
        Folder folder = new Folder("Documents");
        folder.add(file1);
        folder.add(file2);

        Shortcut shortcut = new Shortcut("Shortcut to file1", file1);

        Folder root = new Folder("Root");
        root.add(folder);
        root.add(shortcut);

        // Визитор вирусов
        VirusScanner scanner = new VirusScanner();
        root.accept(scanner);

        System.out.println();

        // Визитор размера
        SizeAnalyzer analyzer = new SizeAnalyzer();
        root.accept(analyzer);
        System.out.println("Total size: " + analyzer.getTotalSize() + " bytes");
    }
}
