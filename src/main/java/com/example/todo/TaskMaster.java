package com.example.todo;


import java.util.*;
import java.io.*;

public class TaskMaster
{
    ArrayList<Task> tasks;
    Scanner scan;
    BufferedReader br;
    BufferedWriter bw;

    public TaskMaster() throws IOException
    {
        tasks = new ArrayList<Task>();
        scan = new Scanner(System.in);
        try{
             br  = new BufferedReader(new FileReader("tasks.txt"));
             String line = br.readLine();
             while(line!=null){
                 String[] task = line.split(",");
                 Task t = new Task(task[0],task[1],Boolean.parseBoolean(task[2]),Integer.parseInt(task[3]),Integer.parseInt(task[4]));
                 tasks.add(t);
                 line = br.readLine();
             }
             br.close();
        }
        catch (FileNotFoundException e)
        {
             bw = new BufferedWriter(new FileWriter("tasks.txt"));
             bw.close();

        }
    }

    public ArrayList getTasks()
    {
        return tasks;
    }

    public void writeTask(String task){
        try {
            bw = new BufferedWriter(new FileWriter("tasks.txt",true));
            bw.write(task + "\n");
            bw.close();
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }

    protected Task viewTask(int taskNum){
        return tasks.get(taskNum-1);
    }

    protected void addTask()
    {
        while(true) {
            try {
                System.out.println("Enter the name of your task");
                String name = scan.nextLine();
                System.out.println("Enter the task's description");
                String desc = scan.nextLine();
                System.out.println("Completed? true or false");
                boolean completed = scan.nextBoolean();
                System.out.println("How important is this task from 0-4 (0 least 4 most)");
                int priority = scan.nextInt();
                scan.nextLine();
                System.out.println(name + "," + desc + "," + completed + "," + priority);
                writeTask(name + "," + desc + "," + completed + "," + priority + "," + (tasks.size()+1));
                tasks.add(new Task(name,desc,completed,priority,(tasks.size()+1)));
                break;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Invalid input\nCancel?");
                scan.nextLine();
                String choice = scan.nextLine();
                System.out.println(choice);
                if(choice.equals("yes"))
                {
                    break;
                }
            }
        }

    }
}

