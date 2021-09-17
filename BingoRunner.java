import javax.swing.*;
import java.awt.*;
import java.util.regex.*;

public class BingoRunner {
	
	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bingo Frame");
		JPanel openingPanel = new JPanel();
		JTextField field = new JTextField(25);
		JButton button = new JButton("Submit seed");
		button.addActionListener(e -> {
			String string = field.getText();
			if (string != null && pattern.matcher(string).matches()) {
				long number = Long.parseLong(string);
				BingoCard.createRandom(number);
				System.out.println(number);
				createBingoPanel(frame);
				openingPanel.removeAll();
				openingPanel.setSize(1, 1);
			} else {
				field.setText(string + " is not a valid number.");
			}
		});
		openingPanel.add(field);
		openingPanel.add(button);
		frame.add(openingPanel);
		frame.setVisible(true);
		frame.setSize(1000, 150);
		frame.setResizable(false);
	}
	
	private static void createBingoPanel(JFrame frame) {
		BingoCard card = new BingoCard();
		BingoPanel panel = new BingoPanel(card);
		frame.add(panel);
		frame.setSize(1100, 1000);
		frame.repaint();
	}
}


