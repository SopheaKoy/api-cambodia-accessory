package co.sophea.cambodiaaccessoryapi.api.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    FileDto uploadSingle(MultipartFile file);

    List<FileDto> uploadMultiple(List<MultipartFile> files);

}
