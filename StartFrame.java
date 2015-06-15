import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class StartFrame extends JPanel {
	private JRadioButton modTime;
	private JRadioButton testMod;
	private ButtonGroup genderGroup;

	public StartFrame() {

		modTime = new JRadioButton("Time");
		testMod = new JRadioButton("Test");
		genderGroup = new ButtonGroup();

		JButton play = new JButton("Play");

		play.setBounds(285, 290, 85, 40);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
			}
		});

		add(play);

		// set up gender ratios
		genderGroup.add(modTime);
		genderGroup.add(testMod);

		modTime.setSelected(true);

		setLayout(null);

		// ModTime radio button

		// first mod

		modTime.setBounds(260, 240, 50, 50);
		add(modTime);

		// second mod
		testMod.setBounds(345, 240, 50, 50);
		add(testMod);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		int width = 700;
		int height = 400;

		g.setColor((new Color(230, 235, 240)));
		g.fillRect(0, 0, width, height);
		g.setColor(Color.RED);
		g.fillRect(width / 4, height / 5, width / 2, height / 3);

		g.setColor(Color.black);
		g.drawString("Mods:", width / 2 - 30, 3 * height / 5);

		g.setColor(Color.white);

		Font font = new Font("Arial Narrow", Font.TRUETYPE_FONT, 55);

		g2.setFont(font);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g.drawString("MATH", 2 * width / 7, 4 * height / 12);
		g.drawString("+ effects", 3 * width / 7, 4 * height / 9);
	}

	public static void main(String[] args) {
		StartFrame panel = new StartFrame();

		JFrame frame = new JFrame("Math Effects");

		JMenuBar mb = new JMenuBar();
		frame.setJMenuBar(mb);
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
		JMenuItem about = new JMenuItem("About");
		help.add(about);

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"- Math +effects -\n@author: Ramadan Pajaziti.\n@copyright. All rights reserved.\n"
										+ " To be continued...!");
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(700, 400);
		frame.setVisible(true);
	}

}
