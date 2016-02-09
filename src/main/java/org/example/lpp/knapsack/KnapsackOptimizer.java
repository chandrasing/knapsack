package org.example.lpp.knapsack;

import java.util.Collections;

public interface KnapsackOptimizer {
	Solution NO_SOLUTION = new Solution(Collections.emptyList());

	Solution optimize(final Double target);
}