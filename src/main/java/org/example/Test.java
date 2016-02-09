package org.example;

import org.example.lpp.knapsack.Item;
import org.example.lpp.knapsack.impls.BruteForceKnapsack;
import org.example.lpp.knapsack.impls.GreedyKnapsack;
import org.example.lpp.util.IterativePowerSetGenerator;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		IterativePowerSetGenerator<Item> itemIterativePowerSetGenerator = new IterativePowerSetGenerator<>();

		System.out.println("1st box (81)");
		List<Item> itemList = Arrays.asList(
				new Item(1, 53.38, 45d),
				new Item(2, 88.62, 98d),
				new Item(3, 78.48, 3d),
				new Item(4, 72.30, 76d),
				new Item(5, 30.18, 9d),
				new Item(6, 46.34, 48d)
		);
		System.out.println("item\tprofit\tweight");
		itemList.forEach(item -> System.out.println(item.getId() + "\t" + item.getPrice() + "\t" + item.getWeight()));

		GreedyKnapsack greedyKnapsack = new GreedyKnapsack(itemList);
		System.out.println("Greedy Solution is : \n" + greedyKnapsack.optimize(81d));

		BruteForceKnapsack bruteForceKnapsack = new BruteForceKnapsack(itemList, itemIterativePowerSetGenerator);
		System.out.println("Brute force Solution is: \n" + bruteForceKnapsack.optimize(81d));

		System.out.println("\n\n2nd box (8)");
		itemList = Arrays.asList(new Item(1, 15.3, 34d));
		System.out.println("item\tprofit\tweight");
		itemList.forEach(item -> System.out.println(item.getId() + "\t" + item.getPrice() + "\t" + item.getWeight()));

		greedyKnapsack = new GreedyKnapsack(itemList);
		System.out.println("Greedy Solution is : \n" + greedyKnapsack.optimize(8d));

		bruteForceKnapsack = new BruteForceKnapsack(itemList, itemIterativePowerSetGenerator);
		System.out.println("Brute force Solution is: \n" + bruteForceKnapsack.optimize(8d));

		System.out.println("\n\n3rd box (75)");
		itemList = Arrays.asList(
				new Item(1, 85.31, 29d),
				new Item(2, 14.55, 74d),
				new Item(3, 3.98, 16d),
				new Item(4, 26.24, 55d),
				new Item(5, 63.69, 52d),
				new Item(6, 76.25, 75d),
				new Item(7, 60.02, 74d),
				new Item(8, 93.18, 35d),
				new Item(9, 89.95, 78d)
		);
		System.out.println("item\tprofit\tweight");
		itemList.forEach(item -> System.out.println(item.getId() + "\t" + item.getPrice() + "\t" + item.getWeight()));

		greedyKnapsack = new GreedyKnapsack(itemList);
		System.out.println("Greedy Solution is : \n" + greedyKnapsack.optimize(75d));

		bruteForceKnapsack = new BruteForceKnapsack(itemList, itemIterativePowerSetGenerator);
		System.out.println("Brute force Solution is: \n" + bruteForceKnapsack.optimize(75d));

		System.out.println("\n\n4th box (56)");
		itemList = Arrays.asList(
				new Item(1, 90.72, 13d),
				new Item(2, 33.80, 40d),
				new Item(3, 43.15, 10d),
				new Item(4, 37.97, 16d),
				new Item(5, 46.81, 36d),
				new Item(6, 48.77, 79d),
				new Item(7, 81.80, 45d),
				new Item(8, 19.36, 79d),
				new Item(9, 6.76, 64d)
		);
		System.out.println("item\tprofit\tweight");
		itemList.forEach(item -> System.out.println(item.getId() + "\t" + item.getPrice() + "\t" + item.getWeight()));

		greedyKnapsack = new GreedyKnapsack(itemList);
		System.out.println("Greedy Solution is : \n" + greedyKnapsack.optimize(56d));

		bruteForceKnapsack = new BruteForceKnapsack(itemList, itemIterativePowerSetGenerator);
		System.out.println("Brute force Solution is: \n" + bruteForceKnapsack.optimize(56d));
	}
}
