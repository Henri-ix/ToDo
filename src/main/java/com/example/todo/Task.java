package com.example.todo;

public class Task implements Comparable<Task> {

    private int priority,ID;
    private String taskName,taskDescription;
    private boolean completed;

    public Task(String taskName,String taskDescription,boolean completed,int priority,int ID){
            this.taskName = taskName;
            this.taskDescription = taskDescription;
            this.completed = completed;
            this.priority = priority;
            this.ID = ID;
    }
    protected String getTaskName(){
        return taskName;
    }

    protected String getTaskDescription(){
        return taskDescription;
    }

    protected boolean getCompleted(){
        return completed;
    }

    protected  int getPriority(){
        return priority;
    }

    protected void setCompleted(){
        this.completed = true;
    }

    protected void setPriority(int priority){
        this.priority = priority;
    }

    @Override public int compareTo(Task t){
        if (this.priority>t.priority){
            return (1);
        }
        else if (this.priority<t.priority){
            return(-1);
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return taskName;
    }
}
