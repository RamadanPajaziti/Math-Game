import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {

	private LeaderLabel leader;
	private GameField gameField;
	private Score score;
	private boolean check;
	private static int count;
	String name = null;
	public static String name1;

	public MainFrame() {
		super("Math Effects");

		setSize(700, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		leader = new LeaderLabel();
		gameField = new GameField();

		score = new Score();

		setLayout(null);

		JButton Yes = new JButton("Yes");

		Yes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				check = GameModel.checkAnswer();
				if (check) {
					score.incCorrect();
					score.repaint();
					gameField.repaint();
					count++;

				} else {
					score.incWrong();
					score.repaint();
					gameField.repaint();

					count++;
				}
				if (Score.getWrong() > 5) {
					JOptionPane.showMessageDialog(null, "Game Over");
					score.reset();
					score.repaint();
					count = 0;
					gameField.repaint();
				}

			}

		});

		JButton No = new JButton("No");

		No.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				check = GameModel.checkAnswer();
				if (check) {
					score.incWrong();
					score.repaint();
					gameField.repaint();
					count++;
				} else {
					score.incCorrect();
					score.repaint();
					gameField.repaint();

					count++;
				}

				if (Score.getWrong() > 5) {
					JOptionPane.showMessageDialog(null, "Game Over.");
					score.reset();
					count = 0;
					gameField.repaint();
				}
			}

		});

		Yes.setBounds(140, 305, 80, 37);
		add(Yes);
		No.setBounds(240, 305, 80, 37);
		add(No);

		leader.setBounds(480, 0, 220, 340);
		add(leader);

		score.setBounds(0, 0, 482, 40);
		add(score);

		gameField.setBounds(0, 40, 480, 255);
		add(gameField);

		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		JMenu file = new JMenu("File");
		mb.add(file);
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		});

		JMenu help = new JMenu("Help");
		mb.add(help);

		JMenuItem howToPlay = new JMenuItem("How To Play");
		help.add(howToPlay);

		final String howTo = "Two random numbers are generated together with the operand(random).\n"
				+ "Then some answer is generated. If its true and you press Yes, you have +1 Corrected,\n and if its true and you press No, you have +1 Wronged.\n"
				+ "\n"
				+ "Warning: All calculations are done with integers, so divide operator('/') is done with whole down part.\n"
				+ "For Example if we have:  5/7, the result will be 0, because 5/7 is less than 1 and when we take the whole down part the result would be 0.\n"
				+ "Another example: 10/3 = 3,  15/4 = 3, 20/3 = 6 etc.";

		howToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, howTo);
			}

		});

		JMenuItem about = new JMenuItem("About");
		help.add(about);

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"- Math +effects -\n@copyright. All rights reserved.\n"
										+ "@author: Ramadan Pajaziti.\n To be continued...!");
			}

		});

	}

	public static int getCount() {
		return count;
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
