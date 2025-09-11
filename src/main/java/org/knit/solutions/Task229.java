package org.knit.solutions;
import org.knit.solutions.lab2.task29.*;
import org.knit.TaskDescription;

@TaskDescription(taskNumber = 229, taskDescription = "2.9 Конвейер сборки деталей")
public class Task229 implements Solution {
    @Override
    public void execute() {
        Conveyor conveyor = new Conveyor();
        conveyor.startProduction();
    }
}
