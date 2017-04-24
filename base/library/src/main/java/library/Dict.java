package library;

import java.util.List;
import java.util.Optional;

/**
 * Implements a basic dictionary using a Storer and binary search. The defualt
 * Storer is LineStorer, which is a wrapper to base's LineStorage.
 */
public class Dict {

	private final Storer storer;
	private boolean initialized = false;

	public Dict() {
		this(new LineStorer());
	}

	public Dict(Storer storer) {
		this.storer = storer;
	}

	/** stores a list of pairs in the supplied storer.
	 * Should only be called once.
	 * @param pairs
	 */
	public void store(List<Pair> pairs) {
		assert initialized = !initialized; //assert store wasn't called yet
		pairs.stream().sorted().forEachOrdered(element -> {
			storer.appendLine(element.getKey());
			storer.appendLine(element.getValue());
		});
	}

	/**
	 * @param key the key to be searched in the dictionary
	 * @return the value that matches key or Optional.empty() otherwise.
	 */
	public Optional<String> find(String key) {
		int size = storer.numberOfLines();
		assert size % 2 == 0;
		for (int high = (size / 2) - 1, low = 0; high >= low;) {
			int mid = (low + high) / 2;
			String current = storer.read(2 * mid);
			int comparison = current.compareTo(key);
			if (comparison == 0)
				return Optional.of(storer.read(2 * mid + 1));
			if (comparison < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return Optional.empty();
	}
}
