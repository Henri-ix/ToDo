package com.example.todo;
import javax.swing.*;
import java.awt.*;

public class ToDoGUI {

    public ToDoGUI(TaskMaster master){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        JList tasks = taskList(master);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        panel.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setTitle("To-Do");
        frame.setVisible(true);
        tasks.setBackground(Color.YELLOW);
        tasks.setFont(new Font("Helvetica",Font.BOLD,15));
        panel.add(tasks);
        frame.add(panel);

    }

    public JList taskList(TaskMaster master){
        JList tasks = new JList();
        tasks.setModel(new AbstractListModel(){

            @Override
            public int getSize() {
                return master.getTasks().size();
            }

            @Override
            public Object getElementAt(int index) {
                return master.tasks.get(index);
            }
        });

    return tasks;
    }

}
