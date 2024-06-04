package com.example.stream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {

  public static void main(String[] args) {
    List<Order> orders = List.of(
        new Order("Laptop", 1200.0),
        new Order("Smartphone", 800.0),
        new Order("Laptop", 1500.0),
        new Order("Tablet", 500.0),
        new Order("Smartphone", 900.0)
    );
    //сортировка по продуктам
    List<Order> groupByProduct = orders.stream().sorted(Comparator.comparing(Order::getProduct))
        .toList();
    //группировка по продуктам
    Map<String, List<Order>> map1 = orders.stream()
        .collect(Collectors.groupingBy(Order::getProduct));
    //общая стоимость всех продуктов
    double cost = orders.stream().mapToDouble(Order::getCost).sum();
    //сортировка по убыванию стоимости
    List<Order> sortedCost = orders.stream()
        .sorted(Collections.reverseOrder(Comparator.comparing(Order::getCost))).toList();
    //3 самых дорогих продукта
    List<Order> theMostExpensiveOrders = orders.stream().limit(3)
        .sorted(Collections.reverseOrder(Comparator.comparing(Order::getCost))).toList();
    //общая стоимость 3-х самых дорогих продуктов
    double costTheMostExpensiveOrders = orders.stream().limit(3)
        .sorted(Collections.reverseOrder(Comparator.comparing(Order::getCost)))
        .mapToDouble(Order::getCost).sum();

    System.out.printf("3 the most expensive products: %s",
        theMostExpensiveOrders + ", total cost: " + costTheMostExpensiveOrders);
  }

}
