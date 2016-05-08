package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class Player extends Entity
{
	
	public Player()
	{
		initPlayerAnimation();
		setCurrentImage(this.getLeftStandingImage());
		setdX(4);
		setInitialPosition(400, 240);
	}
	
	public void initPlayerAnimation()
	{
		try
		{
			//Stopped (no animation)
			setLeftStandingImage(ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_zero.png").toURI())));
			setRightStandingImage(ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_zero.png").toURI())));
			
			//Moving left animation
			setWalkLeft(0, ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_one.png").toURI())));
			setWalkLeft(1, ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_two.png").toURI())));
			setWalkLeft(2, ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_three.png").toURI())));
			setWalkLeft(3, ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_four.png").toURI())));
			setWalkLeft(4, ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_five.png").toURI())));
			setWalkLeft(5, ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_six.png").toURI())));
			setWalkLeft(6, ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_seven.png").toURI())));
			setWalkLeft(7, ImageIO.read(new File(getClass().getResource("/resources/player_walk_left_eight.png").toURI())));
			
			//Moving right animation
			setWalkRight(0, ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_one.png").toURI())));
			setWalkRight(1, ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_two.png").toURI())));
			setWalkRight(2, ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_three.png").toURI())));
			setWalkRight(3, ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_four.png").toURI())));
			setWalkRight(4, ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_five.png").toURI())));
			setWalkRight(5, ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_six.png").toURI())));
			setWalkRight(6, ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_seven.png").toURI())));
			setWalkRight(7, ImageIO.read(new File(getClass().getResource("/resources/player_walk_right_eight.png").toURI())));
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