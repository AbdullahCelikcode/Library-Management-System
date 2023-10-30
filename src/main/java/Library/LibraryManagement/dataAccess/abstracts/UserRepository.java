package Library.LibraryManagement.dataAccess.abstracts;

import Library.LibraryManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findAllById(int personId);

    User findByEmail(String email);
}
