package co.sophea.cambodiaaccessoryapi.api.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uuid;
    @Column(name = "first_name" , length = 100)
    private String firstName;

    @Column(name = "last_name" , length = 100)
    private String lastName;

    @Column(name = "phone_number" , length = 15)
    private String phoneNumber;

    @Column(unique = true , columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(unique = true , length = 100)
    private String password;

    private LocalDateTime dob;

    private String address;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private Boolean status;
}
