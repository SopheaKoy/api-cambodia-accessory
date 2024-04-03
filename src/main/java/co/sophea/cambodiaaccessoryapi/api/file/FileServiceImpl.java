package co.sophea.cambodiaaccessoryapi.api.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{
    public static final String MAIN_FOLDER = "src/main/java/co/sophea/cambodiaaccessoryapi/";


    public FileDto uploadSingle(MultipartFile file) {

        // Check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        String fileName = file.getOriginalFilename();
        String extension = getExtension(fileName);
        String newFileName = UUID.randomUUID() + "." + extension;

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
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }

        // Construct and return the FileDto object



        return null;
    }

    @Override
    public List<FileDto> uploadMultiple(List<MultipartFile> files) {
        return null;
    }


    private String getExtension(String fileName) {

        int lastDotIndex = fileName.lastIndexOf(".");
        return fileName.substring(lastDotIndex + 1);
    }
}
