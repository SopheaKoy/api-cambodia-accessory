package co.sophea.cambodiaaccessoryapi.api.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    FileDto uploadSingle(MultipartFile file);

    FileDto findByName(String name) throws IOException;

}
