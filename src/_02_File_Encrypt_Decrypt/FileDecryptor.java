package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.

	public static void main(String[] args) {
		String code = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/EncryptedText.txt"));

			String line = br.readLine();
			while (line != null) {
				code += line;
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String t = "";

		System.out.println(code.length());
		for (int i = 0; i < code.length(); i++) {
			t += code.substring(code.length() - i - 1, code.length() - i);
		}
		System.out.println(t);
	}

}
