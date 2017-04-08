package library;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DictTest {
  @Test public void test() {
    List<Pair> input = new ArrayList<Pair>();
    input.add(new Pair("a", "Dor"));
    input.add(new Pair("b", "Niv"));
    Dict dict = new Dict(input);
    //
    assertEquals("Niv", dict.find("b"));
    assertEquals("Dor", dict.find("a"));
  }
}
