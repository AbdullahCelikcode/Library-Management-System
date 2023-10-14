package Library.LibraryManagement.concretes;

import Library.LibraryManagement.abstracts.BookService;
import Library.LibraryManagement.dataAccess.abstracts.BookRepository;
import Library.LibraryManagement.dataAccess.abstracts.UserRepository;
import Library.LibraryManagement.entity.Book;
import Library.LibraryManagement.entity.User;
import Library.LibraryManagement.response.GetAllBookResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookManager implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    @Override
    public List<GetAllBookResponse> findAll() {
        List<Book> books= (List<Book>) bookRepository.findAll();
        List<GetAllBookResponse> bookResponses=new ArrayList<GetAllBookResponse>();

       for( Book book: books) {
            GetAllBookResponse responseItem=new GetAllBookResponse();
            responseItem.setId(book.getId());
            responseItem.setIsbn(book.getIsbn());
            responseItem.setName(book.getName());
            responseItem.setPageNumbers(book.getPageNumbers());
            responseItem.setAmount(book.getAmount());
            responseItem.setUserId(book.getUser().getId());
            bookResponses.add(responseItem);

        }
        return bookResponses;

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

    @Override
    public List<Book> getAll() {

        return  bookRepository.findAll();
    }


}
