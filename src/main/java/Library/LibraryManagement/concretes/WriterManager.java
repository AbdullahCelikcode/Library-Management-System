package Library.LibraryManagement.concretes;

import Library.LibraryManagement.abstracts.WriterService;
import Library.LibraryManagement.dataAccess.abstracts.WriterRepository;
import Library.LibraryManagement.entity.Writer;
import Library.LibraryManagement.mappers.ModelMapperService;
import Library.LibraryManagement.request.CreateWriterRequest;
import Library.LibraryManagement.request.UpdateWriterRequest;
import Library.LibraryManagement.response.GetAllWriterResponse;
import Library.LibraryManagement.response.GetByIdWriterResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WriterManager implements WriterService {
    private final ModelMapperService modelMapperService;
    private final WriterRepository writerRepository;

    @Override
    public void add(CreateWriterRequest CreateWriterRequest) {
        Writer writer = this.modelMapperService.forRequest()
                .map(CreateWriterRequest, Writer.class);
        writerRepository.save(writer);
    }

    @Override
    public List<GetAllWriterResponse> findAll() {

        List<Writer> writers = writerRepository.findAll();
        return writers.stream().map(writer ->
                this.modelMapperService.forResponse()
                        .map(writer, GetAllWriterResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetByIdWriterResponse findById(int id) {
        Writer writer = this.writerRepository.findById(id).orElseThrow(() -> new RuntimeException("Writer is not found"));
        return this.modelMapperService.forResponse()
                .map(writer, GetByIdWriterResponse.class);
    }

    @Override
    public void update(UpdateWriterRequest updateWriterRequest) {
        Writer writer = this.modelMapperService.forRequest()
                .map(updateWriterRequest, Writer.class);
        this.writerRepository.save(writer);
    }

    @Override
    public void deleteById(int id) {
        writerRepository.deleteById(id);

    }
}
