package org.example.lpp.knapsack;

import java.util.List;

public class Solution {
	private final List<Item> itemList;

	public Solution(final List<Item> itemList) {
		this.itemList = itemList;
	}

	public Double getWeight() {
		return null == itemList || itemList.isEmpty() ? 0.0 : itemList.stream().map(Item::getWeight).reduce((total, weight) -> total+= weight).get();
	}

	public Double getPrice() {
		return null == itemList || itemList.isEmpty() ? 0.0 : itemList.stream().map(Item::getPrice).reduce((total, price) -> total+= price).get();
	}

	@Override
	public String toString() {
		return "Solution{" +
				"itemList=" + itemList +
				", weight=" + getWeight() +
				", price=" + getPrice() +
				'}';
	}
}
