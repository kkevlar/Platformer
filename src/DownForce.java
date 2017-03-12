import com.flipturnapps.kevinLibrary.sprite.physics.Force;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class DownForce implements Force {

	public DownForce() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getMagnitude(PhysicsSprite s) {
		// TODO Auto-generated method stub
		return .2;
	}

	@Override
	public double getDirection(PhysicsSprite s) {
		// TODO Auto-generated method stub
		return - (Math.PI/(002.00));
	}

}
