package il.ac.technion.cs.sd.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import library.Dict;
import library.Pair;

/** This class will be instantiated once per test. */
public class GradesInitializer {

	private final Dict dict;
	
	public GradesInitializer(){
		this(new Dict());
	}
	
	public GradesInitializer(Dict dict){
		this.dict = dict;
	}
	
	/**
	 * Saves the csvData persistently, so that it could be run using
	 * GradesRunner. The format of each line of the data is $id,$grade.
	 */
	public void setup(String csvData) {
		List<String> lines = Arrays.asList(csvData.split("\n"));
		List<Pair> pairs = lines.stream().map(line -> {
			String[] arr = line.split(",");
			return new Pair(arr[0], arr[1]);
		}).collect(Collectors.toList());
		dict.store(pairs);
	}

}
