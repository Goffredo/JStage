package JStage.JStage;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class DanceActor extends Actor {

	private static final float SLOWDOWN = 100000.0f;

	private final int ID;

	private final Body body;

	private int time = 0;


	private float jerkiness = 0;
	private float speed = 0;
	private boolean dancing = false;

	public DanceActor(int ID, Body body){
		this.ID = ID;
		this.body = body;
	}

	@Override
	public int getID() {
		return ID;
	}

	public void add(DanceAction dance){
		time = 0;

		switch (dance.getType()) {
		case MACARENA:
			dancing = true;
			jerkiness = 200.0f;
			speed = 500.0f;
			break;
		case MAMBO:
			dancing = true;
			jerkiness = 50000.0f;
			speed = 10000.0f;
			break;
		case WALZER:
			dancing = true;
			jerkiness = 10.0f;
			speed = 5.0f;
			break;
		case STOP:
			dancing = false;
			break;
		default:
			break;
		}
	}

	public void perform() {
		if(dancing){
			float xForce = jerkiness * MathUtils.sin(time*MathUtils.TWOPI*speed/SLOWDOWN + MathUtils.HALF_PI);
			body.applyForceToCenter(new Vec2(xForce, 0));
		} else {
			body.applyLinearImpulse(body.getLinearVelocity().negate(), body.getWorldCenter());
		}
		time++;
	}

}
