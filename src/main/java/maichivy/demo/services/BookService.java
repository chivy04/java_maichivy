package maichivy.demo.services;

import maichivy.demo.repository.IBookRepository;
import maichivy.demo.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book get(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }
}
