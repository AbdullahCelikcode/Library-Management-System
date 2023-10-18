package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.WriterService;
import Library.LibraryManagement.request.CreateWriterRequest;
import Library.LibraryManagement.request.UpdateWriterRequest;
import Library.LibraryManagement.response.GetAllWriterResponse;
import Library.LibraryManagement.response.GetByIdWriterResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WriterController {
    private final WriterService writerService;

    @GetMapping("/writers/all")
    public List<GetAllWriterResponse> getAll() {
        return writerService.findAll();
    }

    @GetMapping("/writers/{writerId}")
    public GetByIdWriterResponse getByIdCategoryResponse(@PathVariable int writerId) {
        return writerService.findById(writerId);
    }

    @PostMapping("/writers/add")
    public void add(CreateWriterRequest createWriterRequest) {
        writerService.add(createWriterRequest);

    }

    @PutMapping("/writers/update")
    public void update(@RequestBody UpdateWriterRequest updateWriterRequest) {
        writerService.update(updateWriterRequest);
    }

    @DeleteMapping("/writers/delete")
    public void delete(int id) {
        writerService.deleteById(id);
    }
}
