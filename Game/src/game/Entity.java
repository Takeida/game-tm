package game;

public abstract class Entity
{
	private int entityPositionX;
	private int entityPositionY;
	private boolean isDead;
	private boolean movUP = false,
					movLEFT = false,
					movDOWN = false,
					movRIGHT = false;
	private int dX, dY, dG;
	
	public Entity()
	{
		this.isDead = false;
	}
	
	protected abstract void initEntityAnimation();
	
	public void setInitialPosition(int x, int y)
	{
		entityPositionX = x;
		entityPositionY = y;
	}
	
	public int getPositionX()
	{
		return entityPositionX;
	}
	
	public int getPositionY()
	{
		return entityPositionY;
	}
	
	public void setIsDead(boolean dead)
	{
		isDead = dead;
	}
	
	public boolean getIsDead()
	{
		return isDead;
	}
	
	public void setdX(int change)
	{
		dX = change;
	}
	
	public int getdX()
	{
		return dX;
	}
	
	public void setEntityX(int key)
	{
		switch(key)
		{
			case 1:
				break;
			case 2:
				entityPositionX -= dX;
				break;
			case 3:
				break;
			case 4:
				entityPositionX += dX;
				break;
			default:
				break;
		}
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
}