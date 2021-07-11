package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {
    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        return "/books/form";
    }

    @PostMapping("/add")
    public String saveBook(Book book){
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        Optional<Book> book = bookService.get(id);
        model.addAttribute("book",book.orElse(null));
        return "/books/form";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()){
            return "/books/form";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/show/{id}")
    public String showBook(@PathVariable Long id, Model model){
        Optional<Book> book = bookService.get(id);
        model.addAttribute("book",book.orElse(null));
        return "books/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, Model model){
        Optional<Book> book = bookService.get(id);
        model.addAttribute("book",book.orElse(null));
        return "books/del";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }
}
