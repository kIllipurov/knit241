package org.knit.solutions.lab21.task21;

public class LegalDepartment extends ComplaintHandler {
    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getDifficulty() <= 4;
    }

    @Override
    protected void process(Complaint complaint) {
        System.out.println("Юридический отдел решил жалобу: " + complaint.getDescription());
    }
}
