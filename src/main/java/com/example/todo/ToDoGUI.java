package com.example.todo;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ToDoGUI {
    JFrame frame;
    JPanel tasksPanel;
    JPanel descPanel;
    JList<Task> tasks;
    public ToDoGUI(TaskMaster master){
        frame = new JFrame();
        tasksPanel = new JPanel();
        descPanel = new JPanel();
        tasksPanel.setBackground(Color.YELLOW);
        descPanel.setBackground(Color.YELLOW);
        tasksPanel.setPreferredSize(new Dimension(100,75));
        descPanel.setPreferredSize(new Dimension(100,100));
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(50,50));
        tasks = taskList(master,label);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(new BorderLayout());
        tasksPanel.setLayout(new BorderLayout());
        descPanel.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setTitle("To-Do");
        frame.setVisible(true);
        tasks.setBackground(Color.YELLOW);
        tasks.setFont(new Font("Helvetica",Font.BOLD,15));
        tasksPanel.add(new JScrollPane(tasks),BorderLayout.CENTER);
        descPanel.add(label);
        frame.add(tasksPanel,BorderLayout.NORTH);
        frame.add(descPanel,BorderLayout.SOUTH);

    }

    public JList<Task> taskList(TaskMaster master,JLabel label){
        JList<Task> tasks = new JList<>();
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
        tasks.addListSelectionListener(e -> {
            Task taskChosen = tasks.getSelectedValue();
            viewTask(taskChosen,label);
        });

    return tasks;
    }

    public void viewTask(Task task,JLabel label){
        label.setText(task.getTaskDescription());
        System.out.println("added desc");
    }

}
