package _02_File_Encrypt_Decrypt;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Write a message to encrypt.");
		for (int i = 0; i < input.length(); i++) {
			String t = input.substring(i, i + 1);
			input += input.substring(input.length() - i, input.length() - i - 1);
		}
	}

}
