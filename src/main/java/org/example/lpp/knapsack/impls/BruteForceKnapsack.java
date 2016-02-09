package org.example.lpp.knapsack.impls;

import org.example.lpp.knapsack.Item;
import org.example.lpp.knapsack.KnapsackOptimizer;
import org.example.lpp.knapsack.Solution;
import org.example.lpp.util.PowerSetGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BruteForceKnapsack implements KnapsackOptimizer {
	private final List<Item> items;
	private final PowerSetGenerator<Item> powerSetGenerator;

	public BruteForceKnapsack(final List<Item> items, final PowerSetGenerator<Item> powerSetGenerator) {
		this.items = items;
		this.powerSetGenerator = powerSetGenerator;
	}

	@Override
	public Solution optimize(Double target) {
		if (null == items) {
			return NO_SOLUTION;
		}

		if (1 > target) {
			throw new IllegalArgumentException("Target can not be less than 1");
		}

		Set<List<Item>> powerSet = powerSetGenerator.generate(items);
		Double bestPriceSoFar = 0.0;
		List<Item> bestCombination = Collections.emptyList();
		for (List<Item> list : powerSet) {
			Double currentCombinationWeight = getTotalWeightFor(list);
			if (Double.compare(currentCombinationWeight, target) < 1) {
				Double currentListPrice = getTotalPrice(list);
				if (Double.compare(bestPriceSoFar, currentListPrice) == -1) {
					bestCombination = list;
					bestPriceSoFar = currentListPrice;
				} else if (Double.compare(bestPriceSoFar, currentListPrice) == 0) {
					Double bestCombinationWeight = getTotalWeightFor(bestCombination);
					if (Double.compare(bestCombinationWeight, currentCombinationWeight) == 1) {
						bestCombination = list;
					}
				}
			}
		}

		return bestCombination.isEmpty() ? NO_SOLUTION : new Solution(bestCombination);
	}

	private Double getTotalWeightFor(List<Item> items) {
		return null == items || items.isEmpty() ? 0.0 : items.stream().map(Item::getWeight).reduce((total, weight) -> total += weight).get();
	}

	private Double getTotalPrice(List<Item> items) {
		return null == items || items.isEmpty() ? 0.0 : items.stream().map(Item::getPrice).reduce((total, price) -> total += price).get();
	}
}
