package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.IssueService;
import Library.LibraryManagement.entity.Issue;
import Library.LibraryManagement.request.CreateIssueRequest;
import Library.LibraryManagement.request.UpdateIssueRequest;
import Library.LibraryManagement.response.GetAllIssueResponse;
import Library.LibraryManagement.response.GetByIdIssueResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
@AllArgsConstructor
public class IssueController {
    private final IssueService issueService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addIssue(@RequestBody() @Valid CreateIssueRequest createIssueRequest) {

        return issueService.addIssue(createIssueRequest);
    }

    @GetMapping()
    public List<GetAllIssueResponse> getAll() {
        return issueService.getAll();

    }

    @PutMapping()
    public void updateIssue(@RequestBody UpdateIssueRequest updateIssueRequest) {
        issueService.update(updateIssueRequest);

    }

    @DeleteMapping()
    public void deleteById(@PathVariable int id) {
        issueService.deleteById(id);

    }

    @GetMapping("/{issueId}")
    public GetByIdIssueResponse getByIdIssue(@PathVariable int issueId) {
        return issueService.getById(issueId);
    }

}
