package co.sophea.cambodiaaccessoryapi.api.product.web;


import lombok.Builder;

import java.util.List;

@Builder
public record ProductDto(String uuid,
                         String name,
                         String type,
                         Float price,
                         String description,
                         List<String> images) {
}
