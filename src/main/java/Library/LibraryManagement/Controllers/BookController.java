package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.BookService;
import Library.LibraryManagement.request.CreateBookRequest;
import Library.LibraryManagement.request.UpdateBookRequest;
import Library.LibraryManagement.response.GetAllBookResponse;
import Library.LibraryManagement.response.GetByIdBookResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping()
    public List<GetAllBookResponse> findAll() {

        return bookService.findAll();
    }

    @GetMapping("/{bookId}")
    public GetByIdBookResponse getBookbyeId(@PathVariable int bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(CreateBookRequest createBookRequest) {
        bookService.add(createBookRequest);

    }

    @GetMapping("/receivableBooks")
    public List<GetAllBookResponse> receivableBooks() {

        return bookService.findAllReceivableBooks();
    }

    @GetMapping("/reservedBooks")
    public List<GetAllBookResponse> reservedBooks() {
        return bookService.findReservedBooks();
    }

    @PutMapping()
    public void updateBookRequest(@RequestBody UpdateBookRequest updateBookRequest) {
        bookService.update(updateBookRequest);

    }

    @DeleteMapping()
    public void deleteBook(int id) {
        bookService.deleteById(id);
    }
}
