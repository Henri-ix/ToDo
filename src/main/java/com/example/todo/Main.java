package com.example.todo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TaskMaster master = new TaskMaster();
        new ToDoGUI(master);
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println(master.getTasks());
            System.out.println("1. Display Tasks");
            System.out.println("2. View Task");
            System.out.println("3. Add Task");
            System.out.println("4. Quit");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println(master.getTasks());
                    continue;
                case 2:
                    System.out.println("What task would you like to view?");
                    Task task = master.viewTask(scan.nextInt());
                    System.out.println(task.getTaskName() + "," + task.getTaskDescription()+ "," +task.getCompleted()+ ","+task.getPriority());

                    continue;
                case 3:
                    master.addTask();
                    continue;
                case 4:
                    break;
            }
            break;
        }
    }
}
