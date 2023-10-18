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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookManager implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllBookResponse> findAll() {
        List<Book> books = bookRepository.findAll();
        List<GetAllBookResponse> bookResponses = books.stream().map(book ->
                this.modelMapperService.forResponse().map(book, GetAllBookResponse.class)).collect(Collectors.toList());

        return bookResponses;

    }


    @Override
    public GetByIdBookResponse findById(int id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book is not found"));;
        GetByIdBookResponse response = this.modelMapperService.forResponse().map(book, GetByIdBookResponse.class);
        return response;
    }

    @Override
    public void add(CreateBookRequest createBookRequest) {
        Book book = this.modelMapperService.forRequest().map(createBookRequest, Book.class);
        bookRepository.save(book);
    }

    @Override
    public List<GetAllBookResponse> findAllReciveableBooks() {
        List<GetAllBookResponse> responses = bookRepository.findAll().stream()
                .filter(book -> book.getIssue() == null)
                .map(book -> modelMapperService.forResponse().map(book, GetAllBookResponse.class))
                .collect(Collectors.toList());
        return responses;
    }


    @Override
    public List<GetAllBookResponse> findReservedBooks() {
        List<GetAllBookResponse> responses = bookRepository.findAll().stream()
                .filter(book -> book.getIssue() != null)
                .map(book -> modelMapperService.forResponse().map(book, GetAllBookResponse.class))
                .collect(Collectors.toList());

        return responses;
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
