import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class LeaderLabel extends JPanel {
	private JLabel label;

	public LeaderLabel() {
		
		Dimension dim = getPreferredSize();
		
		
		int width = 350;

		dim.width = width;
		setPreferredSize(dim);
		
		setBorder(BorderFactory.createEtchedBorder());
		
		Border innerBorder = BorderFactory.createTitledBorder("Top Players..!");
		Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}
}