import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

public class WordLength extends JFrame {
	JTextArea textarea;
	JButton button;
	JLabel label;
	private final JTextPane txtpnTypeInA = new JTextPane();

	public WordLength() {
		setLayout(new FlowLayout());

		textarea = new JTextArea(5, 30);
		add(textarea);

		button = new JButton("Enter!");
		add(button);

		label = new JLabel("");
		add(label);

		event e = new event();
		button.addActionListener(e);

		setTitle("Word Reverser");
		txtpnTypeInA.setBackground(SystemColor.menu);
		txtpnTypeInA
				.setText("Reverse the words according to their letter size");
		getContentPane().add(txtpnTypeInA, BorderLayout.SOUTH);
	}

	public class event implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String text = textarea.getText();
			ArrayList<String> listOfStrings = new ArrayList<String>();
			String temp1 = "";
			String temp4 = "";
			String temp2 = " ";
			String temp5 = "";
			int position = text.length();
			int z = 0;
			for (int y = text.length() - 1; y >= 0; y--) {
				String temp3 = text.substring(y, y + 1);
				if (y == 0 && position == text.length()) {
					temp5 = text;
				}
				if (y == 0) {
					temp4 = text.substring(0, position);
					for (int a = listOfStrings.size() - 1; a >= 0; a--) {
						if (listOfStrings.get(a).length() < temp4.length()) {
							if (a == 0) {
								listOfStrings.add(0, temp4);
							} else {
								listOfStrings.add(a - 1, temp4);
							}
						}
						if (listOfStrings.get(a).length() > temp4.length()) {
							listOfStrings.add(a + 1, temp4);
						}
						if (listOfStrings.get(a).length() == temp4.length()) {
							listOfStrings.add(a + 1, temp4);
						}
					}
				}
				if (temp3.equals(temp2) && z > 0) {
					temp4 = text.substring(y + 1, position);
					position = y;
					for (int a = listOfStrings.size() - 1; a >= 0; a--) {
						if (listOfStrings.get(a).length() < temp4.length()) {
							if (a == 0) {
								listOfStrings.add(0, temp4);
							} else {
								listOfStrings.add(a - 1, temp4);
							}
						}
						if (listOfStrings.get(a).length() > temp4.length()) {
							listOfStrings.add(a + 1, temp4);
						}
						if (listOfStrings.get(a).length() == temp4.length()) {
							listOfStrings.add(a + 1, temp4);
						}
					}
				}
				if (temp3.equals(temp2) && z == 0) {
					temp1 = text.substring(y + 1, position);
					listOfStrings.add(temp1);
					position = y;
					z++;
				}
			}
			for (int b = 0; b < listOfStrings.size(); b++) {
				temp5 = temp5 + listOfStrings.get(b) + " ";
			}

			label.setText(temp5);
		}
	}

	public static void main(String args[]) {
		WordLength GUI = new WordLength();
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setSize(400, 200);
		GUI.setVisible(true);
	}
}
