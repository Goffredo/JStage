package JStage.JStage;

import java.util.LinkedList;
import java.util.List;

public class Stage {
	
	private List<Actor> actors = new LinkedList<>();

	public void act(){
		for(Actor p: actors){
			p.perform();
		}
	}
	
	public void addActor(Actor actor){
		actors.add(actor);
	}
	
	public void addPerformance(Performance p){
		p.execute();
	}

}
