package library;

public interface Storer {
  public void appendLine(String line);
  public String read(int lineNumber);
  public int numberOfLines();
}
