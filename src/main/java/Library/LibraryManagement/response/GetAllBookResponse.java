package Library.LibraryManagement.response;

import Library.LibraryManagement.entity.Book;
import Library.LibraryManagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllBookResponse {
    private int id;
    private String isbn;
    private String name;
    private int pageNumbers;
    private int amount;
    private int userId;


}
