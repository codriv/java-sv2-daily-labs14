package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    void init() {
        orderService = new OrderService();

        Product p1 = new Product("Tv", "IT", 2000);
        Product p2 = new Product("Laptop", "IT", 2400);
        Product p3 = new Product("Phone", "IT", 400);
        Product p4 = new Product("Lord of The Rings", "Book", 20);
        Product p5 = new Product("Harry Potter Collection", "Book", 120);

        Order o1 = new Order("pending", LocalDate.of(2021, 06, 07));
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p5);
        o1.addProduct(p4);

        Order o2 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o2.addProduct(p3);
        o2.addProduct(p1);
        o2.addProduct(p2);

        Order o3 = new Order("pending", LocalDate.of(2021, 06, 07));
        o3.addProduct(p1);
        o3.addProduct(p2);
        o3.addProduct(p5);

        Order o4 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o4.addProduct(p3);
//        o4.addProduct(p1);
        o4.addProduct(p2);

        Order o5 = new Order("pending", LocalDate.of(2021, 06, 07));
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p5);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void testByStatus() {
        assertEquals(3, orderService.ordersByStatus("pending"));
    }

    @Test
    void testByDate() {
        assertEquals(2, orderService.ordersBetween(LocalDate.of(2021, 5, 30),
                LocalDate.of(2021, 6, 2)).size());
        assertEquals("Phone", orderService.ordersBetween(LocalDate.of(2021, 5, 30),
                LocalDate.of(2021, 6, 2)).get(1).getProducts().get(0).getName());
    }

    @Test
    void isOrder() {
        assertTrue(orderService.isOrder(3));
        assertFalse(orderService.isOrder(2));
    }

    @Test
    void most() {
        assertEquals("pending", orderService.mostProduct().getStatus());
        assertEquals(4, orderService.mostProduct().getProducts().size());
        assertEquals("Harry Potter Collection", orderService.mostProduct().getProducts().get(2).getName());
    }

    @Test
    void orderByCategory() {
        assertEquals(3, orderService.orderByCategory("Book").size());
    }
}