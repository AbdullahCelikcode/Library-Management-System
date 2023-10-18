package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.IssueService;
import Library.LibraryManagement.entity.Issue;
import Library.LibraryManagement.request.CreateIssueRequest;
import Library.LibraryManagement.response.GetAllIssueResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class IssueController {
    private final IssueService issueService;
    @PostMapping("/issue")
    public ResponseEntity<String> addIssue(@RequestBody()@Valid CreateIssueRequest createIssueRequest){

        return issueService.addIssue(createIssueRequest);
    }

    @GetMapping("/issue")
    public List<GetAllIssueResponse> getAll(){
        return issueService.getAll();

    }

}
