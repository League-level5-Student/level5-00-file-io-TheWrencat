package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {

	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame = new JFrame();

	JPanel panel = new JPanel();
	JButton addTask = new JButton();
	JButton viewTasks = new JButton();
	JButton removeTask = new JButton();
	JButton saveList = new JButton();
	JButton loadList = new JButton();
	ArrayList<String> currentTasks = new ArrayList<String>();

	public void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		addTask.setText("Add Task");
		viewTasks.setText("View Tasks");
		removeTask.setText("Remove Task");
		saveList.setText("Save List");
		loadList.setText("Load List");
		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		frame.pack();

	}

	public void loadList() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List.txt"));
			String line = br.readLine();
			while (line != null) {
				currentTasks.add(line);
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException g) {
			// TODO Auto-generated catch block
			g.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		list.setup();
		list.loadList();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addTask) {
			String t = JOptionPane.showInputDialog("Add a task to the ToDo List.");
			currentTasks.add(t);
		}
		if (e.getSource() == viewTasks) {
			String tasks = "";
			for (int i = 0; i < currentTasks.size(); i++) {
				tasks += (i + 1) + ". " + currentTasks.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, tasks);
		}
		if (e.getSource() == removeTask) {
			String tasks = "";
			for (int i = 0; i < currentTasks.size(); i++) {
				tasks += (i + 1) + ". " + currentTasks.get(i) + "\n";
			}
			String r = JOptionPane.showInputDialog("Choose a task to remove: \n" + tasks);
			int remove = Integer.parseInt(r) - 1;
			currentTasks.remove(remove);

		}
		if (e.getSource() == saveList) {
			String tasks = "";
			for (int i = 0; i < currentTasks.size(); i++) {
				tasks += currentTasks.get(i) + "\n";
				JOptionPane.showMessageDialog(null, "Current list saved");
			}
			FileWriter fw;
			try {
				fw = new FileWriter("src/_03_To_Do_List.txt");
				fw.write(tasks);
				fw.close();
			} catch (IOException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			}

		}
		if (e.getSource() == loadList) {
			loadList();
			JOptionPane.showMessageDialog(null, "Saved list loaded");

		}

	}

}
