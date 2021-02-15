package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    Product item1 = new Product(1, "Harry Potter", 800);
    Product item2 = new Product(2, "Lord Of The Rings", 700);
    Product item3 = new Product(3, "Iphone", 90000);
    Product item4 = new Product(4, "Samsung", 80000);


    @BeforeEach
    public void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);

    }

    @Test
    void shouldRemoveByExistId() {
        repository.removeById(2);
        Product[] expected = new Product[]{item1, item3, item4};
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowWithNotExistId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(20));
    }




}