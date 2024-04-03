package co.sophea.cambodiaaccessoryapi.api.product;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pro_uuid")
    private String uuid;

    @Column(name = "product_name" , length = 100)
    private String productName;

    @Column(name = "price")
    private Float price;

    @Column(nullable = false)
    private Integer quantity;

    private String image;

    private String description;

    // Field management system
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    private String status;

}
