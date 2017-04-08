package library;

import java.util.List;

public class Dict {
  public static void store(List<Pair> pairs) {
    store(pairs, new LineStorer());
  }
  public static void store(List<Pair> pairs, Storer storer) {
    pairs.stream().sorted().forEachOrdered(element -> {
      storer.appendLine(element.getKey());
      storer.appendLine(element.getValue());
    });
  }
  public static String find(String key) {
    return find(key, new LineStorer());
  }
  public static String find(String key, Storer storer) {
    int size = storer.numberOfLines();
    assert (size % 2 == 0);
    for (int high = (size / 2) - 1, low = 0; high >= low;) {
      int mid = (low + high) / 2;
      String current = storer.read(2 * mid);
      int comparison = current.compareTo(key);
      if (comparison == 0)
        return storer.read(2 * mid + 1);
      if (comparison < 0)
        low = mid + 1;
      else
        high = mid - 1;
    }
    return null;
  }
}
