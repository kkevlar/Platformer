import com.flipturnapps.kevinLibrary.sprite.physics.Force;
import com.flipturnapps.kevinLibrary.sprite.physics.PhysicsSprite;

public class CustomForce implements Force {

	private double magnitude;
	private double direction;
	private boolean enabled = false;
	public CustomForce()
	{
		
	}

	public CustomForce(double dir, double mag)
	{
		this.setDirection(dir);
		this.setMagnitude(mag);
	}

	@Override
	public double getMagnitude(PhysicsSprite s) {
			if(enabled)
		return this.getMagnitude();
		else
			return 0;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void disable() {
		this.setEnabled(false);
		
	}

	public void enable() {
	this.setEnabled(true);
		
	}

	@Override
	public String toString() {
		return "CustomForce [magnitude=" + magnitude + ", direction=" + direction + ", enabled=" + enabled + "]";
	}

}
