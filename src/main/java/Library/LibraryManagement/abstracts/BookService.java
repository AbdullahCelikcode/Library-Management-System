package Library.LibraryManagement.abstracts;

import Library.LibraryManagement.request.CreateBookRequest;
import Library.LibraryManagement.request.UpdateBookRequest;
import Library.LibraryManagement.response.GetAllBookResponse;
import Library.LibraryManagement.response.GetByIdBookResponse;

import java.util.List;

public interface BookService {
    List<GetAllBookResponse> findAll();

    GetByIdBookResponse findById(int id);

    void add(CreateBookRequest createBookRequest);

    List<GetAllBookResponse> findAllReceivableBooks();

    List<GetAllBookResponse> findReservedBooks();

    void update(UpdateBookRequest updateBookRequest);

    void deleteById(int id);
}
