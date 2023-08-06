package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(0, "Кеды", 3999);
    Product product2 = new Product(1, "Носки", 190);
    Product product3 = new Product(2, "Майка", 299);
    Product product4 = new Product(3, "Плавки", 1290);
    ShopRepository shop = new ShopRepository();

    @Test
    public void shouldRemoveObject() {
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);
        shop.removeByID(product2.getId());
        Product[] expected = {product1, product3, product4};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNotExistingId() {
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);
        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.removeByID(9);
        });
    }

    @Test
    public void shouldAddNewObjectInProducts() {
        Product product5 = new Product(4, "Шапка", 790);
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);
        shop.add(product5);
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProductWithExistingId() {
        Product product5 = new Product(3, "Туфли", 7990);
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shop.add(product5);
        });
    }
}