package org.example;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        Customer customer1 = new Customer(1L, "Arianna", 1);
        Customer customer2 = new Customer(2L, "Riccardo", 1);
        Customer customer3 = new Customer(3L, "Bangu", 2);
        Customer customer4 = new Customer(4L, "Beso", 3);

        Product product1 = new Product(1L, "Sweets", "Food", 13.0);
        Product product2 = new Product(2L, "Wet Food", "Animals", 3.0);
        Product product3 = new Product(3L, "Spumone", "Beauty", 12.0);
        Product product4 = new Product(4L, "Luce Liquida", "Beauty", 15.0);
        Product product5 = new Product(5L, "Cat Toys", "Animals", 20.0);

        LocalDate deliveryDate1 = LocalDate.of(2024, 6, 3);
        LocalDate deliveryDate2 = LocalDate.of(2024, 10, 12);
        LocalDate deliveryDate3 = LocalDate.of(2024, 8, 6);
        LocalDate deliveryDate4 = LocalDate.of(2024, 11, 18);

        Order order1 = new Order(1L, deliveryDate1, List.of(product3, product4), customer1);
        Order order2 = new Order(2L, deliveryDate2, List.of(product1), customer2);
        Order order3 = new Order(2L, deliveryDate3, List.of(product2), customer3);
        Order order4 = new Order(2L, deliveryDate4, List.of(product5), customer4);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4);
        List<Product> products = List.of(product1, product2, product3, product4, product5);

        System.out.println(" ");
        System.out.println("-------------------------ESERCIZIO 1-----------------------------");
        System.out.println(" ");

        Map<Customer, List<Order>> ordersPerCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        ordersPerCustomer.forEach((customer, orderList) -> {
            System.out.println("Customer: " + customer.getName());
            orderList.forEach(order -> {
                System.out.println(" Order ID: " + order.getId() + ", Delivery Date: " + order.getDeliveryDate());
                order.getProducts().forEach(product -> System.out.println(" Product: " + product.getName() + " - Price: " + product.getPrice()));
            });
        });

        System.out.println(" ");
        System.out.println("-------------------------ESERCIZIO 2-----------------------------");
        System.out.println(" ");

        Map<Customer, Double> salesPerCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getCustomer(),
                        Collectors.summingDouble(order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum())
                ));


        salesPerCustomer.forEach((customer, total) ->
                System.out.println("Customer: " + customer.getName() + " - Total Sales: " + total)
                );

        System.out.println(" ");
        System.out.println("-------------------------ESERCIZIO 3-----------------------------");
        System.out.println(" ");

        Optional<Product> mostExpProd = products.stream()
                .max(Comparator.comparingDouble(Product::getPrice));

        mostExpProd.ifPresent(product ->System.out.println("The most expensive product is: " + product.getName() + " - Price: " + product.getPrice()));

        System.out.println(" ");
        System.out.println("-------------------------ESERCIZIO 4-----------------------------");
        System.out.println(" ");

       double avaragePerOrder = orders.stream()
               .mapToDouble(order -> order.getProducts().stream()
                       .mapToDouble(Product::getPrice)
                       .sum())
               .average()
               .orElse(0);

       System.out.println("The avarge value is: " + avaragePerOrder);
    }
}
