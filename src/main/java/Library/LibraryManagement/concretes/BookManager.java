package Library.LibraryManagement.concretes;

import Library.LibraryManagement.abstracts.BookService;
import Library.LibraryManagement.dataAccess.abstracts.BookRepository;
import Library.LibraryManagement.entity.Book;
import Library.LibraryManagement.mappers.ModelMapperService;
import Library.LibraryManagement.request.CreateBookRequest;
import Library.LibraryManagement.request.UpdateBookRequest;
import Library.LibraryManagement.response.GetAllBookResponse;
import Library.LibraryManagement.response.GetByIdBookResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookManager implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllBookResponse> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book ->
                this.modelMapperService.forResponse().map(book, GetAllBookResponse.class)).collect(Collectors.toList());


    }


    @Override
    public GetByIdBookResponse findById(int id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book is not found"));
        return this.modelMapperService.forResponse().map(book, GetByIdBookResponse.class);

    }

    @Override
    public void add(CreateBookRequest createBookRequest) {
        Book book = this.modelMapperService.forRequest().map(createBookRequest, Book.class);
        bookRepository.save(book);
    }

    @Override
    public List<GetAllBookResponse> findAllReceivableBooks() {
        return bookRepository.findAll().stream()
                .filter(book -> book.getIssue() == null)
                .map(book -> modelMapperService.forResponse().map(book, GetAllBookResponse.class))
                .collect(Collectors.toList());

    }


    @Override
    public List<GetAllBookResponse> findReservedBooks() {
        return bookRepository.findAll().stream()
                .filter(book -> book.getIssue() != null)
                .map(book -> modelMapperService.forResponse().map(book, GetAllBookResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void update(UpdateBookRequest updateBookRequest) {
        Book book = this.modelMapperService.forRequest().map(updateBookRequest, Book.class);
        this.bookRepository.save(book);


    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

}
