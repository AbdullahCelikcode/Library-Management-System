package Library.LibraryManagement.dataAccess.abstracts;

import Library.LibraryManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findAllById(int bookId);
}
