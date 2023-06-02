package maichivy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import maichivy.demo.entity.Book;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private List<Book> books;

    @GetMapping
    public String ListBooks(Model model) {
        model.addAttribute("books", books);
        model.addAttribute("title", "Book List");
        return "book/list";
    }

    @GetMapping("/add")
    public String AddForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String AddBook(@ModelAttribute("book") Book book) {
        books.add(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String EditForm(@PathVariable("id") Long id, Model model) {
        Optional<Book> editBook = books.stream().filter(book -> book.getId() == id).findFirst();

        if (editBook.isPresent()) {
            model.addAttribute("book", editBook.get());
            return "book/edit";
        }
        else {
            return "not found";
        }
    }

    @PostMapping("/edit")
    public String EditBook(@ModelAttribute("book") Book updatedBook) {
        books.stream().filter(book -> book.getId() == updatedBook.getId()).findFirst().ifPresent(book -> books.set(books.indexOf(book), updatedBook));

        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String DeleteBook(@PathVariable("id") Long id) {
        books.removeIf(book -> book.getId() == id);
        return "redirect:/books";
    }
}
