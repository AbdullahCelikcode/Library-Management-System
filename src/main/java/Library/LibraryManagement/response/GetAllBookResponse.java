package Library.LibraryManagement.response;

import Library.LibraryManagement.entity.Issue;
import Library.LibraryManagement.entity.Writer;
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
    private Writer writer;
    private Issue issue;


}
