import com.flipturnapps.kevinLibrary.sprite.physics.Force;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class CustomForce implements Force {

	private double magnitude;
	private double direction;
	public CustomForce() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getMagnitude(PhysicsSprite s) {
		return this.getMagnitude();
	}

	@Override
	public double getDirection(PhysicsSprite s) {
		return this.getDirection();
	}

	public double getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

}
