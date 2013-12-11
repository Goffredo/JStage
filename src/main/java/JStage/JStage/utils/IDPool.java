package JStage.JStage.utils;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class IDPool {

	private Set<Integer> ints = new TreeSet<Integer>();
	private int next = 0;

	public int requestID(){
		Iterator<Integer> i = ints.iterator();
		Integer out = 0;
		if(i.hasNext()){
			out = i.next();
			i.remove();
		}else{
			out = next;
			next++;
		}
		return out;
	}

	public void freeID(int toBeFreed){
		ints.add(toBeFreed);
	}

}
