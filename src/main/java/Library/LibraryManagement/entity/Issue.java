package Library.LibraryManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "issues")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String issueDate;

    private String returnDate;

    @OneToOne()
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    @JsonIgnore
    private Book book;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;


}
