package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    Book first = new Book(1, "Charlotte’s Web", 1000, "E.B. White", 200);
    TShirt second = new TShirt(2, "Lacoste", 2000, "white", "s");

    @Test
    void shouldSave() {
        repository.save(first);
        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturn() {
        repository.save(first);
        repository.save(second);
        Product[] expected = new Product[]{first, second};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIfExist() {
        repository.save(first);
        int idToFind = 1;
        repository.findById(idToFind);
        Product expected = first;
        Product actual = repository.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindByNotExist() {
        int idToFind = 3;
        repository.findById(idToFind);
        Product actual = repository.findById(idToFind);
        assertNull(actual);
    }

    @Test
    void shouldRemoveIfExist() {
        repository.save(first);
        repository.save(second);
        int idToRemove = 2;
        repository.removeById(idToRemove);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveIfNotExists() {
        int idToRemove = 5;
        assertThrows(RuntimeException.class, () -> repository.removeById(idToRemove));
    }
}