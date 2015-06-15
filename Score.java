import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Score extends JPanel {

	private int correct;
	private static int wrong;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		setBorder(BorderFactory.createEtchedBorder());

		Dimension dim = getPreferredSize();

		int height = 25;

		dim.height = height;
		setPreferredSize(dim);

		g.setColor(Color.black);

		Font font = new Font("Arial Narrow", Font.ITALIC, 20);

		g2.setFont(font);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g.drawString("Wrong: " + wrong, 250, 25);
		g.drawString("Correct: " + correct + " ;     ", 150, 25);

	}
	
	public void reset(){
		correct = 0;
		wrong = 0;
		repaint();
	}

	public void incCorrect() {
		correct++;
	}

	public void incWrong() {
		wrong++;
	}

	public static int getWrong() {
		return wrong;
	}


}
