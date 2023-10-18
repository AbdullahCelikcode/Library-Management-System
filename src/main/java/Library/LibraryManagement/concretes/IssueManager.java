package Library.LibraryManagement.concretes;

import Library.LibraryManagement.abstracts.IssueService;
import Library.LibraryManagement.dataAccess.abstracts.BookRepository;
import Library.LibraryManagement.dataAccess.abstracts.IssueRepository;
import Library.LibraryManagement.dataAccess.abstracts.UserRepository;
import Library.LibraryManagement.entity.Book;
import Library.LibraryManagement.entity.Issue;
import Library.LibraryManagement.mappers.ModelMapperService;
import Library.LibraryManagement.request.CreateIssueRequest;
import Library.LibraryManagement.response.GetAllBookResponse;
import Library.LibraryManagement.response.GetAllIssueResponse;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IssueManager implements IssueService {
    private final IssueRepository issueRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public ResponseEntity<String> addIssue(CreateIssueRequest createIssueRequest) {
        Issue issue = this.modelMapperService.forRequest().map(createIssueRequest, Issue.class);
        issue.setIssueDate(LocalDate.now().toString());
        this.issueRepository.save(issue);
        return ResponseEntity.ok("Kaydedildi");
    }

    public List<GetAllIssueResponse> getAll() {
        List<Issue> issues = issueRepository.findAll();
        List<GetAllIssueResponse> result = issues.stream().map(issue ->
                this.modelMapperService.forResponse().map(issue, GetAllIssueResponse.class)).collect(Collectors.toList());
        return result;

    }

}
