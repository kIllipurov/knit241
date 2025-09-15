package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab4.task413.*;

@TaskDescription(taskNumber = 413, taskDescription = "4.13 Умный дом (Command)")
public class Task413 implements Solution {
    @Override
    public void execute() {
        Light livingRoomLight = new Light("Living Room");
        TV livingRoomTV = new TV("Living Room");

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command tvOn = new TVOnCommand(livingRoomTV);
        Command tvOff = new TVOffCommand(livingRoomTV);

        RemoteControl remote = new RemoteControl();

        // Обычные команды
        remote.pressButton(lightOn);
        remote.pressButton(tvOn);

        remote.undoLast(); // отмена TVOn → TVOff

        // Макрокоманда "Доброе утро"
        Command goodMorning = new MacroCommand(new Command[]{lightOn, tvOn});
        remote.pressButton(goodMorning);

        // Макрокоманда "Спокойной ночи"
        Command goodNight = new MacroCommand(new Command[]{lightOff, tvOff});
        remote.pressButton(goodNight);

        remote.undoLast(); // отмена "Спокойной ночи" → включает всё обратно
    }
}
