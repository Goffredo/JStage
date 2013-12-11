package JStage.JStage;

public class DancingPerformance implements Performance {
	
	private final DanceActor actor;
	private final DanceAction action;

	public DancingPerformance(DanceActor actor, DanceAction action){
		this.actor = actor;
		this.action = action;
	}

	@Override
	public void execute() {
		actor.add(action);
	}

}
