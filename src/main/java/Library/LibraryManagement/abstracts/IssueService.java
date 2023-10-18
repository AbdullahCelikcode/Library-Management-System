package Library.LibraryManagement.abstracts;

import Library.LibraryManagement.request.CreateIssueRequest;
import Library.LibraryManagement.request.UpdateIssueRequest;
import Library.LibraryManagement.response.GetAllIssueResponse;
import Library.LibraryManagement.response.GetByIdIssueResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IssueService {


    ResponseEntity<String> addIssue(CreateIssueRequest createIssueRequest);

    public List<GetAllIssueResponse> getAll();

    void update(UpdateIssueRequest updateIssueRequest);

    void deleteById(int id);

    GetByIdIssueResponse getById(int id);
}
