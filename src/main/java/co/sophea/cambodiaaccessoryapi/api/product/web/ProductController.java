package co.sophea.cambodiaaccessoryapi.api.product.web;

import co.sophea.cambodiaaccessoryapi.api.product.Product;
import co.sophea.cambodiaaccessoryapi.api.product.ProductService;
import co.sophea.cambodiaaccessoryapi.base.BaseRest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductDto productDto) {

        try {
            Product product = (Product) productService.createNewProduct(productDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(BaseRest.builder()
                    .message("Create Product Success")
                    .status(true)
                    .data(product)
                    .code(HttpStatus.CREATED.value())
                    .timestamp(LocalDateTime.now())
                    .build());
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BaseRest.builder()
                    .message("Failed to create product")
                    .status(false)
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .timestamp(LocalDateTime.now())
                    .build());
        }
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
