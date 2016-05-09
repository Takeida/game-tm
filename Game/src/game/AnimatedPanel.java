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
	private Image floor, bg;
	private Timer t;
	private InputMap keyToActionBinder;
	private ActionMap actionCollection;
	private static int animationHelper = 0;

	public AnimatedPanel()
	{
		player = new Player();
		loadBackground();
		loadFloor();
		KeyStrokeHandler();
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		ActionListener sceneRenderer = new CustomRepainter();
		t = new Timer(40, sceneRenderer);
		t.start();
	}
	
	private void loadBackground()
	{
		try
		{
			bg = ImageIO.read(new File(getClass().getResource("/resources/bg.png").toURI()));
		}
		catch(IOException ioe)
		{
			System.out.println("bg.png could not be found");
			ioe.printStackTrace();
		} catch (URISyntaxException e) {
			System.out.println("WTF is URI");
			e.printStackTrace();
		}
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
		g.drawImage(bg, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);
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
		keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "space-released");
		keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "space-released");

		//Odd interactions
		//keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_D & KeyEvent.VK_A, 0, false), "ad-pressed");
		//keyToActionBinder.put(KeyStroke.getKeyStroke(KeyEvent.VK_D & KeyEvent.VK_A, 0, true), "ad-released");

		actionCollection.put("a-pressed", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{ player.setMovement(2, true); }
		});
		actionCollection.put("a-released", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				player.setMovement(2, false);
				player.setCurrentImage(player.getLeftStandingImage());
				repaint();
			}
		});
		actionCollection.put("d-pressed", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{ player.setMovement(4, true); }
		});
		actionCollection.put("d-released", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				player.setMovement(4, false);
				player.setCurrentImage(player.getRightStandingImage());
				repaint();
			}
		});
		actionCollection.put("space-pressed", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		actionCollection.put("space-released", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
	}
	
	private class CustomRepainter implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(player.getMovement(2))
			{
				player.setCurrentImage(player.getLeftAnimationCycle(animationHelper));
				player.setEntityX(2);
				animationHelper++;
				if(animationHelper > 7) animationHelper = 0;
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
		}
	}
}