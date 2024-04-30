package co.sophea.cambodiaaccessoryapi.api.product.web;

import co.sophea.cambodiaaccessoryapi.api.product.Product;
import co.sophea.cambodiaaccessoryapi.api.product.ProductService;
import co.sophea.cambodiaaccessoryapi.base.BaseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
//    List<Product>
    @GetMapping("/all")
    BaseRest<List<Product>> getAllProduct(){
        return BaseRest.<List<Product>>builder()
                .message("Get All Product Success")
                .code(HttpStatus.OK.value())
                .data(productService.getAllProduct())
                .timestamp(LocalDateTime.now())
                .status(true)
                .build();
    }

    @PostMapping
    BaseRest<?> saveProduct(@RequestBody ProductDto productDto){
        Product product = (Product) productService.createNewProduct(productDto);
        return BaseRest.builder()
                .message("Create Product Success")
                .status(true)
                .data(productDto)
               .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .build();
//        productService.createNewProduct(productDto);
    }
    @DeleteMapping("/{id}")
    BaseRest<?> deleteProductById(@PathVariable int id){
    productService.deleteProductById(id);
        return BaseRest.builder()
                .timestamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .data(id)
                .message("Delete Product Success")
                .status(true)
                .build();
    }
}
