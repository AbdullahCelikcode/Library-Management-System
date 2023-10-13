package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.BookService;
import Library.LibraryManagement.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BookController {

    private BookService bookService;
   @GetMapping("/books")
    public List<Book> findAll(){

        return bookService.findAll();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookbyeId(@PathVariable int bookId){
       Book book =bookService.findById(bookId);
       if (book==null) {throw new RuntimeException("Book id not found "+ bookId );}
       return book;
    }
    @PostMapping("/add")
    public void add(Book book){
       bookService.add(book);

    }

}
