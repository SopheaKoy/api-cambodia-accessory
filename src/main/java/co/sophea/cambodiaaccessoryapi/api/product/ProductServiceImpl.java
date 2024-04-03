package co.sophea.cambodiaaccessoryapi.api.product;

import co.sophea.cambodiaaccessoryapi.api.product.web.ProductDto;
import co.sophea.cambodiaaccessoryapi.contrain.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void createNewProduct(ProductDto productDto) {

        Product product =  Product.builder()
                .uuid(UUID.randomUUID().toString())
                .productName(productDto.name())
                .price(productDto.price())
                .quantity(productDto.quantity())
                .status(StatusEnum.DELETED.toString())
                .createdAt(LocalDateTime.now())
                .build();
        System.out.println(StatusEnum.ACTIVE);

        productRepository.save(product);

    }

}
