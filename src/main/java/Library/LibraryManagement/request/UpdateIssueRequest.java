package Library.LibraryManagement.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIssueRequest {
    @NotNull
    @NotBlank
    private int id;

    @NotNull
    @NotBlank
    private String returnDate;

    @NotNull
    @NotBlank
    private int bookId;

    @NotNull
    @NotBlank
    private int userId;
}
