import java.awt.Color;
import java.awt.Graphics;

import com.flipturnapps.kevinLibrary.sprite.SpritePanel;
import com.flipturnapps.kevinLibrary.sprite.physics.DefaultScrollerPhysicsSprite;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class ScrollSprite extends DefaultScrollerPhysicsSprite 
{


	@Override
	protected void drawShape(Graphics g, SpritePanel s, int x, int y, int width, int height)
	{
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

}
