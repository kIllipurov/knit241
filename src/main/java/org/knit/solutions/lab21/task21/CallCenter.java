package org.knit.solutions.lab21.task21;

public class CallCenter extends ComplaintHandler {
    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getDifficulty() <= 1;
    }

    @Override
    protected void process(Complaint complaint) {
        System.out.println("Колл-центр решил жалобу: " + complaint.getDescription());
    }
}
