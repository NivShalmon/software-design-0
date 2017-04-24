package library;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.*;
import org.junit.Test;

public class DictTest {
  @Test public void test0() {
    List<Pair> input = new ArrayList<Pair>();
    input.add(new Pair("a", "Dor"));
    input.add(new Pair("b", "Niv"));
    Dict testDict = new Dict(new TestStorer());
    
    testDict.store(input);
    //
    assertEquals("Niv", testDict.find("b").get());
    assertEquals("Dor", testDict.find("a").get());
  }
  @Test public void test1() {
    List<Pair> input = new ArrayList<Pair>();
    input.add(new Pair("a", "Dor"));
    input.add(new Pair("b", "Niv"));
    Dict testDict = new Dict(new TestStorer());
    //
    testDict.store(input);
    //
    assertThat(testDict.find("asdf"), is(Optional.empty()));
  }
  @Test public void test2() {
    List<Pair> input = new ArrayList<Pair>();
    for (int i = 0; i < 3339; i++) {
      input.add(new Pair(i + "", i + ""));
    }
    Dict testDict = new Dict(new TestStorer());
    //
    testDict.store(input);
    //
    assertEquals(1456 + "", testDict.find("1456").get());
    assertEquals(Optional.empty(), testDict.find("4000"));
  }
}
