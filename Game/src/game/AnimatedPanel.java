package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class AnimatedPanel extends JPanel
{
	private Player player;
	private final int PANEL_WIDTH = 600, PANEL_HEIGHT = 380;
	private Image floor;
	private Timer t;
	private InputMap keyToActionBinder;
	private ActionMap actionCollection;
	private static int animationHelper = 0;
	private boolean isJumping = false;

	public AnimatedPanel()
	{
		player = new Player();
		loadFloor();
		KeyStrokeHandler();
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		ActionListener sceneRenderer = new CustomRepainter();
		t = new Timer(40, sceneRenderer);
		t.start();
	}

	private void loadFloor()
	{
		try
		{
			floor = ImageIO.read(new File(getClass().getResource("/resources/floor.png").toURI()));
		}
		catch(IOException ioe)
		{
			System.out.println("floor.png could not be found");
			ioe.printStackTrace();
		} catch (URISyntaxException e) {
			System.out.println("WTF is URI");
			e.printStackTrace();
		}
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(floor, 0, 280, 600, 99, null);
		g.drawImage(player.getCurrentImage(), player.getPositionX(), player.getPositionY(), 30, 50, null);
	}

	private void KeyStrokeHandler()
	{
		keyToActionBinder = getInputMap(WHEN_IN_FOCUSED_WINDOW);
		actionCollection = getActionMap();

		//Creating a bunch of events, where when w is pressed, no modifier, isReleased = false, named as w-pressed
		keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "w-pressed");
		keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "w-released");
		keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "a-pressed");
		keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "a-released");
		keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "s-pressed");
		keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "s-released");
		keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "d-pressed");
		keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "d-released");

		//Odd interactions
		//keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_D & KeyEvent.VK_A, 0, false), "ad-pressed");
		//keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_D & KeyEvent.VK_A, 0, true), "ad-released");

		actionCollection.put("a-pressed", new AKeyPressed());
		actionCollection.put("a-released", new AKeyReleased());
		actionCollection.put("d-pressed", new DKeyPressed());
		actionCollection.put("d-released", new DKeyReleased());
		actionCollection.put("w-pressed", new WKeyPressed());
	}

	private class AKeyPressed extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			player.setMovement(2, true);
			//t.start();
		}
	}

	private class AKeyReleased extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			player.setMovement(2, false);
			player.setCurrentImage(player.getLeftStandingImage());
			repaint();
			//t.stop();
		}
	}

	private class DKeyPressed extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			player.setMovement(4, true);
			//t.start();
		}
	}

	private class DKeyReleased extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			player.setMovement(4, false);
			player.setCurrentImage(player.getRightStandingImage());
			repaint();
			//t.stop();
		}
	}

	private class WKeyPressed extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.print(".");
			if(!player.getMovement(1))
			{
				player.setdY(10);
				player.setMovement(1, true);
			}
		}
	}

	private class CustomRepainter implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(player.getMovement(1))
			{
				if(player.getdY() < -10)
				{
					player.setMovement(1, false);
				} else {
					player.setEntityY(1);
					player.decrementdY();
				}
				repaint();
			}
			if(player.getMovement(4))
			{
				player.setCurrentImage(player.getRightAnimationCycle(animationHelper));
				player.setEntityX(4);
				animationHelper++;
				if(animationHelper > 7) animationHelper = 0;
				repaint();
			}
			if(player.getMovement(2))
			{
				player.setCurrentImage(player.getLeftAnimationCycle(animationHelper));
				player.setEntityX(2);
				animationHelper++;
				if(animationHelper > 7) animationHelper = 0;
				repaint();
			}
		}
	}
}