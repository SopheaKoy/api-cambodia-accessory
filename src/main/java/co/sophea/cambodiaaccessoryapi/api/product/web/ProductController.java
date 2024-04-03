package co.sophea.cambodiaaccessoryapi.api.product.web;

import co.sophea.cambodiaaccessoryapi.api.product.Product;
import co.sophea.cambodiaaccessoryapi.api.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/save")
    void saveProduct(@RequestBody ProductDto productDto){
        productService.createNewProduct(productDto);
    }
}
