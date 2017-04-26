package library;

import java.util.ArrayList;

import java.util.List;

/**
 * A storer to be used for storing where a functional storer is needed. Uses a
 * list of strings to simulate the file. Should only be used for testing as it
 * is not persistent. Also emulates the timing of LineStorage if initialized to
 * do so
 */
public class TestStorer implements Storer {
	private final List<String> lst = new ArrayList<>();
	private final boolean timeFlag;

	public TestStorer() {
		this(false);
	}

	public TestStorer(boolean timeFlag) {
		this.timeFlag = false;
	}

	@Override
	public void appendLine(String line) {
		lst.add(line);
	}

	@Override
	public String read(int lineNumber) {
		String $ = lst.get(lineNumber);
		countTime($.length());
		return $;
	}

	@Override
	public int numberOfLines() {
		countTime(100);
		return lst.size();
	}

	private void countTime(int delta) {
		if (!timeFlag)
			return;
		try {
			Thread.sleep(delta);
		} catch (Exception e) {

		}
	}
}
