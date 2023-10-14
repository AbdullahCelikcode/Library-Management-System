package Library.LibraryManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;

@Table(name = "books")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Book {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;

   @Column(name = "isbn")
   private String isbn;

   @Column(name = "name")
   private String name;

   @Column(name = "page_numbers")
   private int pageNumbers;

   @Column(name = "amount")
   private int amount;

   @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   @JsonIgnore
   @JoinColumn(name="user_id")
   private User user;

   // @ManyToOne()
   //  @JoinColumn(name = "writers_id")
   // private int writerId;






}
