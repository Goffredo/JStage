package JStage.JStage;

import java.util.HashMap;
import java.util.Map;

public final class Stage {
	
	private final Map<Integer, Actor> actors = new HashMap<Integer, Actor>();
	private final ActionManager actionManager;

	public Stage(ActionManager actionManager){
		this.actionManager = actionManager;
	}	
	
	public void perform(){
		actionManager.step();
		for(Actor actor : actors.values()){
			for(Action action : actionManager.getActions(actor)){
				actor.act(action);
			}
		}
	}

	public void addActor(Actor actor){
		actors.put(actor.getID(), actor);
	}
	
	public void removeActor(int actorID){
	}

	public void addAction(Action newAction){
		actionManager.addAction(newAction);
	}
}
