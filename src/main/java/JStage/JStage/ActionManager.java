package JStage.JStage;

import java.util.List;


public interface ActionManager {

	public void addAction(Action newAction);

	public List<Action> getActions(Actor actor);

	public void step();

}
