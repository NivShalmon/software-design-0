package library;

import java.util.ArrayList;

import java.util.List;

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
