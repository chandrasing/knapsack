package org.example.lpp.knapsack;

import java.util.Comparator;

public class Item {
	private final int id;
	private final Double weight;
	private final Double price;

	public Item(int id, Double weight, Double price) {
		this.id = id;
		this.weight = weight;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getPrice() {
		return price;
	}

	public Double getPricePerWeight() {
		return price / weight;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", weight=" + weight +
				", price=" + price +
				'}';
	}

	public static Comparator<Item> byPricePerWeight() {
		return (v1, v2) -> Double.compare(v2.getPricePerWeight(), v1.getPricePerWeight());
	}
}
