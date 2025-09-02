package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab21.task21.*;

@TaskDescription(taskNumber = 21, taskDescription = "Паттерн Chain of Responsibility (Цепочка обязанностей)")
public class Task21 implements Solution {

    @Override
    public void execute() {
        ComplaintHandler callCenter = new CallCenter();
        ComplaintHandler manager = new Manager();
        ComplaintHandler seniorManager = new SeniorManager();
        ComplaintHandler legal = new LegalDepartment();

        // строим цепочку
        callCenter.setNextHandler(manager);
        manager.setNextHandler(seniorManager);
        seniorManager.setNextHandler(legal);

        // Запросы на обработку разных жалоб (аналог "junior.processRequest(500)")
        Complaint c1 = new Complaint("Не работает банкомат", 1);
        callCenter.handleComplaint(c1);   // Колл-центр решает

        Complaint c2 = new Complaint("Ошибка в списании средств", 2);
        callCenter.handleComplaint(c2);   // Менеджер решает

        Complaint c3 = new Complaint("Сбой в системе переводов", 3);
        callCenter.handleComplaint(c3);   // Старший менеджер решает

        Complaint c4 = new Complaint("Судебный иск клиента", 4);
        callCenter.handleComplaint(c4);   // Юридический отдел решает

        Complaint c5 = new Complaint("Хакерская атака на банк", 5);
        callCenter.handleComplaint(c5);   // Слишком сложно — никто не справился
    }
}
