import java.awt.Component;
import java.awt.HeadlessException;

import com.flipturnapps.kevinLibrary.gui.KJFrame;
import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.FrictionForce;

public class Frame extends KJFrame implements Runnable 
{

	private SpritePanel sPanel;
	private ScrollSprite sprite;
	private CustomForce force;
	private boolean scrolling = false;
	private RedSprite bSp;
	private FrictionForce frictionForce;
	public Frame() throws HeadlessException 
	{
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		sPanel = new SpritePanel();
		this.getContentPane().add(sPanel);

		bSp = new RedSprite();
		sPanel.add(bSp);
		bSp.setObeyScrolling(true);
		
		sprite = new ScrollSprite();
		sPanel.add(sprite);
		

		force = new CustomForce();
		sprite.getForces().add(force);
		sprite.setObeyScrolling(false);
		sprite.getForces().add(new DownForce());
		frictionForce = new FrictionForce(.5);
		frictionForce.setEnabled(true);
		sprite.getForces().add(frictionForce);
		
		sPanel.requestFocus();

		new Thread(this).start();
	}

	@Override
	public void run() 
	{
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sprite.guessDimensions();
		sprite.moveToCenter();
		bSp.setAll(0, 400, 500, 100);
		this.setSize(501,501);
		sprite.moveToCenter();
		sprite.setNetVelMagnitude(.1);
		sprite.setNetVelDir(0);
		while(true)
		{	
			if(sprite.getY() >= 349 && Math.sin(sprite.getNetAccelDir()) < 0)
			{
				//sprite.setY(349);
				sprite.setyNormaled(true);
			}
			else
				sprite.setyNormaled(false);

			force.setMagnitude(0);
			frictionForce.setEnabled(true);
			if(!scrolling)
			{
				double magnitude = .3;
				if(sPanel.upKeyDown())
				{
					force.setMagnitude(1);
					force.setDirection(Math.PI / (2+0.0));
				}
				if(sPanel.leftKeyDown())
				{
					force.setMagnitude(magnitude);
					force.setDirection(Math.PI / (-1));
				}
				if(sPanel.downKeyDown())
				{
					force.setMagnitude(magnitude);
					force.setDirection(Math.PI / (-2+0.0));
				}
				if(sPanel.rightKeyDown())
				{
					force.setMagnitude(magnitude);
					force.setDirection(0);
				}
			}
			else
			{
				if(sPanel.upKeyDown())
					sPanel.setyOffset(sPanel.getyOffset() - 1);
				if(sPanel.leftKeyDown())
					sPanel.setxOffset(sPanel.getxOffset() - 1);
				if(sPanel.downKeyDown())
					sPanel.setyOffset(sPanel.getyOffset() + 1);
				if(sPanel.rightKeyDown())
					sPanel.setxOffset(sPanel.getxOffset() + 1);
			}


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
