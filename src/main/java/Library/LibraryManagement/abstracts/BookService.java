package Library.LibraryManagement.abstracts;

import Library.LibraryManagement.entity.Book;
import Library.LibraryManagement.response.GetAllBookResponse;

import java.util.List;

public interface BookService {
   List<GetAllBookResponse> findAll();
   Book findById(int id);

   void add(Book book);
   List<Book> getAll();
}
