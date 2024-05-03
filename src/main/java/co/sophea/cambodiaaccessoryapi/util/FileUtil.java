package co.sophea.cambodiaaccessoryapi.util;

import lombok.Getter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@Getter
public class FileUtil {

    public static final String FILE_SERVER_PATH = "src/main/java/co/sophea/cambodiaaccessoryapi/upload/";

    public Resource findByName(String name) {

        Path path = Paths.get(FILE_SERVER_PATH + name);

        System.out.println("FILE SERVER PATH :: " + FILE_SERVER_PATH);
        try {
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                return resource;
            }

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "File is not found!");
        } catch (MalformedURLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());
        }
    }

}
