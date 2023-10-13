package Library.LibraryManagement.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  // @ManyToOne
  // @JoinColumn(name = "user_id")
  // private User user;

   // @ManyToOne()
   //  @JoinColumn(name = "writers_id")
   // private int writerId;






}
