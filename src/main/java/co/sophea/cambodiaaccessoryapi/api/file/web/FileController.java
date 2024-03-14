package co.sophea.cambodiaaccessoryapi.api.file.web;

import co.sophea.cambodiaaccessoryapi.api.file.FileDto;
import co.sophea.cambodiaaccessoryapi.api.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;
    @PostMapping(value = "/single", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileDto uploadSingle(@RequestPart MultipartFile file) {
        return fileService.uploadSingle(file);
    }

}
