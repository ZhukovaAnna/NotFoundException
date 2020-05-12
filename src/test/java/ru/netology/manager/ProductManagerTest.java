package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book first = new Book(1, "Charlotte’s Web", 1000, "E.B. White", 200);
    TShirt second = new TShirt(2, "Lacoste", 2000, "white", "s");

    @BeforeEach
    void setup() {
        manager = new ProductManager(repository);
        manager.productAdd(first);
        manager.productAdd(second);
    }

    @Test
    void shouldFindIfExist() {
        int idToFind = 1;
        Product expected = first;
        Product actual = manager.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindIfNotExist() {
        int idToFind = 4;
        manager.findById(idToFind);
        Product expected = null;
        Product actual = manager.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfExist() {
        int idToFind = 2;
        manager.removeById(idToFind);
        Product actual = manager.findById(idToFind);
        assertEquals(null,actual);
    }

    @Test
    void shouldNotRemoveIfNotExists() {
        int idToFind = 4;
        assertThrows(RuntimeException.class, () -> manager.removeById(idToFind));
    }
}