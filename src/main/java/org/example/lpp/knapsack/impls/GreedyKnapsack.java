package org.example.lpp.knapsack.impls;

import org.example.lpp.knapsack.Item;
import org.example.lpp.knapsack.KnapsackOptimizer;
import org.example.lpp.knapsack.Solution;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GreedyKnapsack implements KnapsackOptimizer {
	private final List<Item> items;

	public GreedyKnapsack(final List<Item> items) {
		this.items = items;
	}

	public Solution optimize(Double target) {
		if (null == items) {
			return NO_SOLUTION;
		}

		if (1 > target) {
			throw new IllegalArgumentException("Target can not be less than 1");
		}

		Collections.sort(items, Item.byPricePerWeight());
		Double total = 0d;

		/**
		 * Following could have been lambda but to find out weight of selected items
		 * would need to iterate over chosen items which IMO is unnecessary.
		 */
		List<Item> chosenItems = new LinkedList<>();
		for (Item item : items) {
			if (total + item.getWeight() <= target) {
				chosenItems.add(item);
				total = total + item.getWeight();
			}
		}

		return chosenItems.isEmpty() ? NO_SOLUTION : new Solution(chosenItems);
	}
}
