package JStage.JStage;

public class DanceAction extends Action{
	
	public enum Type {
		WALZER,
		MAMBO,
		MACARENA,
		STOP
	}

	private final Type type;

	public DanceAction(DanceAction.Type type){
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

	@Override
	public String getName() {
		return type.name();
	}

}
