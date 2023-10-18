package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.BookService;
import Library.LibraryManagement.entity.Book;
import Library.LibraryManagement.request.CreateBookRequest;
import Library.LibraryManagement.request.UpdateBookRequest;
import Library.LibraryManagement.response.GetAllBookResponse;
import Library.LibraryManagement.response.GetByIdBookResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books/all")
    public List<GetAllBookResponse> findAll() {

        return bookService.findAll();
    }

    @GetMapping("/books/{bookId}")
    public GetByIdBookResponse getBookbyeId(@PathVariable int bookId) {

        return bookService.findById(bookId);
    }

    @PostMapping("/books/add")
    public void add(CreateBookRequest createBookRequest) {
        bookService.add(createBookRequest);

    }

    @GetMapping("/reciveableBooks")
    public List<GetAllBookResponse> reciveableBooks() {
        return bookService.findAllReciveableBooks();
    }

    @GetMapping("/reservedBooks")
    public  List<GetAllBookResponse> reservedBooks(){
        return  bookService.findReservedBooks();
    }
    @PutMapping("/books/update")
    public void updateBookRequest(@RequestBody UpdateBookRequest updateBookRequest){
       bookService.update(updateBookRequest);

    }
    @DeleteMapping("/books/delete")
    public void deleteBook(int id){
        bookService.deleteById(id);
    }
}
