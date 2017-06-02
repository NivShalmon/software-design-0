package il.ac.technion.cs.sd.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.openmbean.KeyAlreadyExistsException;

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
			assert arr.length == 2 : "not legal csv";
			return new Pair(arr[0], arr[1]);
		}).collect(Collectors.toList());
		Map<String,Pair> $ = new HashMap<>();
		pairs.forEach(p -> $.put(p.getKey(), p));
		dict.store($.values());
	}

}
