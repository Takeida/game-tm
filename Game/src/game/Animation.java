package game;

import javax.swing.JFrame;

public class Animation {
	public static void main(String[]args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setTitle("OMG A GAME");
		frame.add(new AnimatedPanel());
		frame.setVisible(true);
	}
}