package co.sophea.cambodiaaccessoryapi.api.file;

import lombok.Builder;

@Builder
public record FileDto(String name,
                      String url,
                      String extension,

                      String previewUrl,
                      long size) {
}
