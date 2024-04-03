package co.sophea.cambodiaaccessoryapi.api.product;

import co.sophea.cambodiaaccessoryapi.api.product.web.ProductDto;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    void createNewProduct(ProductDto productDto);
}
