package org.example.lpp.util;

import java.util.*;


public class RecursivePowerSetGenerator<T> implements PowerSetGenerator<T> {
	@Override
	public Set<List<T>> generate(List<T> set) {
		Set<List<T>> sets = new HashSet<>();
		if (null == set
				|| set.isEmpty()) {
			sets.add(Collections.emptyList());
			return sets;
		}

		List<T> list = new ArrayList<>(set);
		T head = list.get(0);
		List<T> rest = new LinkedList<>(list.subList(1, list.size()));
		for (List<T> subSet : generate(rest)) {
			List<T> newSet = new LinkedList<>();
			newSet.add(head);
			newSet.addAll(subSet);
			sets.add(newSet);
			sets.add(subSet);
		}

		return Collections.unmodifiableSet(sets);
	}
}
