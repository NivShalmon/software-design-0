package il.org.technion.cs.sd.app;

import org.junit.Test;

import il.ac.technion.cs.sd.app.GradesInitializer;
import library.Dict;
import library.Pair;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import java.util.Collection;
import java.util.LinkedList;

public class GradesInitializerTest {

	@Test
	public void test0() {
		Dict dict = mock(Dict.class);
		GradesInitializer gi = new GradesInitializer(dict);
		//
		gi.setup("0,100\n99,100");
		//
		verify(dict, only()).store(any());
	}

	@Test
	public void test1() {
		Dict dict = mock(Dict.class);
		Collection<Pair> stored = new LinkedList<>();
		doAnswer(invocation -> stored.addAll(invocation.getArgument(0)))//
				.when(dict).store(any());
		GradesInitializer gi = new GradesInitializer(dict);
		//
		gi.setup("99,80\n99,100");
		//
		assertThat(stored.iterator().next(), is(new Pair("99","100")));
		assertEquals(1, stored.size());
	}

}
