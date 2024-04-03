package co.sophea.cambodiaaccessoryapi.api.product.web;


import lombok.Builder;

import java.util.List;

@Builder
public record ProductDto(String uuid,
                         String name,
                         Integer quantity,
                         Float price,
                         List<String> images) {
}
