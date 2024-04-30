package co.sophea.cambodiaaccessoryapi.api.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Integer> {
    int deleteProductById(int id);
}
