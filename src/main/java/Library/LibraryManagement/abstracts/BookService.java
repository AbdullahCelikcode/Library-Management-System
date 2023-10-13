package Library.LibraryManagement.abstracts;

import Library.LibraryManagement.entity.Book;

import java.util.List;

public interface BookService {
   List<Book> findAll();
   Book findById(int id);

   void add(Book book);
}
