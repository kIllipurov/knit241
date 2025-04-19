package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_1.ChainOfResposibleApp;

@TaskDescription(taskNumber = 21, taskDescription = "Цепочка ответственности", href = "org.knit.solutions.Task2")
public class Task21 implements Solution{

    @Override
    public void execute() {
        ChainOfResposibleApp chainOfResposibleApp = new ChainOfResposibleApp();
        chainOfResposibleApp.runChain();

    }
}
