package library;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DictTest {
  @Test public void test0() {
    List<Pair> input = new ArrayList<Pair>();
    input.add(new Pair("a", "Dor"));
    input.add(new Pair("b", "Niv"));
    TestStorer testStorer = new TestStorer();
    Dict.store(input, testStorer);
    //
    assertEquals("Niv", Dict.find("b", testStorer));
    assertEquals("Dor", Dict.find("a", testStorer));
  }
  @Test public void test1() {
    List<Pair> input = new ArrayList<Pair>();
    input.add(new Pair("a", "Dor"));
    input.add(new Pair("b", "Niv"));
    TestStorer testStorer = new TestStorer();
    Dict.store(input, testStorer);
    //
    assertEquals(null, Dict.find("asdf", testStorer));
  }
  @Test public void test2() {
    List<Pair> input = new ArrayList<Pair>();
    for (int i = 0; i < 3339; i++) {
      input.add(new Pair(i + "", i + ""));
    }
    TestStorer testStorer = new TestStorer();
    Dict.store(input, testStorer);
    //
    assertEquals(1456 + "", Dict.find("1456", testStorer));
    assertEquals(null, Dict.find("4000", testStorer));
  }
}
