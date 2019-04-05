package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {

		// Create a program that takes a message from the user and saves it to a file.
		try {

			FileWriter fw1 = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt");
			fw1.write(JOptionPane.showInputDialog("Write to a file."));

			fw1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
