package org.example.lpp.knapsack.impls;

import org.example.lpp.knapsack.Item;
import org.example.lpp.knapsack.Solution;
import org.junit.Test;

import java.util.Arrays;

import static org.example.lpp.knapsack.KnapsackOptimizer.NO_SOLUTION;
import static org.junit.Assert.assertEquals;

public class GreedyKnapsackTest {
	@Test
	public void optimizeNullList() throws Exception {
		assertEquals(new GreedyKnapsack(null).optimize(1d), NO_SOLUTION);
	}

	@Test
	public void optimizeEmptyList() throws Exception {
		assertEquals(new GreedyKnapsack(null).optimize(1d), NO_SOLUTION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void optimiseForLessThanOne() throws Exception {
		new GreedyKnapsack(Arrays.asList(new Item(1, 1.0, 1.0))).optimize(0d);
	}

	@Test
	public void optimizeImpossibleSolution() throws Exception {
		assertEquals(new GreedyKnapsack(Arrays.asList(new Item(1, 2.0, 1.0))).optimize(1d), NO_SOLUTION);
	}

	@Test
	public void optimize() {
		Solution solution = new GreedyKnapsack(Arrays.asList(new Item(1, 1.0, 1.0), new Item(1, 1.0, 2.0))).optimize(1d);
		assertEquals(solution.getPrice(), 2.0, 0.0);
		assertEquals(solution.getWeight(), 1.0, 0.0);
	}
}