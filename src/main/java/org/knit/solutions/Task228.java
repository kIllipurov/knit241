package org.knit.solutions;
import org.knit.solutions.lab2.task28.*;
import org.knit.TaskDescription;

@TaskDescription(taskNumber = 228, taskDescription = "2.8 Перекресток: светофор и машины")
public class Task228 implements Solution {
    @Override
    public void execute() {
        Cross cross = new Cross();
        cross.startSimulation();
    }
}