package Library.LibraryManagement.response;

import Library.LibraryManagement.entity.Book;
import Library.LibraryManagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllIssueResponse {
    private int id;
    private String issueDate;
    private String returnDate;
    private int bookId;
    private int userId;


}
