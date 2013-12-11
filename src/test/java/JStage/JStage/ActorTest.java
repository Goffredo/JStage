package JStage.JStage;

import java.util.Random;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.testbed.framework.TestbedSettings;
import org.jbox2d.testbed.framework.TestbedTest;

public class ActorTest extends TestbedTest {

	private final Stage stage;
	private DanceActor dancer;
	private Random rnd = new Random(1);

	public ActorTest(){
		this.stage = new Stage();
	}

	@Override
	public void initTest(boolean deserialized) {
		setTitle("Dance!!");

		getWorld().setGravity(new Vec2());


		PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(1, 1);

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DYNAMIC;
		bodyDef.allowSleep = false;
		Body body = getWorld().createBody(bodyDef);
		body.createFixture(polygonShape, 5.0f);
		
		//BOX
		BodyDef bd = new BodyDef();
		Body ground = getWorld().createBody(bd);

		EdgeShape shape = new EdgeShape();

		// Floor
		shape.set(new Vec2(-10.0f, -10.0f), new Vec2(10.0f, -10.0f));
		ground.createFixture(shape, 0.0f);

		// Left wall
		shape.set(new Vec2(-10.0f, -10.0f), new Vec2(-10.0f, 10.0f));
		ground.createFixture(shape, 0.0f);

		// Right wall
		shape.set(new Vec2(10.0f, -10.0f), new Vec2(10.0f, 10.0f));
		ground.createFixture(shape, 0.0f);

		// Roof
		shape.set(new Vec2(-10.0f, 10.0f), new Vec2(10.0f, 10.0f));
		ground.createFixture(shape, 0.0f);
		
		dancer = new DanceActor(0, body);
		stage.addActor(dancer);
		stage.addPerformance(new DancingPerformance(dancer, new DanceAction(DanceAction.Type.MACARENA)));
	}

	@Override
	public synchronized void step(TestbedSettings settings) {
		stage.act();
		if (getModel().getKeys()['s']) {
			stage.addPerformance(new DancingPerformance(dancer, new DanceAction(DanceAction.Type.STOP)));
		}

		super.step(settings);
	}

	@Override
	public synchronized void launchBomb(org.jbox2d.common.Vec2 position, org.jbox2d.common.Vec2 velocity) {
		DanceAction.Type dancingStyle = DanceAction.Type.values()[rnd.nextInt(3)];
		DanceAction danceAction = new DanceAction(dancingStyle);
		System.out.println("No bombs! Dance instead! "+"Change style! "+danceAction.getName());
		stage.addPerformance(new DancingPerformance(dancer, danceAction));
	};

	@Override
	public String getTestName() {
		return "Actors!";
	}

}
