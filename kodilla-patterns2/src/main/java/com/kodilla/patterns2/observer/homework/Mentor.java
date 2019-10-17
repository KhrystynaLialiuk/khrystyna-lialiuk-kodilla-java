package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(TaskQueue taskQueue) {
        updateCount++;
        System.out.println(mentorName + ": New task in the queue of " + taskQueue.getStudentName() + "\n" +
                "Unchecked tasks in this queue: " + taskQueue.getTasks().size() + "\n" +
                "Total: " + updateCount + " tasks to check.");
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
