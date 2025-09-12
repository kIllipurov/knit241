package org.knit.solutions;
import org.knit.TaskDescription;
import org.knit.solutions.lab3.task310.Race;

@TaskDescription(taskNumber = 310, taskDescription = "3.10 Гонка CyclicBarrier")
public class Task310 implements Solution {
    @Override
    public void execute() {
        int runnerCount = 5;
        Race race = new Race(runnerCount);
        race.startRace();
    }
}

