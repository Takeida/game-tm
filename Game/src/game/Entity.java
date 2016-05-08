package game;

import java.awt.Image;

public abstract class Entity
{
	private Image[] walkLeft = new Image[8];
	private Image[] walkRight  = new Image[8];
	private Image standingLeft;
	private Image standingRight;
	private Image currentImage;
	private boolean movUP = false,
					movLEFT = false,
					movDOWN = false,
					movRIGHT = false;
	private int playerX;
	private int playerY;
	private int dX;
	
	public void setdX(int change)
	{
		dX = change;
	}
	
	public void setInitialPosition(int x, int y)
	{
		playerX = x;
		playerY = y;
	}
	
	public void setLeftStandingImage(Image image)
	{
		standingLeft = image;
	}
	
	public void setRightStandingImage(Image image)
	{
		standingRight = image;
	}
	
	public Image getLeftStandingImage()
	{
		return standingLeft;
	}
	
	public Image getRightStandingImage()
	{
		return standingRight;
	}
	
	public void setWalkLeft(int index, Image image)
	{
		walkLeft[index] = image;
	}
	
	public void setWalkRight(int index, Image image)
	{
		walkRight[index] = image;
	}
	
	public Image getCurrentImage()
	{
		return currentImage;
	}
	
	public void setCurrentImage(Image image)
	{
		currentImage = image;
	}
	
	public int getX()
	{
		return playerX;
	}
	
	public int getY()
	{
		return playerY;
	}
	
	public void setEntityX(int key)
	{
		switch(key)
		{
			case 1:
				break;
			case 2:
				playerX-= dX;
				break;
			case 3:
				break;
			case 4:
				playerX+= dX;
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
				return movUP;
			case 2:
				return movLEFT;
			case 3:
				return movDOWN;
			case 4:
				return movRIGHT;
			default:
				return movUP;
		}
	}
	
	public void setMovement(int key, boolean onOrOff)
	{
		switch(key)
		{
			case 1:
				movUP = onOrOff;
				break;
			case 2:
				movLEFT = onOrOff;
				break;
			case 3:
				movDOWN = onOrOff;
				break;
			case 4:
				movRIGHT = onOrOff;
				break;
			default:
				movUP = onOrOff;
		}
	}
	
	public abstract void initPlayerAnimation();
}