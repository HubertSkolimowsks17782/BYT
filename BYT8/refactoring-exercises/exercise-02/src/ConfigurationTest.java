import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.Assert.*;

public class ConfigurationTest{

	@Test
	public void testGoodInput() throws IOException {
		String data = "interval = 10\nduration = 100\ndeparture = 200\n";

		Properties input = loadInput(data);

		Configuration props = new Configuration();
		try {
			props.load(input);
		} catch (ConfigurationException e) {
			fail();  //assertTrue(false); simplified to fail();
			return;
		}

		assertEquals(props.interval, 10);
		assertEquals(props.duration, 100);
		assertEquals(props.departure, 200);
	}
	@Test
	public void testNegativeValues() throws IOException {
		processBadInput("interval = -10\nduration = 100\ndeparture = 200\n");
		processBadInput("interval = 10\nduration = -100\ndeparture = 200\n");
		processBadInput("interval = 10\nduration = 100\ndeparture = -200\n");
	}
	@Test
	public void testInvalidDuration() throws IOException {
		processBadInput("interval = 10\nduration = 99\ndeparture = 200\n");
	}
	@Test
	public void testInvalidDeparture() throws IOException {
		processBadInput("interval = 10\nduration = 100\ndeparture = 199\n");
	}

	private void processBadInput(String data) throws IOException {
		Properties input = loadInput(data);

		boolean failed = false;
		Configuration props = new Configuration();
		try {
			props.load(input);
		} catch (ConfigurationException e) {
			failed = true;
		}

		assertTrue(failed);
	}

	private Properties loadInput(String data) throws IOException {
		//InputStream is = new StringBufferInputStream(data);//java.io.StringBufferInputStream' is deprecated
		InputStream is = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
		Properties input = new Properties();
		input.load(is);
		is.close();
		return input;
	}
}
