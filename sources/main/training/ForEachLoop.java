 package main.training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import ch.lambdaj.function.convert.Converter;
import static ch.lambdaj.collection.LambdaCollections.*;

public class ForEachLoop {

	public Iterable<String> deployUsingForEach(List<String> collection) {
		
		Collection<String> result = new ArrayList<String>();
		
		for(int i = 0; i < collection.size(); i++) {
			result.add("Deployed to " + collection.get(i));
		}
		
		return result;
	}

	public Iterable<String> deployUsingIterator(Iterable<String> collection) {
		
		Collection<String> result = new ArrayList<String>();

		Iterator<String> cursor = collection.iterator();
		
		while(cursor.hasNext()) {
			result.add("Deployed to " + cursor.next());
		}
		
		return result;
	}

	public Iterable<String> deployUsingEnhanced(Iterable<String> environments) {
		
		Collection<String> result = new ArrayList<String>();
		
		for(String element : environments) {
			result.add("Deployed to " + element);
		}
		
		return result;
	}

	public Iterable<Integer> convert2(Iterable<String> source, Converter<String, Integer> converter) {
	
		Collection<Integer> result = new ArrayList<Integer>() ;
		
		for(String element: source) {
			result.add(converter.convert(element));
		}
		
		return result;
	}
	
	public <T, S> Iterable<T> convert1(Iterable<S> source, Converter<S, T> converter) {
		
		Collection<T> result = new ArrayList<T>();
		
		for(S element: source) {
			result.add(converter.convert(element));
		}
		
		return result;
	}
	
	public Iterable<String> deployUsingMapping(Iterable<String> environments) {
		return convert1(environments, new DeployConverter());
	}
	
	public Iterable<String> deployUsingFluentMapping(Iterable<String> environments) {
		return with(environments).convert(new DeployConverter());
	}

	class DeployConverter implements Converter<String, String> {
	    public String convert(String env) {
	        return "Deployed to " + env;
	    }
	}

}

