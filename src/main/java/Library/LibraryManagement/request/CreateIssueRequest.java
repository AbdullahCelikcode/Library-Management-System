package Library.LibraryManagement.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIssueRequest {
    private String returnDate;
    private int bookId;
    private int userId;
}
