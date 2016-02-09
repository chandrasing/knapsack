package org.example.lpp.util;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class RecursivePowerSetGeneratorTest {
	private List<Integer> integers;
	private final RecursivePowerSetGenerator<Integer> recursivePowerSetGenerator = new RecursivePowerSetGenerator<>();

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
		assertEquals(recursivePowerSetGenerator.generate(integers).size(), 4);
	}

	@Test
	public void powerSetOfEmptySet() throws Exception {
		assertEquals(recursivePowerSetGenerator.generate(Collections.emptyList()).size(), 1);
	}

	@Test
	public void powerSetOfNULLSet() throws Exception {
		assertEquals(recursivePowerSetGenerator.generate(null).size(), 1);
	}
}