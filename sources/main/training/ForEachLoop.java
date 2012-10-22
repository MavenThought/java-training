package main.training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ForEachLoop {

	public Iterable<String> deployUsingForEach(List<String> collection) {
		Collection<String> result = new ArrayList<String>();
		for(int i = 0 ; i < collection.size() ; i++) {
			result.add("Deployed to " + collection.get(i));
		}
		return result;
	}

	public Iterable<String> deployUsingIterator(Iterable<String> collection) {
		Collection<String> result = new ArrayList<String>();
		Iterator<String> i = collection.iterator() ; 
		while(i.hasNext()) {
			result.add("Deployed to " + i.next());
		}
		return result;
	}

	public Iterable<String> deployUsingEnhanced(Iterable<String> environments) {
		Collection<String> result = new ArrayList<String>();
		for(String env: environments) {
			result.add("Deployed to " + env);
		}
		return result;
	}
}
