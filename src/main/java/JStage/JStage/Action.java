package JStage.JStage;

public abstract class Action {

	private static final String DEFAULT_STRING = "Undefined action";

	public abstract void accept(Actor actor);
	
	public String getName(){
		return DEFAULT_STRING;
	}

}
