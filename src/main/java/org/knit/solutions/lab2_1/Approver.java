package org.knit.solutions.lab2_1;

public abstract class Approver {
    protected Approver nextApprover; // Следующий обработчик в цепочке

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(int amount) {
        if (canApprove(amount)) {
            approve(amount);
        } else if (nextApprover != null) {
            nextApprover.processRequest(amount); // Передача запроса дальше
        } else {
            System.out.println("Запрос на сумму $" + amount + " отклонен: превышает лимит.");
        }
    }

    protected abstract boolean canApprove(int amount); // Проверка лимита
    protected abstract void approve(int amount); // Логика одобрения
}
