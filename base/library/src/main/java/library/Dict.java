package library;

import java.util.List;

import il.ac.technion.cs.sd.grades.ext.LineStorage;

public class Dict {
  public Dict(List<Pair> pairs) {
    pairs.stream().sorted().forEachOrdered(element -> {
      LineStorage.appendLine(element.getKey());
      LineStorage.appendLine(element.getValue());
    });
  }
  public String find(String key) {
    try {
      int size = LineStorage.numberOfLines();
      assert (size % 2 == 0);
      for (int high = size, low = 0; high >= low;) {
        int mid = (low + high) / 2;
        String current = LineStorage.read(mid);
        int comparison = current.compareTo(key);
        if (comparison == 0)
          return LineStorage.read(mid + 1);
        if (comparison < 0)
          low = mid + 2;
        else
          high = mid - 2;
      }
    } catch (InterruptedException e) {
      // TODO Check, what sould we do here ???
      e.printStackTrace();
    }
    return null;
  }
}
