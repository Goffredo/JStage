package JStage.JStage;


public abstract class Actor {
	
	private final int ID = 0; //TODO implement unique ID

	public final void act(Action action){
		action.accept(this);
	}

	public final void visit(Action action) {
		throw new RuntimeException("Action not found: "+action.getName());		
	}

	public int getID() {
		return ID;
	}

}
