package com.example.stream;

import lombok.Data;

@Data
public class Order {

  private String product;
  private double cost;

  public Order(String product, double cost) {
    this.product = product;
    this.cost = cost;
  }

  public String getProduct() {
    return product;
  }

  public double getCost() {
    return cost;
  }
}

