package org.knit.solutions.lab21.task21;

public class SeniorManager extends ComplaintHandler {
    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getDifficulty() <= 3;
    }

    @Override
    protected void process(Complaint complaint) {
        System.out.println("Старший менеджер решил жалобу: " + complaint.getDescription());
    }
}
