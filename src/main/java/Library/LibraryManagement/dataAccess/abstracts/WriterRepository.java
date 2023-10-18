package Library.LibraryManagement.dataAccess.abstracts;

import Library.LibraryManagement.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer,Integer> {
}
