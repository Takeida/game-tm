package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class Player/* implements Runnable*/
{
	private Image[] walkLeft;
	private Image[] walkRight;
	private Image stop;
	private Image currentImage;
	private boolean movW = false,
					movA = false,
					movS = false,
					movD = false;
	private int playerX = 400;
	
	public Player()
	{
		initPlayerAnimation();
		currentImage = stop;
	}
	
	public Image getStandingImage()
	{
		return stop;
	}
	
	public Image getCurrentImage()
	{
		return currentImage;
	}
	
	public void setCurrentImage(Image image)
	{
		currentImage = image;
	}
	
	public int getPlayerX()
	{
		return playerX;
	}
	
	public void setPlayerX(int key)
	{
		switch(key)
		{
			case 1:
				break;
			case 2:
				playerX-=4;
				break;
		}
	}
	
	public Image getLeftAnimationCycle(int cycle)
	{
		return walkLeft[cycle];
	}
	
	public boolean getMovement(int key)
	{
		//1 = w, 2 = a, 3 = s, 4= d
		switch(key)
		{
			case 1:
				return movW;
			case 2:
				return movA;
			case 3:
				return movS;
			case 4:
				return movD;
			default:
				return movW;
		}
	}
	
	public void setMovement(int key, boolean onOrOff)
	{
		switch(key)
		{
			case 1:
				movW = onOrOff;
				break;
			case 2:
				movA = onOrOff;
				break;
			case 3:
				movS = onOrOff;
				break;
			case 4:
				movD = onOrOff;
				break;
			default:
				movW = onOrOff;
		}
	}
	
	private void initPlayerAnimation()
	{
		walkLeft = new Image[8];
		walkRight = new Image[8];
		try
		{
			//Stopped (no animation)
			stop = ImageIO.read(new File("player_walk_left_zero.png"));
			
			//Moving left animation
			walkLeft[0] = ImageIO.read(new File("player_walk_left_one.png"));
			walkLeft[1] = ImageIO.read(new File("player_walk_left_two.png"));
			walkLeft[2] = ImageIO.read(new File("player_walk_left_three.png"));
			walkLeft[3] = ImageIO.read(new File("player_walk_left_four.png"));
			walkLeft[4] = ImageIO.read(new File("player_walk_left_five.png"));
			walkLeft[5] = ImageIO.read(new File("player_walk_left_six.png"));
			walkLeft[6] = ImageIO.read(new File("player_walk_left_seven.png"));
			walkLeft[7] = ImageIO.read(new File("player_walk_left_eight.png"));
			/*
			//Moving right animation
			walkRight[0] = ImageIO.read(new File("player_walk_right_one.png"));
			walkRight[1] = ImageIO.read(new File("player_walk_right_two.png"));
			walkRight[2] = ImageIO.read(new File("player_walk_right_three.png"));
			walkRight[3] = ImageIO.read(new File("player_walk_right_four.png"));
			walkRight[4] = ImageIO.read(new File("player_walk_right_five.png"));
			walkRight[5] = ImageIO.read(new File("player_walk_right_six.png"));
			walkRight[6] = ImageIO.read(new File("player_walk_right_seven.png"));
			walkRight[7] = ImageIO.read(new File("player_walk_right_eight.png"));*/
		}catch(IOException ioe)
		{
			System.out.println("Image files could not be found!");
			ioe.printStackTrace();
		}
	}
}
