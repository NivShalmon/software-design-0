package library;

/**
 * An object that stores data in lines in a persistent way
 */
public interface Storer {
	/**
	 * appends a line to the end of the file
	 * @param line the string to be appended
	 */
  public void appendLine(String line);
  /**
   * @param lineNumber the number of line to read
   * @return the contents of the line
   */
  public String read(int lineNumber);
  /**
   * @return the number of lines in the file
   */
  public int numberOfLines();
}
