package Library.LibraryManagement.dataAccess.abstracts;

import Library.LibraryManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
