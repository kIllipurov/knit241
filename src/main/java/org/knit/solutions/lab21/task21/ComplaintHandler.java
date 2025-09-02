package org.knit.solutions.lab21.task21;

public abstract class ComplaintHandler {
    protected ComplaintHandler nextHandler;

    public void setNextHandler(ComplaintHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleComplaint(Complaint complaint) {
        if (canHandle(complaint)) {
            process(complaint);
        } else if (nextHandler != null) {
            nextHandler.handleComplaint(complaint);
        } else {
            System.out.println("Жалоба \"" + complaint.getDescription() +
                    "\" слишком сложная. Не удалось решить.");
        }
    }

    protected abstract boolean canHandle(Complaint complaint);
    protected abstract void process(Complaint complaint);
}
