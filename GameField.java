import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class GameField extends JPanel {

	private int[] getNumbers;

	private boolean checkk;

	public int[] getGetNumbers() {

		// getNumbers = (new GameModel).getFinalAnswer();
		return getNumbers;
	}

	public GameField() {

		setLayout(new BorderLayout());
		setVisible(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		GameModel model = new GameModel();

		int[] numbers = model.getFinalAnswer();
		String operand = model.getOperand();
		getNumbers = numbers;

		checkk = model.checkAnswer();

		int width = getWidth();
		int height = getHeight();

		Font font = new Font("AR JULIAN", Font.TRUETYPE_FONT, 55);

		g2.setFont(font);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(font);

		g.setColor(new Color(230, 225, 230));
		g.fillRect(0, 0, width, height);

		g.setColor(Color.RED);
		g.drawString(numbers[0] + " " + operand + " " + numbers[1] + " = "
				+ numbers[2], width / 7, 3 * height / 5);

	}

	public boolean getCheck() {
		System.out.println(checkk);
		return checkk;
	}
}
