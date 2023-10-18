package Library.LibraryManagement.abstracts;

import Library.LibraryManagement.entity.Issue;
import Library.LibraryManagement.request.CreateIssueRequest;
import Library.LibraryManagement.response.GetAllIssueResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IssueService {


    ResponseEntity<String> addIssue(CreateIssueRequest createIssueRequest);

    public List<GetAllIssueResponse> getAll();
}
