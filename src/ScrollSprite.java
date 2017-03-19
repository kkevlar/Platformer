import java.awt.Color;
import java.awt.Graphics;

import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.DefaultScrollerPhysicsSprite;
import com.flipturnapps.kevinLibrary.sprite.physics.Force;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class ScrollSprite extends DefaultScrollerPhysicsSprite 
{
	
	private CustomForce leftForce;
	private CustomForce rightForce;
	
	
	public ScrollSprite()
	{
		this.setObeyScrolling(false);
		this.guessDimensions();
		this.moveToCenter();
		
		leftForce = new CustomForce(Force.DIR_LEFT, 1);
		rightForce = new CustomForce(Force.DIR_RIGHT, 1);
		
		//need to add these
	}

	@Override
	protected void drawShape(Graphics g, SpritePanel s, int x, int y, int width, int height)
	{
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	public void jump() {
		// TODO Auto-generated method stub
		
	}

	public void moveLeft() 
	{
		
			leftForce.enable();	
	}

	public void crouch() {
		// TODO Auto-generated method stub
		
	}

	public void moveRight() 
	{
		leftForce.enable();	
		
	}

	public void prep() 
	{
		
	leftForce.disable();
	rightForce.disable();
		
	}

	public void done() {
		// TODO Auto-generated method stub
		
	}

}
