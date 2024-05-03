package co.sophea.cambodiaaccessoryapi.api.file;

import co.sophea.cambodiaaccessoryapi.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{
    public static final String MAIN_FOLDER = "src/main/java/co/sophea/cambodiaaccessoryapi/";
    public static final String FILE_BASE_URL = "http://localhost:8081/api/v1/files/";

    private final FileUtil fileUtil;

    public FileDto uploadSingle(MultipartFile file) {

        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        String extension = getExtension(file.getOriginalFilename());

        String name = String.format("%s.%s", UUID.randomUUID(), extension);

        String newFileName = UUID.randomUUID() + ".png";

        String url = String.format("%s%s", FILE_BASE_URL, newFileName);

        long size = file.getSize();

        // Construct the folder path
        String folderPath = MAIN_FOLDER + "upload/";

        File directory = new File(folderPath);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Construct the file path
        Path filePath = Paths.get(folderPath + newFileName);

        // Copy the file to the server
        try {
            Files.copy(file.getInputStream(), filePath);

            return FileDto.builder()
                    .name(name)
                    .url(url)
                    .extension(extension)
                    .size(size)
                    .build();

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }


    @Override
    public FileDto findByName(String name) throws IOException {

        Resource resource = fileUtil.findByName(name);

        return FileDto.builder()

                .name(resource.getFilename())

                .extension(getExtension(resource.getFilename()))

                .url(String.format("%s%s", FILE_BASE_URL, resource.getFilename()))

                .size(resource.contentLength())

                .build();
    }


    private String getExtension(String fileName) {

        int lastDotIndex = fileName.lastIndexOf(".");
        return fileName.substring(lastDotIndex + 1);
    }

}
