package org.example.lpp.util;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IterativePowerSetGeneratorTest {
	private List<Integer> integers;
	private final IterativePowerSetGenerator<Integer> iterativePowerSetGenerator = new IterativePowerSetGenerator<>();

	@Before
	public void setUp() throws Exception {
		integers = Arrays.asList(1, 2);
	}

	@After
	public void tearDown() throws Exception {
		integers = null;
	}

	@Test
	public void powerSetCardinality() throws Exception {
		assertEquals(iterativePowerSetGenerator.generate(integers).size(), 4);
	}

	@Test
	public void powerSetOfEmptySet() throws Exception {
		assertEquals(iterativePowerSetGenerator.generate(Collections.emptyList()).size(), 1);
	}

	@Test
	public void powerSetOfNULLSet() throws Exception {
		assertEquals(iterativePowerSetGenerator.generate(null).size(), 1);
	}
}