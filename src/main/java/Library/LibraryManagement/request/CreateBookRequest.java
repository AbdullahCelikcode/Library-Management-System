package Library.LibraryManagement.request;

import Library.LibraryManagement.entity.Category;
import Library.LibraryManagement.entity.Writer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBookRequest {
    private String isbn;
    private String name;
    private int pageNumbers;
    private int writerId;
    private int categoryId;
}
