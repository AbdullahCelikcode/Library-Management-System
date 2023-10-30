package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.WriterService;
import Library.LibraryManagement.request.CreateWriterRequest;
import Library.LibraryManagement.request.UpdateWriterRequest;
import Library.LibraryManagement.response.GetAllWriterResponse;
import Library.LibraryManagement.response.GetByIdWriterResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writer")
@AllArgsConstructor
public class WriterController {
    private final WriterService writerService;

    @GetMapping()
    public List<GetAllWriterResponse> getAll() {
        return writerService.findAll();
    }

    @GetMapping("/{writerId}")
    public GetByIdWriterResponse getByIdCategoryResponse(@PathVariable int writerId) {
        return writerService.findById(writerId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateWriterRequest createWriterRequest) {
        writerService.add(createWriterRequest);

    }

    @PutMapping()
    public void update(@RequestBody UpdateWriterRequest updateWriterRequest) {
        writerService.update(updateWriterRequest);
    }

    @DeleteMapping()
    public void delete(@PathVariable int id) {
        writerService.deleteById(id);
    }
}
