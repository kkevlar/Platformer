import java.awt.Component;
import java.awt.HeadlessException;

import com.flipturnapps.kevinLibrary.gui.KJFrame;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.FrictionForce;

public class Frame extends KJFrame implements Runnable 
{

	private SpritePanel sPanel;
	private ScrollSprite sprite;
	private RedSprite bSp;
	public Frame() throws HeadlessException 
	{
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		sPanel = new SpritePanel();
		this.getContentPane().add(sPanel);

		bSp = new RedSprite();
		sPanel.add(bSp);		
		sprite = new ScrollSprite();
		sPanel.add(sprite);			
		sPanel.requestFocus();
		new Thread(this).start();
	}

	@Override
	public void run() 
	{
		this.setSize(501,501);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sprite.guessDimensions();
		
		
		
		sprite.moveToCenter();
		while(true)
		{	
			sprite.prep();
				if(sPanel.upKeyDown())
				{
					
					sprite.jump();
					
				}
				if(sPanel.leftKeyDown())
				{
					sprite.moveLeft();
					
				}
				if(sPanel.downKeyDown())
				{
					sprite.crouch();
					
				}
				if(sPanel.rightKeyDown())
				{
					sprite.moveRight();
					
				}
				
			sprite.done();

			sprite.update();
			sPanel.repaint();

			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
