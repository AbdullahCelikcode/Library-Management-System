package Library.LibraryManagement.request;

import Library.LibraryManagement.entity.Category;
import Library.LibraryManagement.entity.Writer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRequest {
    @NotNull
    @NotBlank
    private int id;

    @NotNull
    @NotBlank
    private String isbn;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private int pageNumbers;

    @NotNull
    @NotBlank
    private int writerId;

    @NotNull
    @NotBlank
    private int categoryId;
}
