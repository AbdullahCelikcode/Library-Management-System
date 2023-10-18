package Library.LibraryManagement.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllWriterResponse {
    private int id;
    private String name;
    private String surName;

}
