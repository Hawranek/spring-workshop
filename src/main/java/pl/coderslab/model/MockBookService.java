package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MockBookService implements BookService {
    private List<Book> books;
    private static Long nextId;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
        nextId=books.size()+1L;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Optional<Book> get(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public void update(Book book) {
        if (this.get(book.getId()).isPresent()) {           //metoda Optionala .isPresent()
            int indexOf = books.indexOf(this.get(book.getId()).get());      //metoda Optionala get() - pobiera wartość, jeśli istnieje
            books.set(indexOf, book);
        }
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            books.remove(this.get(id).get());
        }
    }


    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
