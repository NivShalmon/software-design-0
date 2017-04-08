package library;

public class Pair implements Comparable<Pair> {
  private String key;
  private String value;

  public Pair(String key, String value) {
    this.key = key;
    this.value = value;
  }
  public String getValue() {
    return this.value;
  }
  public String getKey() {
    return this.key;
  }
  public void setKey(String key) {
    this.key = key;
  }
  public void setValue(String value) {
    this.value = value;
  }
  @Override public int compareTo(Pair o) {
    return this.getKey().compareTo(o.getKey());
  }
}
