package library;

import java.util.ArrayList;

import java.util.List;

/**
 * A storer to be used for storing where a functional storer
 * is needed. Uses a list of strings to simulate the file.
 * Should only be used for testing as it is not persistent.
 */
public class TestStorer implements Storer {
  private List<String> lst = new ArrayList<>();

  @Override public void appendLine(String line) {
    lst.add(line);
  }
  @Override public String read(int lineNumber) {
    return lst.get(lineNumber);
  }
  @Override public int numberOfLines() {
    return lst.size();
  }
}
