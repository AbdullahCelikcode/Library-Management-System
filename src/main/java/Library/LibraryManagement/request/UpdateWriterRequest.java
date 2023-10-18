package Library.LibraryManagement.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateWriterRequest {
    private int id;
    private String name;
    private String surName;

}
