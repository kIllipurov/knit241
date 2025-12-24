package org.knit.solutions.lab21.task21;

public class Manager  extends ComplaintHandler {
    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getDifficulty() <= 2;
    }

    @Override
    protected void process(Complaint complaint) {
        System.out.println("Менеджер решил жалобу: " + complaint.getDescription());
    }
}
