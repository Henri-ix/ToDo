package com.example.todo;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class ToDoGUI {
    JFrame frame;
    JPanel tasksPanel;
    JPanel descPanel;
    JPanel buttonsPanel;
    JList<Task> tasks;
    HashMap<String,String> colors = new HashMap<>();

    public ToDoGUI(TaskMaster master){
        frame = new JFrame();
        tasksPanel = new JPanel();
        descPanel = new JPanel();
        buttonsPanel = new JPanel();
        tasksPanel.setBackground(new Color(251, 236, 80));
        descPanel.setBackground(new Color(251, 236, 80));
        buttonsPanel.setBackground(Color.DARK_GRAY);
        tasksPanel.setPreferredSize(new Dimension(100,75));
        descPanel.setPreferredSize(new Dimension(100,100));
        buttonsPanel.setPreferredSize(new Dimension(100,100));
        JButton addTask = new JButton("Add Task");
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(50,50));
        tasks = taskList(master,label);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(new BorderLayout());
        tasksPanel.setLayout(new BorderLayout());
        descPanel.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setTitle("To-Do");
        tasks.setBackground(Color.YELLOW);
        tasks.setFont(new Font("Helvetica",Font.BOLD,15));
        tasksPanel.add(new JScrollPane(tasks),BorderLayout.CENTER);
        descPanel.add(label);
        buttonsPanel.add(addTask);
        frame.add(tasksPanel,BorderLayout.NORTH);
        frame.add(descPanel,BorderLayout.CENTER);
        frame.add(buttonsPanel,BorderLayout.SOUTH);
        frame.setVisible(true);
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

        tasks.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
            JLabel selectedLabel = new JLabel(value.getTaskName());
            if (isSelected) {
                selectedLabel.setBackground(new Color(251, 236, 80));
                selectedLabel.setForeground(Color.DARK_GRAY);
            } else {
                selectedLabel.setBackground(Color.DARK_GRAY);
                selectedLabel.setForeground(new Color(251, 236, 80));
            }
            selectedLabel.setOpaque(true);
            return selectedLabel;

        });

    return tasks;
    }


    public void viewTask(Task task,JLabel label){
        label.setText(task.getTaskName() + " " + task.getTaskDescription() + " " + ((task.getCompleted())? "Complete" : "incomplete") + " " + task.getPriority());

    }

}
