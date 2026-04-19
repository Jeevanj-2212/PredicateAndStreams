package streamSampleProject;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamSampleMain {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "John", "Bangalore",
                        List.of(new Item("Laptop", "Electronics", 1, 70000),
                                new Item("Mouse", "Electronics", 2, 500)),
                        71000, "DELIVERED"),

                new Order(2, "Alice", "Mumbai",
                        List.of(new Item("Shoes", "Fashion", 2, 2000)),
                        4000, "PENDING"),

                new Order(3, "Bob", "Bangalore",
                        List.of(new Item("Phone", "Electronics", 1, 30000)),
                        30000, "DELIVERED"),

                new Order(4, "John", "Bangalore",
                        List.of(new Item("T-Shirt", "Fashion", 3, 1000)),
                        3000, "CANCELLED")
        );

      List<String> productName = orders.stream().filter(order->order.getCity().equals("Bangalore")&&order.getStatus().equals("DELIVERED"))
              .flatMap(order->order.getItems().stream()).sorted(Comparator.comparing(Item::getPrice).reversed())
              .map(Item::getProductName).toList();

        System.out.println(productName);


       //Product names where
        //
        //order is DELIVERED
        //AND item price > 10,000
       List<String> pName =  orders.stream().filter(order->order.getStatus().equals("DELIVERED"))
                .flatMap(order->order.getItems().stream()).filter(
                        item->item.getPrice()>10000
                ).map(Item::getProductName).toList();
        System.out.println(pName);

        //All product names starting with "p" or "P", sorted alphabetically
        List<String> st =  orders.stream().flatMap(order->order.getItems().stream())
                .map(Item::getProductName).filter(name -> name.toLowerCase().startsWith("p")
                        ).sorted().toList();
        System.out.println(st);

        //Top 2 cheapest product names across all orders

       List <String>cProduct =  orders.stream().flatMap(order->order.getItems().stream()).
                sorted(Comparator.comparing(Item::getPrice)).limit(2)
                .map(Item::getProductName).toList();
        System.out.println(cProduct);

        //All unique categories from DELIVERED orders
        List <String> cat = orders.stream().filter(order->"DELIVERED".equals(order.getStatus()))
                .flatMap(order->order.getItems().stream())
                .map(Item::getCategory).distinct().toList();
        System.out.println(cat);


        //A single string of all product names from DELIVERED orders, separated by comma
        String val  = orders.stream().filter(order->"DELIVERED".equals(order.getStatus()))
                .flatMap(order->order.getItems().stream()).map(Item::getProductName)
                .collect(Collectors.joining(", "));
        System.out.println(val);
        //First product name with price > 50,000
       String res = orders.stream().flatMap(order->order.getItems().stream())
                .filter(item->item.getPrice()>50000)
                .map(Item::getProductName).findFirst().get();
        System.out.println(res);


    }
}
