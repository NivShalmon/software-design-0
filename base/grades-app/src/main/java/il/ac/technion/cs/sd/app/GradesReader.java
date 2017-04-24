package il.ac.technion.cs.sd.app;

import java.util.Optional;
import java.util.OptionalInt;

import library.Dict;

/**
 * This class will only be instantiated after
 * {@link il.ac.technion.cs.sd.app.GradesInitializer#setup(java.lang.String) has
 * been called}.
 */
public class GradesReader {

	private final Dict dict;
	
	public GradesReader(){
		this(new Dict());
	}
	
	public GradesReader(Dict dict){
		this.dict = dict;
	}
	
	/** Returns the grade associated with the ID, or empty. */
	public OptionalInt getGrade(String id) {
		Optional<String> grade = dict.find(id);
		return !grade.isPresent() ? OptionalInt.empty() : OptionalInt.of(Integer.parseInt(grade.get())); 
	}
}
