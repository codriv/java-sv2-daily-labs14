package day01;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public int ordersByStatus(String status) {
        return (int)orders.stream()
                .filter(act -> status.equals(act.getStatus()))
                .count();
    }

    public List<Order> ordersBetween(LocalDate dateFrom, LocalDate dateTo) {
        return orders.stream()
                .filter(order -> order.getOrderDate().isAfter(dateFrom) &&
                        order.getOrderDate().isBefore(dateTo))
                .collect(Collectors.toList());
    }
    
    public boolean isOrder(int num) {
        return orders.stream()
                .anyMatch(order -> order.getProducts().size() < num);
    }

    public Order mostProduct() {
        return orders.stream()
                .max(new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return o1.getProducts().size() - o2.getProducts().size();
                    }
                })
                .get();
    }

    public List<Order> orderByCategory(String category) {
        return orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(o -> category.equals(o.getCategory()))
                    )
                .collect(Collectors.toList());
    }
}