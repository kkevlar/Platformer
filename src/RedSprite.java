import java.awt.Color;
import java.awt.Graphics;

import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class RedSprite extends PhysicsSprite 
{
	public RedSprite() 
	{
		super();
		this.setObeyScrolling(true);
		this.setAll(0, 400, 500, 100);
	}

	@Override
	protected void drawShape(Graphics g, SpritePanel s, int x, int y, int width, int height)
	{
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}
