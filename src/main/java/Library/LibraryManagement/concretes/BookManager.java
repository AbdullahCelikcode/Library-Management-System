package Library.LibraryManagement.concretes;

import Library.LibraryManagement.abstracts.BookService;
import Library.LibraryManagement.dataAccess.abstracts.BookRepository;
import Library.LibraryManagement.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookManager implements BookService {
    private BookRepository bookRepository;
    @Override
    public List<Book> findAll() {

       return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        Optional<Book> result=bookRepository.findById(id);
        Book book=null;
        if(result.isPresent()) book=result.get();
        else {
            throw new RuntimeException("book is not found");
        }
    return book;
    }

    @Override
    public void add(Book book) {
      bookRepository.save(book);
    }


}
