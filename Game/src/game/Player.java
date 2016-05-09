package game;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Player extends Entity
{
	private String[] imageFiles;
	private Image[] leftAnimCycle;
	private Image[] rightAnimCycle;
	private Image currentImage;
	
	public Player()
	{
		initImageFiles();
		initEntityAnimation();
		setCurrentImage(this.getLeftStandingImage());
		setdX(4);
		setInitialPosition(400, 240);
	}
	
	public Image getLeftStandingImage()
	{
		return leftAnimCycle[0];
	}
	
	public Image getRightStandingImage()
	{
		return rightAnimCycle[0];
	}
	
	public void setLeftAnimationCycle(int index, Image image)
	{
		leftAnimCycle[index] = image;
	}
	
	public Image getLeftAnimationCycle(int cycle)
	{
		return leftAnimCycle[cycle];
	}
	
	public void setRightAnimationCycle(int index, Image image)
	{
		rightAnimCycle[index] = image;
	}
	
	public Image getRightAnimationCycle(int cycle)
	{
		return rightAnimCycle[cycle];
	}
	
	public Image getCurrentImage()
	{
		return currentImage;
	}
	
	public void setCurrentImage(Image image)
	{
		currentImage = image;
	}
	
	protected void initEntityAnimation()
	{
		leftAnimCycle = new Image[9];
		rightAnimCycle = new Image[9];
		
		try
		{
			for(int ii = 0; ii < imageFiles.length; ii++)
			{
				if(ii < 9)
					setLeftAnimationCycle(ii, ImageIO.read(new File(getClass().getResource(imageFiles[ii]).toURI())));
				else
					setRightAnimationCycle((ii - 9), ImageIO.read(new File(getClass().getResource(imageFiles[ii]).toURI())));
			}
		}catch(IOException ioe)
		{
			System.out.println("Image files could not be found!");
			ioe.printStackTrace();
		} catch (URISyntaxException e) {
			System.out.println("Syntax for image loading is incorrect!");
			e.printStackTrace();
		}
	}
	
	private void initImageFiles()
	{
		imageFiles = new String[18];
		//Left Animation Cycle Image Files
		imageFiles[0] = "/resources/player_walk_left_zero.png";
		imageFiles[1] = "/resources/player_walk_left_one.png";
		imageFiles[2] = "/resources/player_walk_left_two.png";
		imageFiles[3] = "/resources/player_walk_left_three.png";
		imageFiles[4] = "/resources/player_walk_left_four.png";
		imageFiles[5] = "/resources/player_walk_left_five.png";
		imageFiles[6] = "/resources/player_walk_left_six.png";
		imageFiles[7] = "/resources/player_walk_left_seven.png";
		imageFiles[8] = "/resources/player_walk_left_eight.png";
		//Right Animation Cycle Image Files
		imageFiles[9] = "/resources/player_walk_right_zero.png";
		imageFiles[10] = "/resources/player_walk_right_one.png";
		imageFiles[11] = "/resources/player_walk_right_two.png";
		imageFiles[12] = "/resources/player_walk_right_three.png";
		imageFiles[13] = "/resources/player_walk_right_four.png";
		imageFiles[14] = "/resources/player_walk_right_five.png";
		imageFiles[15] = "/resources/player_walk_right_six.png";
		imageFiles[16] = "/resources/player_walk_right_seven.png";
		imageFiles[17] = "/resources/player_walk_right_eight.png";
	}
}