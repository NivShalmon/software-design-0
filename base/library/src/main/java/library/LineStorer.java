package library;

import il.ac.technion.cs.sd.grades.ext.LineStorage;

/**
 * A wrapper class for {@link LineStorage}, to allow use of it
 * as a {@link Storer}
 */
public class LineStorer implements Storer {
  @Override public void appendLine(String line) {
    LineStorage.appendLine(line);
  }
  @Override public String read(int lineNumber) {
    try {
      return LineStorage.read(lineNumber);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
  @Override public int numberOfLines() {
    try {
      return LineStorage.numberOfLines();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
