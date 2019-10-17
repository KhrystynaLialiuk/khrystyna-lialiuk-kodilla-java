package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;

public class TaskQueue implements Observable {
    private Observer observer;
    private final ArrayDeque<String> tasks;
    private final String studentName;

    public TaskQueue(String studentName) {
        tasks = new ArrayDeque<>();
        this.studentName = studentName;
    }

    public void addTask(String task) {
        tasks.offer(task);
        notifyObserver();
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public ArrayDeque<String> getTasks() {
        return tasks;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public void registerObserver(Observer observer) {
        setObserver(observer);
    }

    @Override
    public void notifyObserver() {
        observer.update(this);
    }

    @Override
    public void changeObserver(Observer observer) {
        setObserver(observer);
    }
}
