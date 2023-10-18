package Library.LibraryManagement.abstracts;

import Library.LibraryManagement.request.CreateWriterRequest;
import Library.LibraryManagement.request.UpdateWriterRequest;
import Library.LibraryManagement.response.GetAllWriterResponse;
import Library.LibraryManagement.response.GetByIdWriterResponse;

import java.util.List;

public interface WriterService {
    public void add(CreateWriterRequest CreateWriterRequest);

    List<GetAllWriterResponse> findAll();

    GetByIdWriterResponse findById(int id);

    void update(UpdateWriterRequest updateWriterRequest);
    void deleteById(int id);
}
