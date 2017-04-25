package il.org.technion.cs.sd.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.OptionalInt;

import static org.hamcrest.core.Is.*;
import org.junit.Test;

import il.ac.technion.cs.sd.app.GradesReader;
import library.Dict;

public class GradesReaderTest {
	
	@Test
	public void test0(){
		Dict dict = mock(Dict.class);
		GradesReader gr = new GradesReader(dict);
		String id = "999", grade = "100";
		doReturn(Optional.of(grade)).when(dict).find(id);
		//
		assertThat(gr.getGrade(id),is(OptionalInt.of(Integer.parseInt(grade))));
		verify(dict,only()).find(id);
	}
	
	@Test
	public void test1(){
		Dict dict = mock(Dict.class);
		GradesReader gr = new GradesReader(dict);
		//
		assertThat(gr.getGrade("100"),is(OptionalInt.empty()));
		verify(dict,only()).find("100");
	}

}
