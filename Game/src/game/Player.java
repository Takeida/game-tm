package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class Player/* implements Runnable*/
{
	private Image[] walkLeft;
	private Image[] walkRight;
	private Image standingLeft;
	private Image standingRight;
	private Image currentImage;
	private boolean movW = false,
					movA = false,
					movS = false,
					movD = false;
	private int playerX = 400;
	
	public Player()
	{
		initPlayerAnimation();
		currentImage = standingLeft;
	}
	
	public Image getLeftStandingImage()
	{
		return standingLeft;
	}
	
	public Image getRightStandingImage()
	{
		return standingRight;
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
			case 3:
				break;
			case 4:
				playerX+=4;
				break;
			default:
				break;
		}
	}
	
	public Image getLeftAnimationCycle(int cycle)
	{
		return walkLeft[cycle];
	}
	
	public Image getRightAnimationCycle(int cycle)
	{
		return walkRight[cycle];
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
			standingLeft = ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_zero.png").toURI()));
			standingRight = ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_zero.png").toURI()));
			
			//Moving left animation
			walkLeft[0] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_one.png").toURI()));
			walkLeft[1] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_two.png").toURI()));
			walkLeft[2] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_three.png").toURI()));
			walkLeft[3] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_four.png").toURI()));
			walkLeft[4] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_five.png").toURI()));
			walkLeft[5] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_six.png").toURI()));
			walkLeft[6] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_seven.png").toURI()));
			walkLeft[7] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_eight.png").toURI()));
			
			//Moving right animation
			walkRight[0] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_one.png").toURI()));
			walkRight[1] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_two.png").toURI()));
			walkRight[2] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_three.png").toURI()));
			walkRight[3] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_four.png").toURI()));
			walkRight[4] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_five.png").toURI()));
			walkRight[5] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_six.png").toURI()));
			walkRight[6] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_seven.png").toURI()));
			walkRight[7] = ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_eight.png").toURI()));
		}catch(IOException ioe)
		{
			System.out.println("Image files could not be found!");
			ioe.printStackTrace();
		} catch (URISyntaxException e) {
			System.out.println("Syntax for image loading is incorrect!");
			e.printStackTrace();
		}
	}
}