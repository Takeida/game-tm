package game;

import javax.swing.JFrame;

public class Animation {
	public static void main(String[]args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("OMG A GAME");
		frame.add(new AnimatedPanel());
		frame.pack();
		frame.setVisible(true);
	}
}