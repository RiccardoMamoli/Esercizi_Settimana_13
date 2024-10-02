package Esercizio_1;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    public static List<Product> getExpBook(List<Product> products) {
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.toList());
    };

    public static List<Product> getBabyCat(List<Product> products) {
      return products.stream()
              .filter(product -> product.getCategory().equalsIgnoreCase("Baby"))
              .collect(Collectors.toList());
    };

    public static List<Product> getBoysItems(List<Product> products) {
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Boys"))
                .map(product -> {
                    product.setPrice(product.getPrice() * 0.9);
                return product;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1L, "Book 1", "Books", 110.0 ),
                new Product(2L, "Book 2", "Books", 101.0 ),
                new Product(3L, "Book 3", "Books", 93.0 ),
                new Product(4L, "Book 4", "Books", 140.0 ),
                new Product(5L, "Baby Oil", "Baby", 20.0),
                new Product(6L, "Thermos", "Baby", 13.0),
                new Product(7L, "Diapers", "Baby", 15.0),
                new Product(8L, "Lego", "Boys", 80.0),
                new Product(9L, "Football", "Boys", 10.0),
                new Product(10L, "Skateboard", "Boys", 50.0)
        );

        List<Product> expBook = getExpBook(products);
        System.out.println("I libri che costano più di 100 Euro sono: ");
        expBook.forEach(book -> System.out.println("Product: " + book.getName() + " Price: " + book.getPrice()));

        List<Product> babyProd = getBabyCat(products);
        System.out.println("I prodotti sotto la categoria baby sono: ");
        babyProd.forEach(product -> System.out.println("Product: " + product.getName() + " Price: " + product.getPrice()));

        List<Product> getBoys = getBoysItems(products);
        System.out.println("I prodotti scontati sono: ");
        getBoys.forEach(item -> System.out.println("Product: " + item.getName() + "Price: " + item.getPrice()));
    }
}
