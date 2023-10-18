package Library.LibraryManagement.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdIssueResponse {
    private int id;
    private String issueDate;
    private String returnDate;
    private int bookId;
    private int userId;

}
