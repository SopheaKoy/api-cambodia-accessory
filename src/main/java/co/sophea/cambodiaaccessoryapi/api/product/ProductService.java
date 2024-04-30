package co.sophea.cambodiaaccessoryapi.api.product;

import co.sophea.cambodiaaccessoryapi.api.product.web.ProductDto;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    Object createNewProduct(ProductDto productDto);
    void deleteProductById(int id);
}
