package Library.LibraryManagement.dataAccess.abstracts;

import Library.LibraryManagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Integer> {
}
