package Library.LibraryManagement.response;

import Library.LibraryManagement.entity.Category;
import Library.LibraryManagement.entity.Issue;
import Library.LibraryManagement.entity.Writer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBookResponse {
    private int id;
    private String isbn;
    private String name;
    private int pageNumbers;
    private Writer writer;
    private Category category;
    private Issue issue;
}
