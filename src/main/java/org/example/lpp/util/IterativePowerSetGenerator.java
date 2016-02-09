package org.example.lpp.util;

import java.util.*;

public class IterativePowerSetGenerator<T> implements PowerSetGenerator<T> {
	@Override
	public Set<List<T>> generate(List<T> list) {
		Set<List<T>> powerSet = new HashSet<>();
		powerSet.add(Collections.emptyList());
		if (null == list || list.isEmpty()) {
			return powerSet;
		}


		for (T item : list) {
			Set<List<T>> newPowerSet = new HashSet<>();

			for (List<T> subset : powerSet) {
				newPowerSet.add(subset);

				List<T> newSubset = new ArrayList<>(subset);
				newSubset.add(item);
				newPowerSet.add(newSubset);
			}

			powerSet = newPowerSet;
		}

		return powerSet;
	}
}
