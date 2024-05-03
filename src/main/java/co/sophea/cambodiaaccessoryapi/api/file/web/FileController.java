package co.sophea.cambodiaaccessoryapi.api.file.web;

import co.sophea.cambodiaaccessoryapi.api.file.FileDto;
import co.sophea.cambodiaaccessoryapi.api.file.FileService;
import co.sophea.cambodiaaccessoryapi.base.BaseRest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static co.sophea.cambodiaaccessoryapi.api.file.FileServiceImpl.MAIN_FOLDER;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class FileController {

    private final FileService fileService;


    @PostMapping("/single-file")
    public BaseRest<?> uploadFile(@RequestPart MultipartFile file) {

        FileDto fileDto = fileService.uploadSingle(file);

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("File has been uploaded")
                .timestamp(LocalDateTime.now())
                .data(fileDto)
                .build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Resource> findByName(@PathVariable String name) throws IOException {

        String fullPath = MAIN_FOLDER + "upload/" + name;

        Path filePath = Paths.get(fullPath);

        Resource resource = new FileSystemResource(filePath);

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

}
