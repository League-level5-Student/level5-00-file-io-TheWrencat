package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Write a message to encrypt.");
		String t = "";
		for (int i = 0; i < input.length(); i++) {
			t += input.substring(input.length() - i - 1, input.length() - i);

		}
		FileWriter fw;
		try {
			fw = new FileWriter("src/_02_File_Encrypt_Decrypt/EncryptedText.txt");
			fw.write(t);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
